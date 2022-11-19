package com.example.project

import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.project.databinding.ActivitySecondBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class SecondActivity : AppCompatActivity() {
    
    @Inject
    @Named("applicationName")
    lateinit var applicationName: String
    
    private lateinit var activitySecondBinding: ActivitySecondBinding
    
    @Inject
    @ApplicationContext
    lateinit var context: Context
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySecondBinding = ActivitySecondBinding.inflate(layoutInflater)
        val view = activitySecondBinding.root
        setContentView(view)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE
        )
    }
}
