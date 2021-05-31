package com.example.myapplication.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter(
    private val objects: List<String>,
    private val listener: OnItemClickListener,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(string: String, view: View)
    }

    override fun getItemCount() = objects.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_data, parent, false)
        return DataItemHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val dataObject = objects[position]
        if (holder is DataItemHolder) {
            holder.bind(dataObject, listener)
            holder.dataTextView.text = dataObject
        }
    }

    private class DataItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val leftImageView: ImageView = itemView.findViewById(R.id.leftImageView)
        val dataTextView: TextView = itemView.findViewById(R.id.dataTextView)

        fun bind(string: String, listener: OnItemClickListener) {
            itemView.setOnClickListener {
                listener.onItemClick(string, itemView)
            }
        }
    }
}
