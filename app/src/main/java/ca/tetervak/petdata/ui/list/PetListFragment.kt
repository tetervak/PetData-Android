package ca.tetervak.petdata.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import ca.tetervak.petdata.R
import ca.tetervak.petdata.databinding.PetListFragmentBinding

class PetListFragment : Fragment() {

    private val viewModel: PetListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = PetListFragmentBinding.inflate(inflater, container, false)

        val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.recyclerView.addItemDecoration(divider)

        val adapter = PetListAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.pets.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        return binding.root
    }

}