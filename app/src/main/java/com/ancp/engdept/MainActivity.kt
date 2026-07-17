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
import com.ancp.engdept.splashscreen.SplashScreen
import com.ancp.engdept.studentscreen.studenthomescreen.StudentHomeScreen
import com.ancp.engdept.teacherscreens.thomescreen.TeacherHomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "SplashScreen"
            ) {

                composable("SplashScreen") {
                    SplashScreen(navController = navController)
                }
                composable("loginScreen") {
                    LoginScreen(navController = navController)
                }
                composable("changePassword") {
                    ChangePasswordScreen()
                }
                composable("teacherHomeScreen") {
                    TeacherHomeScreen()
                }
                composable("studentHomeScreen") {
                    StudentHomeScreen()
                }


            }
        }
    }
}



