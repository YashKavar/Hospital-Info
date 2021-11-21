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
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class Signup : AppCompatActivity() {

    private  lateinit var signupRegister : Button
    private lateinit var signupLogin : Button
    private  lateinit var signupEmail : TextInputLayout
    private  lateinit var signupPass : TextInputLayout
    private  lateinit var signupUsername : TextInputLayout
    private lateinit var regex : String

    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var reference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        signupRegister = findViewById(R.id.signup_register)
        signupLogin = findViewById(R.id.signup_login)
        signupEmail = findViewById(R.id.signup_email)
        signupPass = findViewById(R.id.signup_password)
        signupUsername = findViewById(R.id.signup_username)

        regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"

        signupRegister.setOnClickListener(){

            val create_username: String = signupUsername.editText?.text.toString();
            val create_password: String = signupPass.editText?.text.toString();
            val create_email: String = signupEmail.editText?.text.toString();

            if (!create_username.isEmpty()){

                signupUsername.setError(null)
                signupUsername.setErrorEnabled(false)
                if (!create_email.isEmpty()){

                    signupEmail.setError(null)
                    signupEmail.setErrorEnabled(false)
                    if (!create_password.isEmpty()){

                        signupPass.setError(null)
                        signupPass.setErrorEnabled(false)

                        if (!create_email.matches(regex.toRegex())){

                            firebaseDatabase = FirebaseDatabase.getInstance()
                            reference = firebaseDatabase.getReference("datauser")

                            val fetch_username: String = signupUsername.editText?.text.toString();
                            val fetch_password: String = signupPass.editText?.text.toString();
                            val fetch_email: String = signupEmail.editText?.text.toString();

                            val dataStore = StoringData(fetch_username, fetch_email, fetch_password)
                            reference.child(fetch_username).setValue(dataStore)

                            Toast.makeText(this, "Register Successfully", Toast.LENGTH_SHORT).show()

                            val intent = Intent(this, Login::class.java)
                            startActivity(intent)

                        }
                        else{
                            signupEmail.setError("Invalid Email")
                        }
                    }
                    else{
                        signupPass.setError("Please enter Password")
                    }
                }
                else{
                    signupEmail.setError("Please enter Email")
                }
            }
            else{
                signupUsername.setError("Please enter Username")
            }
        }

        signupLogin.setOnClickListener(){

            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

    }
}


