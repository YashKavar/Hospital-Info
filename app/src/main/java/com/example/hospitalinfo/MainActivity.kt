package com.example.hospitalinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bottomNav: BottomNavigationView = findViewById(R.id.bottomNav) as BottomNavigationView

        loadFragment(BedFragment())

        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.badInfo ->{
                    loadFragment(BedFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.plasmaInfo ->{
                    loadFragment(PlasmaFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.oxygenInfo ->{
                    loadFragment(OxygenFragment())
                    return@setOnNavigationItemSelectedListener true
                } else -> false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.custom_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.search ->{
                Toast.makeText(this,"Search", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.admin_signup_login ->{
                val intent = Intent(this, Signup::class.java)
                startActivity(intent)
                return true
            }
            R.id.contact_us ->{
                val intent = Intent(this, ContactUs::class.java)
                startActivity(intent)
                return true
            }
            R.id.settings ->{
                val intent = Intent(this, Settings::class.java)
                startActivity(intent)
                return true
            } else -> super.onOptionsItemSelected(item)
        }
    }

    private fun loadFragment(fragment: Fragment){

        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}