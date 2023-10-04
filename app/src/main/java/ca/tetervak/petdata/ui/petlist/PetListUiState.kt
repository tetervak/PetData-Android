package ca.tetervak.petdata.ui.petlist

import ca.tetervak.petdata.domain.Pet

sealed interface PetListUiState {
    data class Loaded(val pets: List<Pet>):PetListUiState
}