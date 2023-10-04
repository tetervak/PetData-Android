package ca.tetervak.petdata.ui.petlist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import ca.tetervak.petdata.data.local.fakePetList

class PetListViewModel : ViewModel() {

    private val _uiState: MutableState<PetListUiState> =
        mutableStateOf(PetListUiState.Loaded(fakePetList))
    val uiState: State<PetListUiState> = _uiState
}

