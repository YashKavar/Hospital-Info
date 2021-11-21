package com.example.hospitalinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.hospitalinfo.Models.StoringData
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class Signup : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database : FirebaseDatabase
    private lateinit var register_signup : Button
    private lateinit var email_signup : TextInputLayout
    private lateinit var pass_signup: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        auth = Firebase.auth
        database = FirebaseDatabase.getInstance()
        register_signup = findViewById(R.id.signup_register)
        email_signup = findViewById(R.id.signup_email)
        pass_signup = findViewById(R.id.signup_password)

        register_signup.setOnClickListener(){

            auth.createUserWithEmailAndPassword(email_signup.editText.toString(), pass_signup.editText.toString()).
            addOnCompleteListener(){

                if (it.isSuccessful){
                    Toast.makeText(this, "User created successfully", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        }



    }
}


