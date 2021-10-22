package com.lampa.dogiz.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.lampa.dogiz.R
import com.lampa.dogiz.databinding.FragmentHubBinding
import com.lampa.dogiz.model.login.LoginCheckCodeResponse
import com.lampa.dogiz.util.Loger
import com.lampa.dogiz.util.UiState
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

        setHubObserver()
        val loginResponse = requireArguments().getParcelable<LoginCheckCodeResponse>("data")
        viewModel.getData()
    }

    private fun setHubObserver() {
        viewModel.setPhoneUiState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is UiState.Loading -> displayProgressBar(true)
                is UiState.Success -> {
                    displayProgressBar(false)
                    state.data?.let { data ->
                        //TODO
                    }
                }
                is UiState.Error -> {
                    displayProgressBar(false)
                    displayError(state.error.message)
                }
            }
        }
    }

    private fun displayProgressBar(isDisplayed: Boolean) {
        binding.progressBar.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }

    private fun displayError(message: String?) {
        if (message != null) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, resources.getString(R.string.default_error_message), Toast.LENGTH_LONG).show()
        }
    }
}