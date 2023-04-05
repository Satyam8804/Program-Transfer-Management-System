package com.example.ptms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FrontPage : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_front_page)

        val search = findViewById<SearchView>(R.id.search_view)
        search.queryHint ="Search Program ..."

        recyclerView = findViewById<RecyclerView>(R.id.program_list)
        recyclerView.layoutManager = LinearLayoutManager(this)


        val adapter = ProgramAdapter(createArrayList())
        recyclerView.adapter = adapter
    }

    fun createArrayList(): ArrayList<Model> {
        val arrProgram = ArrayList<Model>()
        val obj = Model()

        obj.setTitle("Computer Science and Engineering")
        obj.setImage(R.drawable.user)

        arrProgram.add(obj)

        val obj1 = Model()

        obj1.setTitle("Mechanical Engineering")
        obj1.setImage(R.drawable.user)

        arrProgram.add(obj1)

        val obj2 = Model()
        obj2.setTitle("Electronics and Communication Engineering")
        obj2.setImage(R.drawable.user)

        arrProgram.add(obj2)

        val obj3 = Model()
        obj3.setTitle("Civil Engineering")
        obj3.setImage(R.drawable.user)

        arrProgram.add(obj3)

        val obj4 = Model()
        obj4.setTitle("Electrical Engineering")
        obj4.setImage(R.drawable.user)

        arrProgram.add(obj4)

        val obj5 = Model()
        obj5.setTitle("Aeronautical Engineering")
        obj5.setImage(R.drawable.user)

        arrProgram.add(obj5)

        val obj6 = Model()
        obj6.setTitle("Biotechnology Engineering")
        obj6.setImage(R.drawable.user)

        arrProgram.add(obj6)
        return arrProgram
    }
}