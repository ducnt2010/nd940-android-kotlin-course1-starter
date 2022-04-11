package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding
import timber.log.Timber

class LoginFragment : Fragment() {
    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.login_fragment,
            container,
            false
        )

        binding.buttonLogin.setOnClickListener { view: View ->
            if (binding.usernameInputEditText.text.toString() == "myemail"
                && binding.passwordInputEditText.text.toString() == "1234"
            ) {
                Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_welcomeFragment)
            } else {
                Toast.makeText(
                    activity,
                    getString(R.string.login_error_message),
                    Toast.LENGTH_SHORT
                ).show()
                Timber.i("Invalid email or password!")
            }
        }

        binding.buttonLoginWithExistingAccount.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }
        return binding.root
    }
}