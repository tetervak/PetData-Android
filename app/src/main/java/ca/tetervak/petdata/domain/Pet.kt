package ca.tetervak.petdata.domain

data class Pet(
    val id: Int,
    val name: String,
    val animal: String,
    val gender: Gender,
    val isVaccinated: Boolean = false
)