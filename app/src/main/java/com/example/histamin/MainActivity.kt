package com.example.histamin

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ArrayAdapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvListView = findViewById<ListView>(R.id.lv_ListView)
        val tvEmptyTextView = findViewById<TextView>(R.id.tv_EmptyTextView)
        val searchbar = findViewById<SearchView>(R.id.nav_search)

        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            resources.getStringArray(R.array.countries_array)

        )

        lvListView.adapter = adapter
        lvListView.emptyView = tvEmptyTextView

        searchbar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        }
        )


    }
}



