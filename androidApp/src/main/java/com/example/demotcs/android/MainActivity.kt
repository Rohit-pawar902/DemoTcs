package com.example.demotcs.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.demotcs.Greeting
import android.widget.TextView

//fun greet(): String {
//    return Greeting().greeting()
//}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        Handler().postDelayed({
            val intent= Intent(this@MainActivity ,Home::class.java)
            startActivity(intent)
            finish()
        },3000)

    }
}
