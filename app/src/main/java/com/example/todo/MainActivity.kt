package com.example.todo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnMainAddTask: Button = findViewById(R.id.btn_main_addTask)

        // Получаем RecyclerView из макета
        val recyclerView: RecyclerView = findViewById(R.id.main_recycler)


        // Устанавливаем LayoutManager (отвечает за расположение элементов)
        recyclerView.layoutManager = LinearLayoutManager(this)


        // Создаем список задач
        val tasks = mutableListOf(
            Task(false, "Покупки", "Молоко\nПеченьки\nПельмени\nДошик"),
            Task(false, "Треня", "отжим 15\nприсед 20\nпрес качат 20\nбег")
        )


        // Привязываем адаптер
        recyclerView.adapter = TaskAdapter(tasks)


        // Добавление элементов в tasks
        btnMainAddTask.setOnClickListener {
            tasks.add(Task(false, "New", "New"))
            recyclerView.layoutManager = LinearLayoutManager(this)
        }


    }
}