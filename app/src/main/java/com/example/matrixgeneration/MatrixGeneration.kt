package com.example.matrixgeneration

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.matrixgeneration.databinding.FragmentMatrixGenerationBinding


class MatrixGeneration : Fragment(R.layout.fragment_matrix_generation) {
    private lateinit var binding: FragmentMatrixGenerationBinding
    private lateinit var matrixGenerationViewModel: MatrixGenerationViewModel

    companion object {
        val TAG = "Main"
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentMatrixGenerationBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)

        //ViewModel
        matrixGenerationViewModel = ViewModelProvider(this).get(MatrixGenerationViewModel::class.java)


        viewClickListener()

        matrixGenerationViewModel.getNumber().observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "number value is "+it)
        } )


    }

    private fun viewClickListener() {
        binding.buttonSubmit.setOnClickListener {
            if (binding.textInputEditTextNumber.text.toString().isEmpty()) {
                Toast.makeText(context, "Please enter number", Toast.LENGTH_SHORT).show()
            } else {
                var number = binding.textInputEditTextNumber.text.toString().trim()
                matrixGenerationViewModel.number.setValue(number.toInt())
            }
        }
    }
}

//fun main() {
//    var a = mutableListOf<Int>()
//    for (i in 1..1*2) {
//        a.add(i)
//    }
//    println(a)
//}