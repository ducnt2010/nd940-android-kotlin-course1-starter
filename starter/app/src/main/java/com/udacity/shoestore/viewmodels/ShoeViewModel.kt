package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeViewModel : ViewModel() {
    private val _listShoe = MutableLiveData<MutableList<Shoe>>()
    val listShoe: LiveData<MutableList<Shoe>>
        get() = _listShoe

    private val _eventNewShoeAdded = MutableLiveData<Boolean>()
    val eventNewShoeAdded: LiveData<Boolean>
        get() = _eventNewShoeAdded

    private val _eventInvalidInfo = MutableLiveData<Boolean>()
    val eventInvalidInfo: LiveData<Boolean>
        get() = _eventInvalidInfo

    var inputName = ""
    var inputCompany = ""
    var inputSize = ""
    var inputDescription = ""

    private lateinit var listShoeData: MutableList<Shoe>

    init {
        Timber.i("init")

        createSampleList()
        _listShoe.value = listShoeData
        _eventNewShoeAdded.value = false
        _eventInvalidInfo.value = false
    }

    fun onSaveButtonClick() {
        Timber.i("onSaveButtonClick")
        if (isValidInfo()) {
            val shoe = Shoe(inputName, inputSize.toDouble(), inputCompany, inputDescription)
            // add to list
            listShoeData.add(shoe)
            _eventNewShoeAdded.value = true
            Timber.i("shoe was added")
        } else {
            _eventInvalidInfo.value = true
            Timber.i("not enough info")
        }
    }

    private fun isValidInfo(): Boolean {
        return inputName.isNotBlank() && inputCompany.isNotBlank()
                && inputSize.isNotBlank() && inputDescription.isNotBlank()
    }

    private fun createSampleList() {
        listShoeData = mutableListOf(
            Shoe("RunningShoe", 39.0, "Company A", "Best for running"),
            Shoe("WalkingShoe", 40.0, "Company B", "Shoe for walking"),
            Shoe("FashionShoe", 41.0, "Company C", "Very fashion"),
            Shoe("CasualShoe", 42.0, "Company D", "For Casual style"),
            Shoe("DanceShoe", 43.0, "Company E", "Dancing")
        )
    }

    fun resetInput() {
        inputName = ""
        inputCompany = ""
        inputSize = ""
        inputDescription = ""
    }

    fun onNewShoeAddedComplete() {
        Timber.i("onNewShoeAddedComplete")
        _eventNewShoeAdded.value = false
    }

    fun onInvalidInfoHandled() {
        _eventInvalidInfo.value = false
    }
}
