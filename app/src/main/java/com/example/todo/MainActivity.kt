package com.example.todo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
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

        //-------------------

            //Счётчик включений

        //Куда сохраняем. Гдето на бомилке в data
        val sharedPreferences = getSharedPreferences("app_tick", MODE_PRIVATE)

        val launchCount = sharedPreferences.getInt("launch_count", 0) + 1
        val editor = sharedPreferences.edit()
        editor.putInt("launch_count", launchCount)
        editor.apply()

        val textTick: TextView = findViewById(R.id.main_tick)
        textTick.text = "Приложение было запущено $launchCount раз"

        //----------------------


        // Получаем RecyclerView из макета
        val recyclerView: RecyclerView = findViewById(R.id.main_recycler)


        // Устанавливаем LayoutManager (отвечает за расположение элементов)
        recyclerView.layoutManager = LinearLayoutManager(this)


        // Создаем список задач
        val tasks = mutableListOf(
            Task(false, "Покупки", "Молоко\nПеченьки\nПельмени\nДошик"),
            Task(false, "Треня", "отжим 15\nприсед 20\nпрес качат 20\nбег"),
            Task(false, "Треня", "отжим 15\nприсед 20\nпрес качат 20\nбег")
        )


        // Привязываем адаптер
        recyclerView.adapter = TaskAdapter(tasks)


        // Добавление элементов в tasks
        btnMainAddTask.setOnClickListener {
            tasks.add(Task(false, "New", "New"))
            recyclerView.layoutManager = LinearLayoutManager(this)
        }

        //новый комент


    }
}