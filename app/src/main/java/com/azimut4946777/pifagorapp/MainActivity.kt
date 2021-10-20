package com.azimut4946777.pifagorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.azimut4946777.pifagorapp.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }

    fun unClickResult(view: View) {
        if (!isFieldEmpty()) {
            val resultDone = getString(R.string.result) + getResult()
            binding.tVResult.text = resultDone
        }
    }


    private fun isFieldEmpty(): Boolean {
        binding.apply {
            when {
                edA.text.isNullOrEmpty() -> edA.error = getString(R.string.error_text)
                edB.text.isNullOrEmpty() -> edB.error = getString(R.string.error_text)
            }
            return edA.text.isNullOrEmpty() || edB.text.isNullOrEmpty()
        }


    }

    private fun getResult(): String {

        binding.apply {
            val a = edA.text.toString().toDouble()
            val b = edB.text.toString().toDouble()
            return sqrt((a.pow(2)+b.pow(2))).toString()
        }

    }

}