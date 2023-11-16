package com.syntax_institut.android_ta_apiwdh.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.syntax_institut.android_ta_apiwdh.adapter.DigimonAdapter
import com.syntax_institut.android_ta_apiwdh.databinding.FragmentDigimonBinding


class DigimonFragment: Fragment() {

    private lateinit var binding: FragmentDigimonBinding
    private val viewModel: DigimonViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDigimonBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.digimon.observe(viewLifecycleOwner){
            binding.rvFragment.adapter = DigimonAdapter(it, viewModel)
        }

        binding.btNextPage.setOnClickListener {
            viewModel.loadDigimonsPage()
        }

    }

}