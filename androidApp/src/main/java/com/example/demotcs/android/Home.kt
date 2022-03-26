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

        val submit = findViewById<Button>(R.id.btnsubmit )

        try {
            submit.setOnClickListener {
                val name = findViewById<TextView>(R.id.ETname)
                val email = findViewById<TextView>(R.id.ETemail)
                val add = findViewById<TextView>(R.id.ETaddress)
                val mob = findViewById<TextView>(R.id.ETmobile)
                val pass = findViewById<TextView>(R.id.ETpassword)
                //name must have 5 Characters
                var isAllGood :Boolean=true;
                if(name.text.toString().length<5){
                    name.setError("too short name")
                    isAllGood=false;
                }
                //mobile validation
                if(mob.text.toString().length>10 || mob.text.toString().length<10){
                    mob.setError("not a valid phone number")
                    isAllGood=false;

                }
                else if(mob.text.toString().toLongOrNull()==null){
                    mob.setError("not a valid phone number")
                    isAllGood=false;

                }

                //Email validation
                if(email.text.toString().length<10){
                    email.setError("Email id is invalid")
                    isAllGood=false;
                }

               //password
               if(pass.text.toString().length<8){
                   pass.setError("Password is too short")
                   isAllGood=false;
               }

               if(isAllGood) {
                   val p = Person(
                       "5",
                       name.text.toString(),
                       email.text.toString(),
                       mob.text.toString(),
                       pass.text.toString(),
                       add.text.toString()
                   )

                   val intent = Intent(this@Home, ShowRegisteredDataActivity::class.java)
                   intent.putExtra("data", p.toString())
                   startActivity(intent)
                   finish()
               }
            }
        }
        catch (e: Exception){
            print(e.stackTrace)
        }

    }
}


