package app.beer.fifi.ui.activities.auth.register.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.beer.fifi.R
import app.beer.fifi.databinding.FragmentRegisterNamesBinding

class RegisterSecondStepFragment : Fragment() {

    private lateinit var binding: FragmentRegisterNamesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterNamesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

}