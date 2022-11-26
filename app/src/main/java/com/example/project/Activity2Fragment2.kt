package com.example.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.project.databinding.FragmentActivity22Binding
import com.example.project.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Activity2Fragment2 : Fragment() {
    
    private lateinit var fragmentActivity22Binding: FragmentActivity22Binding
    
    private val mainViewModel: MainViewModel by viewModels()
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val args: Activity2Fragment2Args by navArgs()
        // Inflate the layout for this fragment
        fragmentActivity22Binding = DataBindingUtil.inflate(inflater, R.layout.fragment_activity22, container, false)
        val view = fragmentActivity22Binding.root
        
        fragmentActivity22Binding.mainViewModel = mainViewModel
        fragmentActivity22Binding.lifecycleOwner = this
        
        val index = args.myData.age.toInt().or(0)
        
        mainViewModel.data.observe(viewLifecycleOwner) { response ->
            mainViewModel.setName(response[index].name)
            mainViewModel.setAge(response[index].id.toString())
            
        }
        
        fragmentActivity22Binding.toFragment1.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.navigateToFragment1)
        }
        return view
    }
}
