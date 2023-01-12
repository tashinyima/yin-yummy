package com.example.yinyummy.view.registration

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.setContentView
import com.example.yinyummy.R
import com.example.yinyummy.databinding.FragmentRegistrationBinding
import com.example.yinyummy.view.login.LoginFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationFragment : Fragment() {

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
        binding.btnRegister.setOnClickListener {

            /*
            1: first validate the fields.
            2: store in firebase
            3: then store in local db
             */

            getRegistrationFields()

        }
        binding.txtHaveAcc.setOnClickListener {
            initAlreadyHaveAccount()
        }

    }

    private fun getRegistrationFields() {

    }

    private fun initAlreadyHaveAccount() {
        // redirect to the login page..

    }


}