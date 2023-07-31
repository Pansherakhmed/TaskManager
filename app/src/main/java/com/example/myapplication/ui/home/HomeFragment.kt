package com.example.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.App
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.ui.model.Task
import com.example.myapplication.ui.task.TaskFragment.Companion.RESULT_KEY
import com.example.myapplication.ui.task.TaskFragment.Companion.RESULT_REQUEST_KEY
import com.example.myapplication.ui.task.adapter.TaskAdapter
import com.example.myapplication.utils.showToast

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val adapter = TaskAdapter(this::onClick)

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerview.adapter = adapter

        val data = App.db.taskDao().getAll()
        adapter.addTasks(data)


        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onClick(task: Task) {
        findNavController().navigate(R.id.taskFragment, bundleOf(TASK_KEY to task))
    }

    companion object {
        const val TASK_KEY = "task.key"
    }
}