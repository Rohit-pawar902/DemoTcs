package com.example.demotcs.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.demotcs.cache.DatabaseDriverFactory
import com.tcs.kmp.db.Registration
import com.example.demotcs.cache.Database
import com.example.demotcs.entity.Person

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val name = findViewById<TextView>(R.id.ETname)
        val email = findViewById<TextView>(R.id.ETemail )
        val add = findViewById<TextView>(R.id.ETaddress )
        val mob = findViewById<TextView>(R.id.ETmobile )
        val pass = findViewById<TextView>(R.id.ETpassword )
        val p= Person("1",name.text.toString(),email.text.toString(),mob.text.toString(),pass.text.toString(),"male")
//        val databaseDriverFactory:DatabaseDriverFactory= DatabaseDriverFactory(this)
//        var database = Database(databaseDriverFactory)
//      database.clearDatabase()
//       val p= Person("1",name.text.toString(),email.text.toString(),mob.text.toString(),pass.text.toString(),"male")
//        database.insertPerson(p);
//
//        var li:List<Person>  = database.getAllPersons()
//
//
//       val tv= findViewById<TextView>(R.id.tv2)
//        tv.text=li.toString();

        val submit = findViewById<Button>(R.id.btnsubmit )
        submit.setOnClickListener {
            val intent= Intent(this@Home ,ShowRegisteredDataActivity::class.java)
            intent.putExtra("data",p.toString())
            startActivity(intent)
            finish()
        }

    }
}


