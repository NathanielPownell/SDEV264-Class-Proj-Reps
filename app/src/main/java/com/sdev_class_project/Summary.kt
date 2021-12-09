package com.sdev_class_project

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_summary.*
import kotlinx.android.synthetic.main.activity_workout.*
import android.text.TextUtils
import android.view.View
import android.widget.EditText

class Summary : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        val emailId = intent.getStringExtra("email_id")


        btn_retry.setOnClickListener{
            val intent = Intent(this@Summary, WorkoutActivity::class.java)
            intent.putExtra("email_id", emailId)

            startActivity(intent)
            finish()
        }

        btn_done.setOnClickListener{
            val intent = Intent(this@Summary, MainActivity::class.java)
            intent.putExtra("email_id", emailId)

            startActivity(intent)
            finish()
        }
    }
}