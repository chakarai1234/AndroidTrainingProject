package com.example.project

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.project.databinding.FragmentActivity21Binding
import com.example.project.models.MyData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Activity2Fragment1 : Fragment() {
    
    private lateinit var fragmentActivity21Binding: FragmentActivity21Binding
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentActivity21Binding = FragmentActivity21Binding.inflate(inflater, container, false)
        fragmentActivity21Binding.goBack.setOnClickListener {
            activity?.finish()
        }
        
        return fragmentActivity21Binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setOnClickListener { v ->
//            fragmentActivity21Binding.etName.clearFocus()
            fragmentActivity21Binding.etAge.clearFocus()
            
            val imm = activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(v.windowToken, 0)
            
            val myData = MyData(
//                fragmentActivity21Binding.etName.text.toString(),
                "hello",
                fragmentActivity21Binding.etAge.text.toString()
            )
            
            fragmentActivity21Binding.toFragment2.setOnClickListener {
                val action = Activity2Fragment1Directions.navigateToFragment2(
                    myData
                )
                Navigation.findNavController(view).navigate(action)
            }
        }
    }
}
