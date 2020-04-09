package com.example.tothegym

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.example.tothegym.fragments.GymlistFragment
import com.example.tothegym.fragments.HomeFragment
import com.example.tothegym.fragments.TrainersFragment

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var drawerLayout: DrawerLayout;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home);

        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        var navView = findViewById<NavigationView>(R.id.nav_view)
        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout);
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        var fragmentTransaction = supportFragmentManager.beginTransaction()
        var homeFragment = HomeFragment()
        fragmentTransaction.add(R.id.container, homeFragment);
        fragmentTransaction.commit();

        navView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragmentTransaction = supportFragmentManager.beginTransaction()
        when (item.itemId) {
            R.id.menu_home -> {
                var homeFragment = HomeFragment()
                fragmentTransaction.replace(R.id.container, homeFragment);
            }
            R.id.menu_profile -> {
                Toast.makeText(this, "Update clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.menu_routine -> {

            }
            R.id.menu_trainers -> {
                var trainersFragment = TrainersFragment()
                fragmentTransaction.replace(R.id.container, trainersFragment);
            }
            R.id.menu_gym -> {
                var gymFragment = GymlistFragment()
                fragmentTransaction.replace(R.id.container, gymFragment);
            }
        }
        fragmentTransaction.commit();
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
