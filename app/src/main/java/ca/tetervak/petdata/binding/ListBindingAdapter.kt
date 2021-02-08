package ca.tetervak.petdata.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import ca.tetervak.petdata.domain.Pet
import ca.tetervak.petdata.ui.list.PetListAdapter

@BindingAdapter("petList")
fun bindList(recyclerView: RecyclerView, list: List<Pet>){
    val adapter = recyclerView.adapter as PetListAdapter
    adapter.submitList(list)
}