package com.example.myapplication.ui.task.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapplication.databinding.ItemTaskBinding
import com.example.myapplication.ui.model.Task

class TaskAdapter: RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private val list = arrayListOf<Task>()

    fun addTask(task: Task){
        list.add(0,task)
        notifyItemChanged(0)
    }

    inner class TaskViewHolder(private val binding: ItemTaskBinding):ViewHolder(binding.root){

        fun bind(task:Task){
            binding.title.text = task.title
            binding.desc.text = task.desc
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(ItemTaskBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
holder.bind(list.get(position))
    }

    override fun getItemCount(): Int {
        return list.size
    }
}