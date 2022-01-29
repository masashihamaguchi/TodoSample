package com.masashi.todosample

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import com.masashi.todosample.databinding.ActivityPreBinding

class PreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferences = getSharedPreferences("Password", Context.MODE_PRIVATE)
        val pass = preferences.getString("password", "admin")

        binding.button.setOnClickListener {

            val text = binding.textInputEditText.text.toString()
            Log.d("tag", text)
            if (text == pass) {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }
}