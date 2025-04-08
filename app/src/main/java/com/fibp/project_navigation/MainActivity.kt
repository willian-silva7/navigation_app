package com.fibp.project_navigation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Login()
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Login() {
        var user by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        val context = LocalContext.current

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFFF3366)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Spacer(modifier = Modifier.height(48.dp))
                Image(
                    imageVector = Icons.Default.Person,
                    contentDescription = "User Icon",
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.White, shape = CircleShape)
                        .padding(16.dp)
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(
                        RoundedCornerShape(
                            topStart = 80.dp,
                            topEnd = 0.dp
                        )
                    ) // Arredonda apenas o topo
                    .background(Color.White)
                    .padding(30.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    Text(
                        text = "Welcome",
                        color = Color(0xFFFF3366),
                        fontSize = 30.sp,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(30.dp, 20.dp, 30.dp, 80.dp)
                    )

                    Text(
                        text = "User",
                        color = Color(0xFFFF3366),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .padding(5.dp, 0.dp, 0.dp, 0.dp)
                    )

                    OutlinedTextField(
                        value = user,
                        onValueChange = { user = it },
                        maxLines = 1,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(25.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.LightGray
                        ),
                        textStyle = androidx.compose.ui.text.TextStyle(
                            textAlign = TextAlign.Start
                        )
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    Text(
                        text = "Password",
                        color = Color(0xFFFF3366),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .padding(5.dp, 0.dp, 0.dp, 0.dp)
                    )

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        maxLines = 1,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(25.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.LightGray
                        ),
                        textStyle = androidx.compose.ui.text.TextStyle(
                            textAlign = TextAlign.Start
                        )
                    )

                    Spacer(modifier = Modifier.height(64.dp))

                    Button(
                        onClick = {
                            if (user.isEmpty() || password.isEmpty()) {
                                Toast.makeText(context, "Preencha todos os dados", Toast.LENGTH_SHORT).show()
                            }
                        },
                        modifier = Modifier
                            .height(70.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF3366))
                    ) {
                        Text(
                            text = "LOGIN",
                            color = Color.White,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }

    @Preview(device = "id:pixel_6")
    @Composable
    fun LoginPreview(){
        Login()
    }
}