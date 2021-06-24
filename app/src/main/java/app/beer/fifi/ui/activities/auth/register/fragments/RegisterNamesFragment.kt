package app.beer.fifi.ui.activities.auth.register.fragments

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import app.beer.fifi.R
import app.beer.fifi.databinding.FragmentRegisterNamesBinding

class RegisterNamesFragment : Fragment() {

    private lateinit var binding: FragmentRegisterNamesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterNamesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.nextBtn.setOnClickListener {
            val email = binding.emailInput.text.toString()
            val nickName = binding.nicknameInput.text.toString()
            val password = binding.passwordInput.text.toString()
            val confirmPassword = binding.confirmPasswordInput.text.toString()

            // validate fields
            if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.emailInput.error = getString(R.string.error_email)
                return@setOnClickListener
            }
            if (nickName.isEmpty()) {
                binding.nicknameInput.error = getString(R.string.nickname_hint)
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                binding.passwordInput.error = getString(R.string.password_hint)
                return@setOnClickListener
            }
            if (confirmPassword.isEmpty()) {
                binding.confirmPasswordInput.error = getString(R.string.password_confirm_hint)
                return@setOnClickListener
            }
            if (password != confirmPassword) {
                binding.confirmPasswordInput.error = getString(R.string.confirm_password_error)
                return@setOnClickListener
            }

            findNavController().navigate(
                R.id.action_registerNamesFragment_to_registerSecondStepFragment,
                Bundle().apply {

                }
            )
        }

        binding.emailInput.setOnEditorActionListener { v, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                checkEmail((v as EditText).text.toString())
            }
            true
        }

        binding.nicknameInput.setOnEditorActionListener { v, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                checkNickName((v as EditText).text.toString())
            }
            true
        }
    }

    /**
     * check if nick name is unique
     */
    private fun checkNickName(nickname: String) {
        // get nickname is unique in db if not offer same nicknames
    }

    /**
     * check if email is unique
     */
    private fun checkEmail(nickname: String) {
        // get email is unique in db
    }

}