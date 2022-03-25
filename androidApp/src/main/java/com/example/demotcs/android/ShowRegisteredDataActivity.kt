package com.example.demotcs.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demotcs.cache.Database
import com.example.demotcs.cache.DatabaseDriverFactory
import com.example.demotcs.entity.Person

class ShowRegisteredDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_registered_data)
        val intent=intent

        val data=intent.getStringExtra("data")
        Log.d("main",data.toString());

        val databaseDriverFactory: DatabaseDriverFactory = DatabaseDriverFactory(this)
        var database = Database(databaseDriverFactory)
//       database.clearDatabase()
        val p1= Person("1","rohit","rohit@2811200gmail.com","8839425124","@rohit12","male")
        val p2= Person("2","mohit","rohit@2811200gmail.com","8839425124","@rohit12","male")
        val p3= Person("3","reen","rohit@2811200gmail.com","8839425124","@rohit12","male")
        val p4= Person("4","heen","rohit@2811200gmail.com","8839425124","@rohit12","male")
        val p5= Person("1","firjeenmarna","rohit@2811200gmail.com","8839425124","@rohit12","male")


        database.insertPerson(p1);
        database.insertPerson(p2);
        database.insertPerson(p3);
        database.insertPerson(p4);
        database.insertPerson(p5)

        var li:List<Person>  = database.getAllPersons()

        //Recycle viewer
        val recycle1 = findViewById<RecyclerView>(R.id.recycle1);
        recycle1.layoutManager = LinearLayoutManager(this)
        val arr = li
        val adapter = ShowAdapter(arr)
        recycle1.adapter = adapter
    }
}