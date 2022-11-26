package com.example.project.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project.models.users.UsersResponse
import com.example.project.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {
    
    private val _data = MutableLiveData<UsersResponse>()
    val data: LiveData<UsersResponse> = _data
    
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error
    
    
    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name
    
    private val _age = MutableLiveData<String>()
    val age: LiveData<String> = _age
    
    
    init {
        getData()
    }
    
    private fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                
                val response = mainRepository.getAllUsers()
                
                if (response.isSuccessful) {
                    _data.postValue(response.body())
                } else {
                    throw Exception("Error")
                }
            } catch (e: Exception) {
                e.message?.let {
                    Log.e("ERROR", it)
                    _error.postValue(it)
                }
            }
            
        }
    }
    
    fun setName(nameValue: String) {
        _name.value = nameValue
    }
    
    fun setAge(ageValue: String) {
        _age.value = ageValue
    }
    
}
