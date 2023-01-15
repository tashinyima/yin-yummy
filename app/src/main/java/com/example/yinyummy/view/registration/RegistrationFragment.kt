package com.example.yinyummy.view.registration

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.yinyummy.R
import com.example.yinyummy.databinding.FragmentRegistrationBinding
import com.example.yinyummy.model.User
import com.example.yinyummy.utils.RegisterFieldsState
import com.example.yinyummy.utils.RegisterValidation
import com.example.yinyummy.utils.Resource
import com.example.yinyummy.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.withContext


private val TAG = "RegistrationFragment"

@AndroidEntryPoint
class RegistrationFragment : Fragment() {

    private val registerViewModel: RegisterViewModel by viewModels()

    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRegistrationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnRegister.setOnClickListener {

                val user = User(
                    etFamilyName.text.toString().trim(),
                    etGivenName.text.toString().trim(),
                    etEmail.text.toString().trim(),
                    etUsername.text.toString().trim(),
                    "",
                    0
                )

                val password = etPassword.text.toString()
                val cpaswword = etRetypePassword.text.toString()
                if (password.equals(cpaswword)) {

                    registerViewModel.createAccountWithEmailAndPassword(user, password)

                }


            }

            lifecycleScope.launchWhenStarted {
                registerViewModel.register.collect {
                    when (it) {
                        is Resource.Loading -> {
                            // binding.btnRegister.startAnimation()
                        }
                        is Resource.Success -> {
                            Log.d("Test", it.data.toString()+ "then here"+it.data?.uid.toString())
                            //binding.btnRegister.
                            findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
                        }
                        is Resource.Error -> {
                            Log.d(TAG, it.message.toString())
                        }
                        else -> Unit
                    }
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            registerViewModel.validation.collect{
               if(it.email is RegisterValidation.Failed){
                   withContext(Dispatchers.Main){
                       binding.etEmail.apply {
                           requestFocus()
                           error =it.email.message
                       }
                   }
               }

                if (it.password is RegisterValidation.Failed){
                    withContext(Dispatchers.Main){
                        binding.etPassword.apply {
                            requestFocus()
                            error = it.password.message
                        }
                    }
                }
            }
        }

        binding.txtHaveAcc.setOnClickListener {
            initAlreadyHaveAccount()
        }

    }


    private fun initAlreadyHaveAccount() {
        // redirect to the login page..
        findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)

    }


}