package com.rapidzz.kidcap.Views.activities

import android.content.Intent
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
import com.rapidzz.kidcap.R

class RegistrationActivity : BaseActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration



    override fun getLayoutId(): Int {
        return R.layout.activity_registration
    }

    override fun initViews() {

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==200) {
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
            val childFragments = navHostFragment?.childFragmentManager?.fragments
            childFragments?.forEach { it.onActivityResult(requestCode, resultCode, data) }
        }
    }
}
