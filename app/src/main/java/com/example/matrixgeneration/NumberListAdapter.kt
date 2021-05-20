package com.example.matrixgeneration

import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.matrixgeneration.databinding.RecyclerItemBinding
import java.util.Collections.emptyList
import kotlin.math.log


class NumberListAdapter: RecyclerView.Adapter<NumberListAdapter.MyViewHolder>()  {

    var numberList = emptyList<Int>()
    val TAG = "Main"


    inner class MyViewHolder(val binding: RecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        var timer: CountDownTimer? = null

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(RecyclerItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentNumber = numberList[position]
        if (position%2 ==0) {
            holder.binding.textViewNumber.setBackgroundResource(R.drawable.button_background_white)
        } else {
            holder.binding.textViewNumber.setBackgroundResource(R.drawable.button_background_black)
        }

        holder.binding.textViewNumber.text = "0"
        holder.binding.textViewNumber.setOnClickListener {
            if (holder.timer != null) {
                holder.timer!!.cancel();
                holder.timer = null
            }
            else {
                var timer: Long = numberList.get(position).toLong()
                timer = timer * 1000;
                holder.timer = object : CountDownTimer(100000000, 1000) {
                    var number = holder.binding.textViewNumber.text.toString().toInt()
                    override fun onTick(millisUntilFinished: Long) {
                        number++
                        holder.binding.textViewNumber.setText(number.toString())
                    }

                    override fun onFinish() {
                        holder.binding.textViewNumber.setText("0")
                    }
                }.start()
            }
        }

//        holder.binding.textViewNumber.setOnClickListener {
//            val mainHandler = Handler(Looper.getMainLooper())
//            mainHandler.post(object : Runnable {	//to run anything in loop after every 1 sec
//                override fun run() {
//                    //run anything here
//                    Log.d(TAG, "this will print every 1 sec")
//                    mainHandler.postDelayed(this, 1000)
//                }
//            })
//        }

    }

    override fun getItemCount(): Int {
        return numberList.size
    }

    fun setData(numberList: List<Int>) {
        this.numberList = numberList
        notifyDataSetChanged()
    }
}