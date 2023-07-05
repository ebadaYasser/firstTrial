package com.features.home.ui

import androidx.recyclerview.widget.RecyclerView
import com.check.firsttrial.databinding.HomeListItemBinding
import com.core.network.models.CountryItem

class HomeViewHolder(
    private val binding: HomeListItemBinding,
    private val itemClickListener: (countryItem: CountryItem) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(countryItem: CountryItem) {
        val capital = if (countryItem.capital.isNullOrEmpty()) "" else countryItem.capital[0]
        with(binding) {
            countryCapital.text = capital
            rootView.setOnClickListener { itemClickListener.invoke(countryItem) }
        }
    }
}