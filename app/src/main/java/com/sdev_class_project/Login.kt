package com.sdev_class_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_btn_select_register.setOnClickListener{
            startActivity(Intent(this@Login, Register::class.java))
        }

        fun forgotPassword() {
            startActivity(Intent(this@Login, forgotEnter::class.java))
        }

        loginTextForgot.setOnClickListener {
            forgotPassword()
        }

        login_btn_select_login.setOnClickListener {
            when {
//                TextUtils.isEmpty(fullname.text.toString().trim { it <= ' '}) -> {
//                    Toast.makeText(
//                        this@Register,
//                        "Please enter your name.",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }

                TextUtils.isEmpty(login_field_uname.text.toString().trim { it <= ' '}) -> {
                    Toast.makeText(
                        this@Login,
                        "Please enter email.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(login_field_password.text.toString().trim { it <= ' '}) -> {
                    Toast.makeText(
                        this@Login,
                        "Please enter password.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    val mFullName = findViewById<View>(R.id.fullname)
                    val mEmail : String = login_field_uname.text.toString()
                    val mPassword : String = login_field_password.text.toString()

                    val mRegisterBtn = findViewById<View>(R.id.btn_select_register)
                    val mLoginBtn = findViewById<View>(R.id.btn_select_login)

                    FirebaseAuth.getInstance().signInWithEmailAndPassword(mEmail, mPassword)
                        .addOnCompleteListener { task ->

                                if (task.isSuccessful) {
//                                    val firebaseUser: FirebaseUser = task.result!!.user!!

                                    Toast.makeText(
                                        this@Login,
                                        "You are logged in successfully.",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                    val intent =
                                        Intent(this@Login, MainActivity::class.java)
                                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    intent.putExtra("user_id", FirebaseAuth.getInstance().currentUser!!.uid)
                                    intent.putExtra("email_id", mEmail)
                                    startActivity(intent)
                                    finish()
                                } else {
                                    Toast.makeText(
                                        this@Login,
                                        task.exception!!.message.toString(),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                }
            }



        }
    }
}