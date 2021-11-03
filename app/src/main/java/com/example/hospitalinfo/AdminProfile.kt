package com.example.hospitalinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class AdminProfile : AppCompatActivity() {

//    private lateinit var profileUpdate: Button
//    private lateinit var profile_fullname_top: TextView
//    private lateinit var profile_username_top: TextView
//    private lateinit var profile_username: TextInputLayout
//    private lateinit var profile_fullname: TextInputLayout
//    private lateinit var profile_email: TextInputLayout
//    private lateinit var profile_phonenumber: TextInputLayout
//    private lateinit var database: DatabaseReference
//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_profile)
//
//        val obj = Login()
//        val usernamefordata = obj.usernameForProfileSet
//        readData(usernamefordata)
//
//
//        profile_fullname_top = findViewById(R.id.profile_full_name_top)
//        profile_username_top = findViewById(R.id.profile_username_top)
//
//        profile_username = findViewById(R.id.profile_username)
//        profile_fullname = findViewById(R.id.profile_full_name)
//        profile_email = findViewById(R.id.profile_email)
//        profile_phonenumber = findViewById(R.id.profile_phone_number)
//
////        showAllUserData()
//
//
//
    }
//
//    private fun readData(usernamefordata: String) {
//
//        database = FirebaseDatabase.getInstance().getReference("datauser")
//        database.child(usernamefordata).get().addOnSuccessListener {
//
//            if (it.exists()){
//
//                val profile_usernameset = it.child("username").value
//                val profile_fullnameset = it.child("fullname").value
//                val profile_emailset = it.child("email").value
//                val profile_phoneset = it.child("phoneno").value
//                profile_fullname_top.text = profile_fullnameset.toString()
//                profile_username_top.text = profile_usernameset.toString()
//                profile_username.editText?.setText(profile_usernameset.toString())
//                profile_fullname.editText?.setText(profile_fullnameset.toString())
//                profile_phonenumber.editText?.setText(profile_phoneset.toString())
//                profile_email.editText?.setText(profile_emailset.toString())
//
//            }else{
//
//                Log.d("FETCH DATA", "Fetching Error")
//            }
//        }.addOnFailureListener{
//            Log.d("FETCH DATA", "Fetching Error")
//        }
//    }

//    override fun onSupportNavigateUp(): Boolean {
//        homeActvity()
//        return true
//    }
//
//    override fun onBackPressed() {
//        homeActvity()
//    }
//
//    private fun homeActvity(){
//
//        val intent = Intent(this, UserDashbord::class.java)
//        startActivity(intent)
//    }
//    private fun showAllUserData(){
//
//        val intent = getIntent()
//
//        val profile_usernameset: String = intent.getStringExtra("username").toString()
//        val profile_fullnameset: String = intent.getStringExtra("name").toString()
//        val profile_emailset: String = intent.getStringExtra("email").toString()
//        val profile_phoneset: String = intent.getStringExtra("phoneno").toString()
//
//        profile_fullname_top.setText(profile_fullnameset)
//        profile_username_top.setText(profile_usernameset)
//
//        profile_username.editText?.setText(profile_usernameset)
//        profile_fullname.editText?.setText(profile_fullnameset)
//        profile_email.editText?.setText(profile_emailset)
//        profile_phonenumber.editText?.setText(profile_phoneset)
//    }

}