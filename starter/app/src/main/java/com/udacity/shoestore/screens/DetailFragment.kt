package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.DetailFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.ShoeViewModel

class DetailFragment : Fragment() {
    private lateinit var binding: DetailFragmentBinding
    private lateinit var viewModel: ShoeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.detail_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)

        binding.shoeViewModel = viewModel
        binding.buttonSave.setOnClickListener { view: View ->

        }
        return binding.root
    }

}