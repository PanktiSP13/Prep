package com.pankti.l1programmingquestions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pankti.l1programmingquestions.databinding.LayoutListItemBinding


class BusListAdapter(
    private val list: List<String> = listOf(),
    val onItemClicked: (String) -> Unit = {}
) :
    RecyclerView.Adapter<BusListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: LayoutListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.layout_list_item,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = list.size


    inner class ViewHolder(private val binding: LayoutListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            binding.clRoot.setOnClickListener { onItemClicked(list[adapterPosition]) }

        }


    }

}