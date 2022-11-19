package com.example.project

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.project.databinding.ActivityMainBinding
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
    
    
    @SuppressLint("PrivateResource")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainActivityBinding.root
        setContentView(view)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE
        )
        
        val activityName = getString(R.string.first_activity_name) + ": v_" + BuildConfig.VERSION_NAME + "." + BuildConfig.VERSION_CODE
        mainActivityBinding.name.text = activityName
        
        mainActivityBinding.nextActivity.setOnClickListener {
            Intent(context, SecondActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}
