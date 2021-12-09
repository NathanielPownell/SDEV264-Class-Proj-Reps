package com.sdev_class_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgot.*
import kotlinx.android.synthetic.main.activity_summary.*

class Forgot : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)

        val emailId = intent.getStringExtra("email_id")

        emailForgot.text = emailId

        buttonForgotSend.setOnClickListener{
            if (emailId != null) {
                FirebaseAuth.getInstance().sendPasswordResetEmail(emailId)
                    .addOnCompleteListener{task ->
                        if(task.isSuccessful) {
                            val intent = Intent(this@Forgot, Confirmed::class.java)
                            intent.putExtra("email_id", emailId)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(
                                this@Forgot,
                                task.exception!!.message.toString(),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
            }

        }

        buttonForgotCancel.setOnClickListener{
            val intent = Intent(this@Forgot, About::class.java)
            intent.putExtra("email_id", emailId)
            startActivity(intent)
            finish()
        }

    }
}