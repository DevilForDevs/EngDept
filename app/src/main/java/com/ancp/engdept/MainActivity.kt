package com.ancp.engdept

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ancp.engdept.auths.changepassword.ChangePasswordScreen
import com.ancp.engdept.auths.loginscreen.LoginScreen
import com.ancp.engdept.teacherscreens.thomescreen.TeacherHomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "teacherHomeScreen"
            ) {
                composable("loginScreen") {
                    LoginScreen()
                }
                composable("changePassword") {
                    ChangePasswordScreen()
                }
                composable("teacherHomeScreen") {
                    TeacherHomeScreen()
                }


            }
        }
    }
}



