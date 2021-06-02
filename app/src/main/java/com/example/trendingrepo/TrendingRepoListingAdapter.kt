package com.example.trendingrepo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trendingrepo.databinding.ItemTrendingRepoBinding

class TrendingRepoListingAdapter : RecyclerView.Adapter<TrendingRepoListingAdapter.TrendingRepoVH>() {

    private val trendingRepoList = mutableListOf<Repo>()

    fun updateData(list: List<Repo>) {
        trendingRepoList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingRepoVH {
        val binding = ItemTrendingRepoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrendingRepoVH(binding)
    }

    override fun onBindViewHolder(holder: TrendingRepoVH, position: Int) {
        holder.bind(trendingRepoList[position])
    }

    override fun getItemCount(): Int = trendingRepoList.size

    inner class TrendingRepoVH(private val binding: ItemTrendingRepoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(repo: Repo) {
            binding.name.text = repo.fullName
            binding.description.text = repo.description
            binding.language.text = repo.language
        }
    }
}

