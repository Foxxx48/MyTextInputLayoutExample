package com.fox.mytextinputlayoutexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import com.fox.mytextinputlayoutexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.inputLayoutCustom.setEndIconOnClickListener {
            Toast.makeText(this, "Custom icon is checked", Toast.LENGTH_SHORT).show()
        }

        binding.inputEditTextPhone.addTextChangedListener {

            if (it!!.length > 10) {
                binding.inputLayoutPhone.error = "No more!"
            } else if (it!!.length <= 10) {
                binding.inputLayoutPhone.error = null
            }
        }

//        binding.inputEditTextPhone.doOnTextChanged{ text, start, before, count ->
//            if (text!!.length > 10) {
//                binding.inputLayoutPhone.error = "No more!"
//            } else if (text!!.length <= 10) {
//                binding.inputLayoutPhone.error = null
//            }
//        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}