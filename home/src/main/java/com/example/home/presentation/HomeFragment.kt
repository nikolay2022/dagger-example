package com.example.home.presentation

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
import com.example.home.R
import com.example.home.di.DaggerHomeComponent
import com.example.home.databinding.FragmentHomeBinding
import com.example.home.domain.models.TextItem
import javax.inject.Inject

/**
 * Created by Nikolay Yakushov on 03.08.2023.
 */

class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: HomeViewModelFactory

    private val registrationViewModel: HomeViewModel by viewModels { viewModelFactory }

    private lateinit var binding: FragmentHomeBinding

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
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = HomeAdapter(emptyList(), object : HomeAdapter.ItemClickListener {
            override fun onItemClicked(item: TextItem) {
                val bundle = Bundle().apply {
                    putString("key", item.id.toString())
                }
                findNavController().navigate(R.id.detailsFragment, bundle)
            }
        })

        registrationViewModel.dataLiveData.observe(viewLifecycleOwner) { data ->
            adapter.items = data
        }

        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter

        val textView: TextView = binding.textDashboard
        textView.text = registrationViewModel.getDashboardText()
    }
}
