package com.example.cameraxapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
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

    fun searchProducts(view: View) {
        val barcode = binding.textView.text

        // https://html.duckduckgo.com/html/?q=%7Bsearch_terms%7D

        // val intent = Intent(this, )

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://html.duckduckgo.com/html/?q=%7B$barcode%7D"

        Log.d("ShowBarcodeActivity", url)

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                // Display the first 500 characters of the response string.
                Log.d("ShowBarcodeActivity", "Response is: $response")
            },
            Response.ErrorListener { exception ->
                if (exception != null)
                    Log.e("ShowBarcodeActivity", exception.toString())
            })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)

    }
}