package com.example.todo

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(private val tasks: List<Task>) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    // ViewHolder хранит ссылки на элементы интерфейса
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textTitle: TextView = itemView.findViewById(R.id.textTitle)
        val isFinish: CheckBox = itemView.findViewById(R.id.isFinish)
        val btn: ImageView = itemView.findViewById(R.id.item_task_btn)
    }

    // Создает новый ViewHolder (вызывается для первых элементов)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_task, parent, false)
        return ViewHolder(view)
    }



    // Заполняет элемент данными (вызывается для каждого элемента при прокрутке)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val t = tasks[position]
        holder.textTitle.text = t.title
        holder.isFinish.isChecked = t.isFinish

        holder.btn.setOnClickListener {
            // Передача данных в DetailActivity
            val intent = Intent(holder.itemView.context, DetailActivity::class.java).apply {
                putExtra("TITLE", t.title)
                putExtra("DESC", t.desc)
            }

            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = tasks.size

}