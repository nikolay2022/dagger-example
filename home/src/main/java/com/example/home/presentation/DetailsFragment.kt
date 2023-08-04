package com.example.home.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.home.databinding.FragmentDetailsBinding
import com.example.home.di.DaggerHomeComponent

/**
 * Created by Nikolay Yakushov on 04.08.2023.
 */
class DetailsFragment : Fragment() {

//    @Inject
//    lateinit var viewModelFactory: LoginViewModelFactory
//
//    private val registrationViewModel: LoginViewModel by viewModels { viewModelFactory }

    private lateinit var binding: FragmentDetailsBinding

    override fun onAttach(context: Context) {
        //такие вещи можно вынести в холдер, можно в абстарктный класс
        DaggerHomeComponent.builder().build().inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        // Извлекаем значение из Bundle
        val itemKey: String = arguments?.getString("key") ?: ""

        // Инициализируем ViewModel с использованием полученного значения
//        viewModel = ViewModelProvider(this, DetailViewModelFactory(itemKey)).get(DetailViewModel::class.java)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView: TextView = binding.textDashboard
    }

}