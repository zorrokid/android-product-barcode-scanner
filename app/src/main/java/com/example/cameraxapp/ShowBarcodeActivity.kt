package com.example.cameraxapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cameraxapp.databinding.ActivityMainBinding
import com.example.cameraxapp.databinding.ActivityShowBarcodeBinding

class ShowBarcodeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShowBarcodeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowBarcodeBinding.inflate(layoutInflater)
        val view = binding.root
        // setContentView(R.layout.activity_show_barcode)
        setContentView(view)
        val barcode = intent.getStringExtra(EXTRA_BARCODE)
        binding.textView.apply { text = barcode }
    }
}