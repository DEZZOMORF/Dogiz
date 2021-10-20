package com.lampa.dogiz.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.lampa.dogiz.databinding.FragmentHubBinding
import com.lampa.dogiz.model.CheckCodeResponse
import com.lampa.dogiz.util.Loger
import com.lampa.dogiz.viewmodel.HubViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HubFragment : Fragment() {

    private val viewModel: HubViewModel by viewModels()
    private lateinit var binding: FragmentHubBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHubBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val checkCodeResponse = requireArguments().getParcelable<CheckCodeResponse>("data")
        Loger(checkCodeResponse.toString())
    }
}