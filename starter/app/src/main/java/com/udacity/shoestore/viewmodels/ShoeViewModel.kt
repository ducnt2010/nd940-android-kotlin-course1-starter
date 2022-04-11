package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {
    private val _newShoe = MutableLiveData<Shoe>()
    val newShoe: LiveData<Shoe>
        get() = _newShoe

     var inputShoe= Shoe("", 0.0, "", "")

    init {
//        inputShoe = Shoe("", 0.0, "", "")
    }
}