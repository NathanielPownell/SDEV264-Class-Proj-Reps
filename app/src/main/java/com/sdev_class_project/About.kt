package com.sdev_class_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_about.*

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val emailId = intent.getStringExtra("email_id")


        floatingAboutBack.setOnClickListener{
            val intent = Intent(this@About, MainActivity::class.java)
            intent.putExtra("email_id", emailId)

            startActivity(intent)
        }

        buttonAboutReset.setOnClickListener{
            val intent = Intent(this@About, Forgot::class.java)
            intent.putExtra("email_id", emailId)

            startActivity(intent)
        }
    }


}