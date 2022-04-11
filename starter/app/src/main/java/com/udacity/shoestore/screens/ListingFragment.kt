package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ListingFragmentBinding
import timber.log.Timber

class ListingFragment : Fragment() {
    private lateinit var binding: ListingFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.listing_fragment,
            container,
            false
        )
        binding.buttonAdd.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(ListingFragmentDirections.actionListingFragmentToDetailFragment())
        }

        return binding.root
    }
}