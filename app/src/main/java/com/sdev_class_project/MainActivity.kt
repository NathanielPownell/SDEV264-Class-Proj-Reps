package com.sdev_class_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    var file = "db_file"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userId = intent.getStringExtra("user_id")



        val emailId = intent.getStringExtra("email_id")




        tv_email_id.text = "$emailId"

        button_logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()

            startActivity(Intent(this@MainActivity, Login::class.java))
            finish()
        }

        button_start.setOnClickListener{
            val intent = Intent(this, WorkoutActivity::class.java)
            intent.putExtra("email_id", emailId)
            startActivity(intent)
            finish()
        }

        floatingAbout.setOnClickListener{
            val intent = Intent(this, About::class.java)
            intent.putExtra("email_id", emailId)

            startActivity(intent)
            finish()
        }


    }
}