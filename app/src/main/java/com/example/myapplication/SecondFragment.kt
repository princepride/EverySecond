package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondFragment : Fragment(R.layout.fragment_second){

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        var todoList = mutableListOf<Todo>(
//            Todo("Follow AndroidDevs",false),
//            Todo("Learn about RecycleView", true),
//        )
//        val adapter = TodoAdapter(todoList)
//        val rvTodes = view?.findViewById<RecyclerView>(R.id.rvList)
//        rvTodes?.adapter = adapter
//        rvTodes?.layoutManager = LinearLayoutManager(this)
//
//        val btnAddTodo = view?.findViewById<Button>(R.id.button)
//        btnAddTodo.setOnClickListener()
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var todoList = mutableListOf<Todo>(
            Todo("Follow AndroidDevs",false),
            Todo("Learn about RecycleView", true),
        )

        val view = inflater.inflate(R.layout.fragment_second,container,false)
        val adapter = TodoAdapter(todoList)
        val rvTodos = view.findViewById<RecyclerView>(R.id.rvList)
        rvTodos.adapter = adapter
        rvTodos.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)

        val btnAddTodo = view.findViewById<Button>(R.id.button)
        btnAddTodo.setOnClickListener(){
            val title = view.findViewById<EditText>(R.id.etList).text.toString()
            val todo = Todo(title,false)
            todoList.add(todo )
            adapter.notifyItemInserted(todoList.size-1)
        }
        return view
    }
}