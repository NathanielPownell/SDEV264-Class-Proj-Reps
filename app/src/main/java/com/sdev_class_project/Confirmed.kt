package com.sdev_class_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_confirmed.*

class Confirmed : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmed)

        val emailId = intent.getStringExtra("email_id")

        emailTextConfirmed.text = emailId

        buttonConfirmed.setOnClickListener{
            val intent = Intent(this@Confirmed, Login::class.java)
            intent.putExtra("email_id", emailId)

            startActivity(intent)
            finish()
        }
    }
}