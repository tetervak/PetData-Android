package ca.tetervak.petdata.ui.petdetails

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.tetervak.petdata.data.repository.PetDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class PetDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: PetDataRepository
) : ViewModel() {

    private val _uiState: MutableState<PetDetailsUiState> =
        mutableStateOf(PetDetailsUiState.Loading)
    val uiState: State<PetDetailsUiState> = _uiState

    private val petId: Int = checkNotNull(savedStateHandle["petId"])

    init {
        Log.d("PetDetailsViewModel", "PetDetailsViewModel created")
        loadPetDetails()
    }

    private fun loadPetDetails() = viewModelScope.launch {
        //fake loading delay, 2 seconds
        delay(2000)
        try {
            val pet = repository.getPetById(petId)
            if (pet != null) {
                _uiState.value = PetDetailsUiState.Loaded(pet)
            }else{
                _uiState.value = PetDetailsUiState.Error
            }
        } catch (e: IOException) {
            _uiState.value = PetDetailsUiState.Error
            e.printStackTrace()
        }
    }

    fun reloadPetDetails() {
        _uiState.value = PetDetailsUiState.Loading
        loadPetDetails()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("PetDetailsViewModel", "PetDetailsViewModel destroyed")
    }
}