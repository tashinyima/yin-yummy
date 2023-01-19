package com.example.yinyummy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yinyummy.databinding.ItemRowCategoriesBinding
import com.example.yinyummy.model.Categories
import com.example.yinyummy.model.Result

class ExploreCategoryAdapter(private val categoryList: ArrayList<Categories>) :
    RecyclerView.Adapter<ExploreCategoryAdapter.ExploreViewHolder>() {

    var onItemClick: ((Categories) -> Unit) ?=null

    fun updateResult(newCategories: List<Categories>){
        categoryList.clear()
        categoryList.addAll(newCategories)
        // need to change notifydata changed
        notifyDataSetChanged()
    }


    inner class ExploreViewHolder(private val binding: ItemRowCategoriesBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(categories: Categories){
                binding.categories = categories
                binding.executePendingBindings()
            }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {

        val binding = ItemRowCategoriesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ExploreViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {

        holder.bind(categoryList[position])
        holder.itemView.setOnClickListener{
            onItemClick?.invoke(categoryList[position])
        }
    }

    override fun getItemCount(): Int {

        return categoryList.size
    }
}