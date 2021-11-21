package com.example.hospitalinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.*

public class Login : AppCompatActivity() {

    private lateinit var signupbtn: Button
    private lateinit var loginbtn: Button
    private lateinit var username_var: TextInputLayout
    private lateinit var password_var: TextInputLayout

    lateinit var usernameForProfileSet: String

    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databasereference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
//
        signupbtn = findViewById(R.id.login_signup)
        loginbtn = findViewById(R.id.login_Login)
        username_var = findViewById(R.id.login_username)
        password_var = findViewById(R.id.login_password)

        loginbtn.setOnClickListener(){

            val username: String = username_var.editText?.text.toString();
            val password: String = password_var.editText?.text.toString();

            if (!username.isEmpty()){

                username_var.setError(null)
                username_var.setErrorEnabled(false)
                if (!password.isEmpty()){
                    password_var.setError(null)
                    password_var.setErrorEnabled(false)

                    val username_data: String = username_var.editText?.text.toString();
                    val password_data: String = password_var.editText?.text.toString();

                    firebaseDatabase = FirebaseDatabase.getInstance()
                    databasereference = firebaseDatabase.getReference("datauser")

                    var check_username: Query = databasereference.orderByChild("username").equalTo(username_data)
                    val postListener = object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            if (dataSnapshot.exists()){
                                username_var.setError(null)
                                username_var.setErrorEnabled(false)
                                val passwordcheck: String = dataSnapshot.child(username_data).child("password").getValue().toString()
//                                usernameForProfileSet = dataSnapshot.child(username_data).child("username").getValue().toString()
                                if (passwordcheck.equals(password_data)){
                                    password_var.setError(null)
                                    password_var.setErrorEnabled(false)

//                                    val email: String = dataSnapshot.child(username_data).child("email").getValue().toString()
//                                    val name: String = dataSnapshot.child(username_data).child("fullname").getValue().toString()
//                                    val phoneno: String = dataSnapshot.child(username_data).child("phoneno").getValue().toString()
//                                    val username: String = dataSnapshot.child(username_data).child("username").getValue().toString()
//
//                                    val inten = Intent(this@Login, AdminProfile::class.java)
//                                    inten.putExtra("name", name)
//                                    inten.putExtra("email", email)
//                                    inten.putExtra("username", username)
//                                    inten.putExtra("phoneno", phoneno)
//                                    startActivity(inten)

                                    val intent = Intent(this@Login, UserDashbord::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                                else{
                                    password_var.setError("Wrong password")
                                }
                            }
                            else{
                                username_var.setError("Username dose not exists")
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {

                        }
                    }
                    check_username.addListenerForSingleValueEvent(postListener)
                }
                else{
                    password_var.setError("Please enter password")
                }
            }
            else{
                username_var.setError("Please enter the username")
            }
        }

        signupbtn.setOnClickListener(){

            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }
    }
}