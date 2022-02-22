package com.example.myapplication.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), DataAdapter.OnItemClickListener {

    private lateinit var titleTextView: TextView
    private lateinit var dataRecyclerView: RecyclerView

    private val dataSource = listOf("Kyiv", "Lviv", "Odessa", "Kharkiv", "Dnipro")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instantiateUIComponents()
        setupAdapter()
        setupUI()
    }

    override fun onItemClick(string: String, view: View) {
        println("on item click")
    }

    // Utils
    private fun instantiateUIComponents() {
        titleTextView = findViewById(R.id.titleTextView)
        dataRecyclerView = findViewById(R.id.dataRecyclerView)
    }

    private fun setupAdapter() {
        dataRecyclerView.adapter = DataAdapter(dataSource, this)

        val gridLayoutManager = LinearLayoutManager(baseContext)
        dataRecyclerView.layoutManager = gridLayoutManager
    }

    private fun setupUI() {
        titleTextView.text = "Ukrainian Cities"
    }
}
