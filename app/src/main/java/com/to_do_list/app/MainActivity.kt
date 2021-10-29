package com.to_do_list.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.DocumentsContract
import android.util.Log
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.to_do_list.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var toDoList: MutableList<ToDoList>
    private lateinit var toDoListAdapter : ToDoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadList()

        toDoListAdapter = ToDoListAdapter(toDoList)
        Log.i("test","test from main " + toDoListAdapter.itemCount.toString())

        binding.rvList.adapter = toDoListAdapter
    }

    private fun loadList() {
        toDoList = listOf(
            ToDoList(ArrayList(), "List 1", ArrayList()),
            ToDoList(ArrayList(), "List 2", ArrayList()),
        ) as MutableList<ToDoList>
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}