package ca.tetervak.petdata.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ca.tetervak.petdata.domain.Gender
import ca.tetervak.petdata.domain.Pet
import javax.inject.Inject

class PetRepositoryImpl @Inject constructor(): PetRepository {

    private val pets = MutableLiveData<List<Pet>>()

    init {
        pets.value = arrayListOf(
            Pet(1, "Fluffy", "Cat", Gender.FEMALE, false),
            Pet(2, "Sparky", "Dog", Gender.MALE, true),
            Pet(3, "Rodger", "Rabbit", Gender.MALE),
        )
    }

    override fun getAllPets(): LiveData<List<Pet>> {
       return pets
    }
}