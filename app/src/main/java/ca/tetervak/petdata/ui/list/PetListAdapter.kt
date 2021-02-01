package ca.tetervak.petdata.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ca.tetervak.petdata.R
import ca.tetervak.petdata.databinding.PetListItemBinding
import ca.tetervak.petdata.domain.Pet

class PetListAdapter(
): ListAdapter<Pet, PetListAdapter.ViewHolder>(PetDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PetListItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position + 1, getItem(position))
    }

    class ViewHolder constructor(
        private val binding: PetListItemBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun bind(count: Int, pet: Pet) {
            binding.count.text = binding.root.context.getString(R.string.count, count)
            binding.name.text = pet.name
            binding.animal.text = pet.animal
            val genders = binding.root.resources.getStringArray(R.array.genders)
            binding.gender.text = genders[pet.gender.ordinal]
            binding.executePendingBindings()
        }
    }

    class PetDiffCallback : DiffUtil.ItemCallback<Pet>() {
        override fun areItemsTheSame(oldItem: Pet, newItem: Pet): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Pet, newItem: Pet): Boolean {
            return oldItem == newItem
        }
    }
}