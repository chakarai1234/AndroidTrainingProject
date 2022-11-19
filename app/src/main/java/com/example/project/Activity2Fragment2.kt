package com.example.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.project.databinding.FragmentActivity22Binding

class Activity2Fragment2 : Fragment() {
    
    private lateinit var fragmentActivity22Binding: FragmentActivity22Binding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val args: Activity2Fragment2Args by navArgs()
        // Inflate the layout for this fragment
        fragmentActivity22Binding = FragmentActivity22Binding.inflate(inflater, container, false)
        val view = fragmentActivity22Binding.root
        
        fragmentActivity22Binding.name.text = args.name
        fragmentActivity22Binding.age.text = args.age
        
        fragmentActivity22Binding.toFragment1.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.navigateToFragment1)
        }
        return view
    }
}
