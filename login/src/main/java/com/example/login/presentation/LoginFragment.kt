package com.example.login.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import com.example.login.R
import com.example.login.di.DaggerLoginComponent
import com.example.login.databinding.FragmentLoginBinding
import javax.inject.Inject

/**
 * Created by Nikolay Yakushov on 03.08.2023.
 */

class LoginFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: LoginViewModelFactory

    private val registrationViewModel: LoginViewModel by viewModels { viewModelFactory }

    private lateinit var binding: FragmentLoginBinding

    override fun onAttach(context: Context) {
        //такие вещи можно вынести в холдер, можно в абстарктный класс
        DaggerLoginComponent.builder().build().inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registrationViewModel.authSuccessLiveData.observe(viewLifecycleOwner) { isAuthSuccessful ->
            if (isAuthSuccessful) {
                binding.errorText.visibility = View.GONE
                val request = NavDeepLinkRequest.Builder
                    .fromUri("android-app://com.example.dagger_pet/home_fragment".toUri())
                    .build()
                findNavController().navigate(request)
            } else {
                binding.errorText.visibility = View.VISIBLE
                binding.errorText.text = getString(R.string.loginOrPasswordError)
            }
        }

        binding.homeButton.setOnClickListener {
            val email = binding.editTextLogin.text.toString()
            val password = binding.editTextPassword.text.toString()
            registrationViewModel.auth(email, password)
        }

        val textView: TextView = binding.textLogin
        textView.text = registrationViewModel.getLoginText()
    }
}
