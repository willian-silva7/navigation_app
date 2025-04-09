package com.fibp.project_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.fibp.project_navigation.ui.login.ui.LoginScreen
import com.fibp.project_navigation.ui.login.ui.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginScreen(LoginViewModel())
        }
    }



    /*@Preview(device = "id:pixel_6")
    @Composable
    fun LoginPreview(){
        Login()
    }*/
}