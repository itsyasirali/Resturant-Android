package com.itsyasirali.restaurant.ui.authentication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itsyasirali.restaurant.data.Repo
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val repository = Repo()

    private val _isSignUpSuccessful = MutableLiveData<Boolean>()
    val isSignUpSuccessful: LiveData<Boolean> = _isSignUpSuccessful

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    fun signUp(name: String, email: String, phone: String, address: String, password: String) {
        viewModelScope.launch {
            _errorMessage.value = null
            val result = repository.registerUser(name, email, phone, address, password)
            if (result.isSuccess) {
                _isSignUpSuccessful.value = true
            } else {
                _isSignUpSuccessful.value = false
                _errorMessage.value = result.exceptionOrNull()?.message ?: "Unknown error"
            }
        }
    }
}
