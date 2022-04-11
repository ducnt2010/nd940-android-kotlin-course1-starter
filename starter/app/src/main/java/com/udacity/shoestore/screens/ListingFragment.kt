package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ListingFragmentBinding
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.ShoeViewModel
import timber.log.Timber

class ListingFragment : Fragment() {
    private lateinit var binding: ListingFragmentBinding
    private lateinit var viewModel: ShoeViewModel
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
        Timber.i("onCreateView")
        viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)

        viewModel.listShoe.observe(viewLifecycleOwner, Observer { listShoe: MutableList<Shoe> ->
            for (shoe in listShoe) {
                addShoeItem(shoe)
            }
        })

        binding.buttonAdd.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(ListingFragmentDirections.actionListingFragmentToDetailFragment())
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.nav_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun addShoeItem(shoe: Shoe) {
        var itemView = DataBindingUtil.inflate<ShoeItemBinding>(
            layoutInflater,
            R.layout.shoe_item,
            null,
            false
        )

        itemView.shoeItem = shoe
        binding.layoutListItem.addView(itemView.root)
    }

//    override fun onStart() {
//        super.onStart()
//        Timber.i("onStart")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Timber.i("onResume")
//
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Timber.i("onPause")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Timber.i("onStop")
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        Timber.i("onDestroyView")
//    }
}