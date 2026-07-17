package com.ancp.engdept.splashscreen


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ancp.engdept.db.entitydao.user.UserEntity
import com.ancp.engdept.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel(){
    fun loadUser(goToLoginScreen:()-> Unit,goToHomeScreen:(UserEntity)-> Unit) {
        viewModelScope.launch {
            val user = repository.getUser()
            if (user==null){
                goToLoginScreen()
            }else{
                goToHomeScreen(user)
            }

        }
    }
}