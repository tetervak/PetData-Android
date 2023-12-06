package ca.tetervak.petdata.data.repository

import androidx.test.ext.junit.runners.AndroidJUnit4
import ca.tetervak.petdata.data.remote.RetrofitModule
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class PetDataRepositoryImplTest1 {

    @Test
    fun getAllPets() {
        val retrofit = RetrofitModule.retrofit()
        val petDataApi = RetrofitModule.petDataApi(retrofit)
        val repository = PetDataRepositoryImpl(petDataApi)
        runTest {
            val pets = repository.getAllPets()
            println(pets)
        }
    }

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }
}