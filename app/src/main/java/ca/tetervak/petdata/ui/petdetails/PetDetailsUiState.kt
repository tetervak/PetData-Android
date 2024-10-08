package ca.tetervak.petdata.ui.petdetails

import ca.tetervak.petdata.domain.Pet

sealed interface PetDetailsUiState {
    data class Loaded(val pet: Pet): PetDetailsUiState
    data object Loading: PetDetailsUiState
    data object Error: PetDetailsUiState
}