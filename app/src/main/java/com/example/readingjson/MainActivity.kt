package com.example.readingjson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.serialization.json.Json
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rc_view)

        recyclerView.layoutManager = LinearLayoutManager(this)

        // 1. find drop down view
        // 2. listen for the onChange event
        // 3. store the changes lang data
        // 4. update the data that we are feeding to the recycler view

        // assuming we are in the on change event method
        // if (value == "english") { R.raw.recipies_en }

        val inputStream = this.resources.openRawResource(R.raw.recipies)
        val inputStreamReader = InputStreamReader(inputStream)
        val jsonString = inputStreamReader.readText()
        val items = Json.decodeFromString<List<Recipe>>(jsonString)

        val adaper = ReceipeRecyclerViewAdapter(items)

        recyclerView.adapter = adaper

        Log.i("TAG", "onCreate: Is this wokring?")
    }
}