package com.ancp.engdept.studentscreen.studenthomescreen

import androidx.lifecycle.ViewModel
import com.ancp.engdept.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StudentHomeViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    fun loadUser(){

    }

    fun loadClasses(){

    }

}
