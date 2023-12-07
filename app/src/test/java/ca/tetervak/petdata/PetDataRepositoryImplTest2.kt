package ca.tetervak.petdata

import ca.tetervak.petdata.data.remote.PetDataApi
import ca.tetervak.petdata.data.repository.PetDataRepository
import ca.tetervak.petdata.data.repository.PetDataRepositoryImpl
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.net.HttpURLConnection

@RunWith(JUnit4::class)
class PetDataRepositoryImplTest2 {

    private val server: MockWebServer = MockWebServer()
    private val port = 8000

    private lateinit var petDataApi: PetDataApi
    private lateinit var repository: PetDataRepository

    @Before
    fun setUp() {
        server.start(port)
        petDataApi = Retrofit.Builder()
            .baseUrl(server.url("/"))
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(PetDataApi::class.java)

        repository = PetDataRepositoryImpl(petDataApi)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun getAllPets() {
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(MockResponseFileReader("all_pets_response.json").content)
        server.enqueue(response)

        runBlocking {
            val pets = repository.getAllPets()
            println(pets)
            assertEquals(7, pets.size)
        }
    }
}