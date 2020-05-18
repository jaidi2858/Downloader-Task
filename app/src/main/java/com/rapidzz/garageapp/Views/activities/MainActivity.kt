package com.rapidzz.garageapp.Views.activities

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.View
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rapidzz.garageapp.R
import com.rapidzz.garageapp.Utils.Application.gone
import com.rapidzz.garageapp.Utils.Application.visible
import com.rapidzz.garageapp.Views.adapters.UserItemMenuAdapter
import kotlinx.android.synthetic.main.navigation_layout.*

class MainActivity : BaseActivity(),UserItemMenuAdapter.NavItemClickListner {

    private lateinit var appBarConfiguration: AppBarConfiguration
    var toolbar: Toolbar ?= null
    var navController:NavController ?= null
    var drawerLayout: DrawerLayout ?= null
    var needBackMove:Boolean = false



    override fun getLayoutId(): Int {
       return R.layout.activity_main
    }


    override fun onclicked(position: Int) {
        when(position)
        {
            3->{
                navController!!.navigate(R.id.changePasswordFragment)
                drawerLayout?.closeDrawer(GravityCompat.START)
            }
        }
    }

    override fun initViews()
    {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        loadNavigationMenu()
         drawerLayout= findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
         navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(navController!!.graph, drawerLayout
        )
        setupActionBarWithNavController(navController!!, appBarConfiguration)
        navView.setupWithNavController(navController!!)


        toolbar?.setNavigationOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                if(drawerLayout?.isDrawerOpen(GravityCompat.START)!!) {
                    drawerLayout?.closeDrawer(GravityCompat.START)
                } else {
                    if(needBackMove)
                    {
                        onBackPressed()
                    }
                    else {
                        drawerLayout?.openDrawer(GravityCompat.START)
                    }
                }
            }
        });
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }



    fun hideToolbar(isHide:Boolean)
    {
        if(isHide)
        {
            toolbar?.setNavigationIcon(R.drawable.ic_nav_back)
        }
        else
        {
            toolbar?.setNavigationIcon(R.drawable.ic_nav_home)
        }
    }


    fun loadNavigationMenu() {
        var adapter = UserItemMenuAdapter(this)
        rlItemsMain?.let {
            it.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            it.adapter = adapter
        }

    }
}
