package com.example.myapplication.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.App
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentTaskBinding
import com.example.myapplication.ui.home.HomeFragment.Companion.TASK_KEY
import com.example.myapplication.ui.model.Task


class TaskFragment : Fragment() {

    private lateinit var binding: FragmentTaskBinding
    private var task: Task? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)

        task = arguments?.getSerializable(TASK_KEY) as Task
        if (task != null) {
            etTitle.setText(task?.title.toString())
            etDesc.setText(task?.desc.toString())
            btnSave.setText(getString(R.string.update))
        }

        binding.btnSave.setOnClickListener {
            if (task== null){
                save()
            }else{
                update()
            }
            findNavController().navigateUp()
        }
    }

    companion object {
        const val RESULT_REQUEST_KEY = "request.key"
        const val RESULT_KEY = "result.key"
    }

    private fun update(){
        val data = Task(
            title = binding.etTitle.text.toString(),
            desc = binding.etDesc.text.toString(),
        )
        App.db.taskDao().update(data)
    }

    private fun save(){
        val data = Task(
            title = binding.etTitle.text.toString(),
            desc = binding.etDesc.text.toString(),
        )
        App.db.taskDao().insert(data)
    }

}