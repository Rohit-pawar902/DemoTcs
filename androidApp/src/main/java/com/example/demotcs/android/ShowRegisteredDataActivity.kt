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
        val databaseDriverFactory: DatabaseDriverFactory = DatabaseDriverFactory(this)
        var database = Database(databaseDriverFactory)

        val intent = intent
        val data :String? = intent.getStringExtra("data")

        if(data!=null) {
            var personData: List<String> = data.split(",")
//            database.clearDatabase()

            var li1:List<Person>  = database.getAllPersons()
            var max=1
            for( p in li1){
                max=Math.max(p.id.toInt(),max)
            }
            max+=1;


                val p1 = Person(
                    max.toString(),
                    personData[1] ,
                    personData[2] ,
                    personData[3] ,
                    personData[4] ,
                    personData[5]

                )

        database.insertPerson(p1)

        }
        var li:List<Person>  = database.getAllPersons()

//        Recycle viewer
        val recycle1 = findViewById<RecyclerView>(R.id.recycle1);
        recycle1.layoutManager = LinearLayoutManager(this)
        val arr = li
        val adapter = ShowAdapter(arr)
        recycle1.adapter = adapter
    }
}