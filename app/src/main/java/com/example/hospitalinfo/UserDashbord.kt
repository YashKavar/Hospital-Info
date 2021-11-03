package com.example.hospitalinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class UserDashbord : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_dashbord)

        var admin_bottomNav: BottomNavigationView = findViewById(R.id.admin_bottomNav) as BottomNavigationView

        adminLoadFragment(AdminHospitalFragment())

        admin_bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.hospitalAdd ->{
                    adminLoadFragment(AdminHospitalFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.bedsAdd ->{
                    adminLoadFragment(AdminBedsFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.plasmaAdd ->{
                    adminLoadFragment(AdminPlasmaFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.oxygenAdd ->{
                    adminLoadFragment(AdminOxygenFragment())
                    return@setOnNavigationItemSelectedListener true
                } else -> false
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.admintop_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.admin_profile ->{

                val intent = Intent(this, AdminProfile::class.java)
                startActivity(intent)
                return true
            }
            R.id.admin_contact_us ->{
                val intent = Intent(this, AdminContactUs::class.java)
                startActivity(intent)
                return true
            }
            R.id.admin_settings ->{
                val intent = Intent(this, AdminSettings::class.java)
                startActivity(intent)
                return true
            } else -> super.onOptionsItemSelected(item)
        }
    }

    private fun adminLoadFragment(fragment: Fragment){

        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.admin_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}