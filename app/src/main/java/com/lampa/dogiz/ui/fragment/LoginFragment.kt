package com.lampa.dogiz.ui.fragment

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.lampa.dogiz.R
import com.lampa.dogiz.databinding.FragmentLoginBinding
import com.lampa.dogiz.model.Step
import com.lampa.dogiz.util.UiState
import com.lampa.dogiz.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        phoneView()
        setPhoneObserver()
        checkCodeObserver()
    }

    private fun setPhoneObserver() {
        viewModel.setPhoneUiState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is UiState.Loading -> displayProgressBar(true)
                is UiState.Success -> {
                    displayProgressBar(false)
                    hideKeyboardFrom()
                    state.data?.let { data ->
                        codeView(data.code)
                    }
                }
                is UiState.Error -> {
                    displayProgressBar(false)
                    displayError(state.error.message)
                }
            }
        }
    }

    private fun checkCodeObserver() {
        viewModel.checkCodeUiState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is UiState.Loading -> displayProgressBar(true)
                is UiState.Success -> {
                    displayProgressBar(false)
                    binding.inputErrHint.text = ""
                    state.data?.let { data ->
                        when(data.step) {
                            Step.SIGNUP -> {
                                //TODO
                            }
                            Step.HUB -> {
                                //TODO
                            }
                        }
                    }
                }
                is UiState.Error -> {
                    displayError(state.error.message)
                    displayProgressBar(false)
                    binding.inputErrHint.text =
                        resources.getString(R.string.login_err_code_subtitle)
                }
            }
        }
    }

    private fun displayProgressBar(isDisplayed: Boolean) {
        binding.progressBar.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }

    private fun displayError(message: String?) {
        if (message != null) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Unknown error", Toast.LENGTH_SHORT).show()
        }
    }

    private fun phoneView() {
        with(binding) {
            title.text = resources.getString(R.string.login_phone_title)
            subtitle.text = resources.getString(R.string.login_phone_subtitle)
            inputHint.text = resources.getString(R.string.login_phone_hint)
            btnBack.visibility = View.GONE
            inputErrHint.text = ""
            phoneNumberCardView.visibility = View.VISIBLE
            codeInputInclude.root.visibility = View.INVISIBLE
            btnContinue.setOnClickListener {
                viewModel.setPhone(phoneNumberInput.text.toString())
            }
        }

    }

    private fun codeView(code: Int) {
        with(binding) {
            title.text = resources.getString(R.string.login_code_title)
            subtitle.text = resources.getString(R.string.login_code_subtitle)
            inputHint.text = resources.getString(R.string.login_code_hint)
            phoneNumberCardView.visibility = View.INVISIBLE
            btnBack.visibility = View.VISIBLE
            btnBack.setOnClickListener { phoneView() }
            btnContinue.setOnClickListener {
                viewModel.checkCode(getCodeFromInputs())
            }
            with(codeInputInclude) {
                root.visibility = View.VISIBLE
                digit0.setText(code.toString()[0].toString())
                digit1.setText(code.toString()[1].toString())
                digit2.setText(code.toString()[2].toString())
                digit3.setText(code.toString()[3].toString())
                digit4.setText(code.toString()[4].toString())
                digit5.setText(code.toString()[5].toString())
            }
        }
    }

    private fun getCodeFromInputs(): Int {
        return with(binding.codeInputInclude) {
            StringBuilder()
                .append(digit0.text)
                .append(digit1.text)
                .append(digit2.text)
                .append(digit3.text)
                .append(digit4.text)
                .append(digit5.text)
                .toString()
                .toInt()
        }
    }

    private fun hideKeyboardFrom() {
        (requireContext().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
            requireView().windowToken,
            0)
    }
}