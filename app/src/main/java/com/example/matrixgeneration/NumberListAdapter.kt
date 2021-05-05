package com.example.matrixgeneration

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.matrixgeneration.databinding.RecyclerItemBinding

class NumberListAdapter: RecyclerView.Adapter<NumberListAdapter.MyViewHolder>()  {

    var numberList = emptyList<Int>()

    inner class MyViewHolder(val binding: RecyclerItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(RecyclerItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentNumber = numberList[position]

        holder.binding.textViewNumber.text = "0"
    }

    override fun getItemCount(): Int {
        return numberList.size
    }

    fun setData(numberList: List<Int>) {
        this.numberList = numberList
        notifyDataSetChanged()
    }
}