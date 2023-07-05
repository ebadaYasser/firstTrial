package com.features.home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.check.firsttrial.databinding.HomeListItemBinding
import com.core.network.models.CountryItem

class HomeAdapter(
    private val list: List<CountryItem>,
    private val itemClickListener: (countryItem: CountryItem) -> Unit
) : Adapter<HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            HomeListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            itemClickListener

        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(list[position])
    }

}