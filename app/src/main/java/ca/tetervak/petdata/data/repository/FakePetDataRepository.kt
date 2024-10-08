package ca.tetervak.petdata.data.repository

import ca.tetervak.petdata.data.local.fakePetList
import ca.tetervak.petdata.domain.Pet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FakePetDataRepository @Inject constructor(): PetDataRepository {

    override suspend fun getAllPets(): List<Pet> =
        withContext(Dispatchers.IO){
            fakePetList
        }

    override suspend fun getPetById(id: Int): Pet? =
        withContext(Dispatchers.IO){
            fakePetList.find { it.id == id }
        }
}