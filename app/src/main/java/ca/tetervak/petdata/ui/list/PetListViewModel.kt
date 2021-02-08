package ca.tetervak.petdata.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.tetervak.petdata.domain.Gender
import ca.tetervak.petdata.domain.Pet
import ca.tetervak.petdata.repositories.PetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PetListViewModel @Inject constructor(
    petRepository: PetRepository
) : ViewModel() {

    val pets: LiveData<List<Pet>> = petRepository.getAllPets()
}