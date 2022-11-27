package com.example.project

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.project.databinding.ActivityMainBinding
import com.example.project.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    
    @Inject
    @Named("applicationName")
    lateinit var applicationName: String
    
    private lateinit var mainActivityBinding: ActivityMainBinding
    
    @Inject
    @ApplicationContext
    lateinit var context: Context
    
    private val mainViewModel: MainViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(applicationName, "onCreate")
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainActivityBinding.root
        setContentView(view)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE
        )


//        val activityName = getString(R.string.first_activity_name) + ": v_" + BuildConfig.VERSION_NAME + "." + BuildConfig.VERSION_CODE
        
        
        mainViewModel.data.toString().let { Log.d("Data", it) }
        
        mainViewModel.data.observe(this) {
            mainActivityBinding.name.text = it[0].name
        }
        
        mainViewModel.error.observe(this) {
            mainActivityBinding.name.text = it
        }
        
        
        
        mainActivityBinding.nextActivity.setOnClickListener {
            Intent(context, SecondActivity::class.java).also {
                startActivity(it)
            }
        }
    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.i(applicationName, "onPause")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.i(applicationName, "onResume")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.i(applicationName, "onStop")
//    }
//
//    override fun onStart() {
//        super.onStart()
//        Log.i(applicationName, "onStart")
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        Log.i(applicationName, "onRestart")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.i(applicationName, "onDestroy")
//    }
//
}
