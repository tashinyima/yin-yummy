package com.example.yinyummy.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yinyummy.model.User
import com.example.yinyummy.utils.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val firebaseAuth: FirebaseAuth) :
    ViewModel() {

    private val _register = MutableStateFlow<Resource<FirebaseUser>>(Resource.Unspecified())
    val register: Flow<Resource<FirebaseUser>> = _register

    private val _validation = Channel<RegisterFieldsState>()
    val validation = _validation.receiveAsFlow()
    fun createAccountWithEmailAndPassword(user: User, password: String) {

        if (checkValidation(user,password)){

            Log.d("TESS",user.email.toString())
            viewModelScope.launch {
                _register.emit(Resource.Loading())

            }
            firebaseAuth.createUserWithEmailAndPassword(user.email!!, password)
                .addOnSuccessListener {

                    it.user?.let {
                        _register.value = Resource.Success(it)
                    }

                }.addOnFailureListener {

                    _register.value = Resource.Error(it.message.toString())

                }

        }else
        {
            val registerFieldState = RegisterFieldsState(validateEmail(user.email),
                validatePassword(password)
            )

            viewModelScope.launch {
                _validation.send(registerFieldState)
            }



        }


    }

    private fun checkValidation(user: User, password: String): Boolean {
        val emailValidation = validateEmail(user.email)
        val passwordValidation = validatePassword(password)
        return emailValidation is RegisterValidation.Success && passwordValidation is RegisterValidation.Success
    }




}