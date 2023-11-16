package com.syntax_institut.android_ta_apiwdh.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.syntax_institut.android_ta_apiwdh.data.model.Digimon
import com.syntax_institut.android_ta_apiwdh.databinding.ItemListBinding
import com.syntax_institut.android_ta_apiwdh.ui.DigimonViewModel

class DigimonAdapter (
    private val dataset: List<Digimon>,
    private val viewModel: DigimonViewModel
): RecyclerView.Adapter<DigimonAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.binding.ivDigimonPicture.load(item.image)
        holder.binding.tvId.text = item.id.toString()
        holder.binding.tvName.text = item.name


    }
}