package com.example.yinyummy.view.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.yinyummy.MainActivity
import com.example.yinyummy.R
import com.example.yinyummy.databinding.FragmentLoginBinding
import com.example.yinyummy.utils.Resource
import com.example.yinyummy.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val viewModel by viewModels<LoginViewModel>()

    private var _binding: FragmentLoginBinding? = null
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
        _binding = FragmentLoginBinding.inflate(layoutInflater)
        binding.tvRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }
//        binding.btnLogin.setOnClickListener {
//            val intent = Intent(activity, MainActivity::class.java)
//            startActivity(intent)
//        }
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnLogin.setOnClickListener {
                val email = etEmail.text.toString().trim()
                val password = etPassword.text.toString()
                viewModel.login(email,password)

            }
        }

        lifecycleScope.launchWhenStarted {

            viewModel.login.collect{
                when(it){
                    is Resource.Loading -> {

                    }
                    is Resource.Success -> {

                        Intent(requireActivity(),MainActivity::class.java).also { intent ->
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            startActivity(intent)

                        }
                    }
                    is Resource.Error -> {
                        Toast.makeText(requireContext(),it.message,Toast.LENGTH_SHORT).show()
                    }
                    else -> Unit
                }
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}