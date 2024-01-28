package com.example.readingjson

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.serialization.json.Json
import java.io.InputStreamReader

class ReceipeRecyclerViewAdapter(private val items: List<Recipe>): RecyclerView.Adapter<ReceipeRecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView
        val shorDec: TextView

        init {
            textView = view.findViewById(R.id.title_text)
            shorDec = view.findViewById(R.id.short_disc_text)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recipe_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.textView.text = item.title
        holder.shorDec.text = item.shortDec
    }
}