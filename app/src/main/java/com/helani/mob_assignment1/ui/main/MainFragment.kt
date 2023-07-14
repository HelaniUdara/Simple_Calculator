package com.helani.mob_assignment1.ui.main

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import com.helani.mob_assignment1.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var view =inflater.inflate(R.layout.fragment_main, container, false)
        var msg = view.findViewById<TextView>(R.id.message)

        var num1 = view.findViewById<EditText>(R.id.numOne)
        var num2 = view.findViewById<EditText>(R.id.numTwo)

        viewModel.result.observe(viewLifecycleOwner, Observer {
            msg.text = it.toString()
        })

        var addBtn = view.findViewById<Button>(R.id.Addbtn)
        addBtn.setOnClickListener {
            var number1 = num1?.text.toString().toDoubleOrNull()
            var number2 = num2?.text.toString().toDoubleOrNull()
            if((number1 != null) && (number2 != null)){
                viewModel.add(number1,number2)
            }

        }

        var subBtn = view.findViewById<Button>(R.id.SubBtn)
        subBtn.setOnClickListener {
            var number1 = num1?.text.toString().toDoubleOrNull()
            var number2 = num2?.text.toString().toDoubleOrNull()
            if((number1 != null) && (number2 != null)){
                viewModel.sub(number1,number2)
            }
        }

        var multiBtn = view.findViewById<Button>(R.id.MultiBtn)
        multiBtn.setOnClickListener {
            var number1 = num1?.text.toString().toDoubleOrNull()
            var number2 = num2?.text.toString().toDoubleOrNull()
            if((number1 != null) && (number2 != null)){
                viewModel.multiply(number1,number2)
            }
        }

        var divBtn = view.findViewById<Button>(R.id.DivBtn)
        divBtn.setOnClickListener {
            var number1 = num1?.text.toString().toDoubleOrNull()
            var number2 = num2?.text.toString().toDoubleOrNull()
            if((number1 != null) && (number2 != null)){
                viewModel.divide(number1,number2)
            }
        }

        var clrBtn = view.findViewById<Button>(R.id.ClrBtn)
        clrBtn.setOnClickListener {
            num1.setText("")
            num2.setText("")
            msg.text = ""
        }
        return view
    }



}