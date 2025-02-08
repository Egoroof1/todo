package com.example.todo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        val title: TextView = findViewById(R.id.detail_title)
        val textDesc: TextView = findViewById(R.id.detail_text)
        val btn: Button = findViewById(R.id.detail_btn_back)


        // Получение данных
        val taskTitle = intent.getStringExtra("TITLE") ?: ""
        val taskDesc = intent.getStringExtra("DESC") ?: ""

        // Установка данных
        title.text = taskTitle
        textDesc.text = taskDesc

        btn.setOnClickListener {
            finish()
        }

    }
}