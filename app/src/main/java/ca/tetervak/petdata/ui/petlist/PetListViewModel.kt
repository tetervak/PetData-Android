package ca.tetervak.petdata.ui.petlist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.tetervak.petdata.data.repository.PetDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class PetListViewModel @Inject constructor(
    private val repository: PetDataRepository
) : ViewModel() {

    private val _uiState: MutableState<PetListUiState> =
        mutableStateOf(PetListUiState.Loading)
    val uiState: State<PetListUiState> = _uiState

    init {
        loadPetList()
    }

    private fun loadPetList() = viewModelScope.launch {
        //fake loading delay, 2 seconds
        delay(2000)
        try {
            val pets = repository.getAllPets()
            _uiState.value = PetListUiState.Loaded(pets)
        } catch (e: Exception) {
            _uiState.value = PetListUiState.Error
            e.printStackTrace()
        }
    }

    fun reloadPetList() {
        _uiState.value = PetListUiState.Loading
        loadPetList()
    }

}

