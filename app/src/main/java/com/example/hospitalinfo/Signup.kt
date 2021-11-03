package com.example.hospitalinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class Signup : AppCompatActivity() {

//    private  lateinit var binding: ActivitySignupBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var firebaseDatabase: FirebaseDatabase
    private  lateinit var signupRegister : Button
    private  lateinit var signupEmail : EditText
    private  lateinit var signupPass : EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_signup)
        auth = Firebase.auth
        signupRegister = findViewById(R.id.signup_register)
        signupEmail = findViewById(R.id.signup_email)
        signupPass = findViewById(R.id.signup_password)
        firebaseDatabase = FirebaseDatabase.getInstance()

        signupRegister.setOnClickListener(){

            auth.createUserWithEmailAndPassword(signupEmail.text.toString(), signupPass.text.toString()).
            addOnCompleteListener(){

                if (it.isSuccessful){
                    Toast.makeText(this, "User Created Successfully", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, "it.exception.toString()", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}

