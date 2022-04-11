package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.DetailFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.ShoeViewModel
import timber.log.Timber

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

        viewModel.eventNewShoeAdded.observe(
            viewLifecycleOwner,
            Observer { isNewShoeAdded: Boolean ->
                if (isNewShoeAdded) {
                    findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToListingFragment())
                    viewModel.onNewShoeAddedComplete()
                    viewModel.resetInput()
                    Timber.i("new shoe was added")
                }
            })

        viewModel.eventInvalidInfo.observe(viewLifecycleOwner,
            Observer { isInvalidInfo: Boolean ->
                if (isInvalidInfo) {
                    Toast.makeText(
                        requireActivity(),
                        getString(R.string.fill_full_detail_information_message),
                        Toast.LENGTH_SHORT
                    ).show()
                    viewModel.onInvalidInfoHandled()
                    Timber.i("InvalidInfo")
                }
            })

        binding.shoeViewModel = viewModel

        binding.buttonCancel.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(DetailFragmentDirections.actionDetailFragmentToListingFragment())
            viewModel.resetInput()
        }
        return binding.root
    }
}
