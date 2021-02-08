package ca.tetervak.petdata.repositories

import androidx.lifecycle.LiveData
import ca.tetervak.petdata.domain.Pet

interface PetRepository {

    fun getAllPets(): LiveData<List<Pet>>
}