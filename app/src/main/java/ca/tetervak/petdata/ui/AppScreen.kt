package ca.tetervak.petdata.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import ca.tetervak.petdata.ui.petlist.PetListScreen
import ca.tetervak.petdata.ui.petlist.PetListViewModel

@Composable
fun AppScreen(){
    val viewModel: PetListViewModel = viewModel()

    PetListScreen(viewModel)
}