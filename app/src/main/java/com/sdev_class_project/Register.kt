package com.sdev_class_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.text.TextUtils
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*


class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_select_login.setOnClickListener{
            onBackPressed()
        }

        btn_select_register.setOnClickListener {
            when {
//                TextUtils.isEmpty(fullname.text.toString().trim { it <= ' '}) -> {
//                    Toast.makeText(
//                        this@Register,
//                        "Please enter your name.",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }

                TextUtils.isEmpty(reg_email.text.toString().trim { it <= ' '}) -> {
                    Toast.makeText(
                        this@Register,
                        "Please enter email.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(reg_password.text.toString().trim { it <= ' '}) -> {
                    Toast.makeText(
                        this@Register,
                        "Please enter password.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    val mFullName = findViewById<View>(R.id.fullname)
                    val mEmail : String = reg_email.text.toString()
                    val mPassword : String = reg_password.text.toString()

                    val mRegisterBtn = findViewById<View>(R.id.btn_select_register)
                    val mLoginBtn = findViewById<View>(R.id.btn_select_login)

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(mEmail, mPassword)
                        .addOnCompleteListener(
                            OnCompleteListener<AuthResult> { task ->

                            if (task.isSuccessful) {
                                val firebaseUser: FirebaseUser = task.result!!.user!!

                                Toast.makeText(
                                    this@Register,
                                    "You are registered successfully.",
                                    Toast.LENGTH_SHORT
                                ).show()

                                val intent =
                                    Intent(this@Register, MainActivity::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                intent.putExtra("user_id", firebaseUser.uid)
                                intent.putExtra("email_id", mEmail)
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(
                                    this@Register,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        })
                }
            }



        }
    }
}
