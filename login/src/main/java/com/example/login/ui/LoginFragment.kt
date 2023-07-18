package com.example.login.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.login.di.DaggerLoginComponent
import com.example.mylibrary.databinding.FragmentLoginBinding
import javax.inject.Inject

/**
 * Created by Nikolay Yakushov on 15.07.2023.
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

        val textView: TextView = binding.textDashboard
        textView.text = registrationViewModel.getHui()
    }
}
