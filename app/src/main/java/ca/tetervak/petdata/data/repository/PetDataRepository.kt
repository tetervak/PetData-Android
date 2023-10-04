package ca.tetervak.petdata.data.repository

import ca.tetervak.petdata.domain.Pet

interface PetDataRepository {

    suspend fun getAllPets(): List<Pet>
}