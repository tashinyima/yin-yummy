package com.example.yinyummy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yinyummy.databinding.ItemRowPopularChoiceBinding
import com.example.yinyummy.model.Result

class ExploreAdapter(private val resultList: ArrayList<Result>) :
    RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {

    var onItemClick: ((Result) -> Unit) ?=null

    fun updateResult(newResult: List<Result>){
        resultList.clear()
        resultList.addAll(newResult)
        // need to change notifydata changed
        notifyDataSetChanged()
    }


    inner class ExploreViewHolder(private val binding: ItemRowPopularChoiceBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(result: Result){
                binding.result = result
                binding.executePendingBindings()
            }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {

        val binding = ItemRowPopularChoiceBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ExploreViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {

        holder.bind(resultList[position])
        holder.itemView.setOnClickListener{
            onItemClick?.invoke(resultList[position])
        }
    }

    override fun getItemCount(): Int {

        return resultList.size
    }
}