package ca.tetervak.petdata.data.repository

import ca.tetervak.petdata.data.remote.PetDataApi
import ca.tetervak.petdata.data.remote.RemoteData
import ca.tetervak.petdata.data.remote.RemotePet
import ca.tetervak.petdata.domain.Pet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PetDataRepositoryImpl @Inject constructor(
    private val petDataApi: PetDataApi
): PetDataRepository {
    override suspend fun getAllPets(): List<Pet> =
        withContext(Dispatchers.IO){
        val remoteData:RemoteData = petDataApi.getRemoteData()
        remoteData._embedded.pets.map { it.toPet() }
    }
}

fun RemotePet.toPet() = Pet(
    name = this.name,
    petKind = this.petKind,
    age = this.age,
    image = this.image
)