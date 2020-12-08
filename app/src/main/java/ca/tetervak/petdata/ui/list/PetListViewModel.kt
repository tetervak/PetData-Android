package ca.tetervak.petdata.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.tetervak.petdata.domain.Gender
import ca.tetervak.petdata.domain.Pet

class PetListViewModel : ViewModel() {

    private val _pets = MutableLiveData<List<Pet>>()
    val pets: LiveData<List<Pet>> = _pets

    init {
        _pets.value = arrayListOf(
            Pet(1, "Fluffy", "Cat", Gender.FEMALE),
            Pet(2, "Sparky", "Dog", Gender.MALE),
            Pet(3, "Rodger", "Rabbit", Gender.MALE),
        )
    }

}