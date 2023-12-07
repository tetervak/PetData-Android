package ca.tetervak.petdata.data.repository

import androidx.test.ext.junit.runners.AndroidJUnit4
import ca.tetervak.petdata.data.remote.RetrofitModule
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith

// It is not a unit test because it connects to the outside server
@RunWith(AndroidJUnit4::class)
class PetDataRepositoryImplTest1 {

    private lateinit var repository: PetDataRepository

    @Before
    fun setUp() {
        val retrofit = RetrofitModule.retrofit()
        val petDataApi = RetrofitModule.petDataApi(retrofit)
        repository = PetDataRepositoryImpl(petDataApi)
    }

    @Test
    fun getAllPets() {
        runTest {
            val pets = repository.getAllPets()
            println(pets)
        }
    }
}