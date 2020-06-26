

package com.junaid.dowloandingtask.Views.activities


import com.junaid.dowloandingtask.R
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration



    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initViews() {
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }



}
