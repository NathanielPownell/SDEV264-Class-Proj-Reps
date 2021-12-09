package com.sdev_class_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.activity_forgot_enter.*

class forgotEnter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_enter)

        buttonForgotEnterCont.setOnClickListener{
            val emailId = forgotEnterEmail.text.toString().trim()
            val intent = Intent(this@forgotEnter, Forgot::class.java)
            intent.putExtra("email_id", emailId)

            startActivity(intent)
        }

        buttonForgotEnterCancel.setOnClickListener{
            startActivity(Intent(this@forgotEnter, Login::class.java))
        }
    }
}