package com.fibp.project_navigation.ui.login.ui

import android.content.Context
import android.widget.Toast
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFFF3366))
    ) {
        Login(Modifier.align(Alignment.Center))
    }
}

@Composable
fun Login(modifier: Modifier) {
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.height(48.dp))
        HeaderImage(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(48.dp))
        BoxInterface()
    }
}

@Composable
fun BoxInterface() {
    val context = LocalContext.current
    var password by remember { mutableStateOf("") }
    var user by remember { mutableStateOf("") }

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
        Column {
            WelcomeLabel()
            Spacer(modifier = Modifier.padding(8.dp))
            UserLabel()
            UserField(user) { user = it }
            Spacer(modifier = Modifier.padding(16.dp))
            PasswordLabel()
            PasswordField(password) { password = it }
            Spacer(modifier = Modifier
                .padding(16.dp)
                .height(32.dp))
            ButtonLogin(user, password, context)
        }
    }
}

@Composable
fun ButtonLogin(user: String, password: String, context: Context) {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(password: String, onPasswordChange: (String) -> Unit) {

    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        maxLines = 1,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(25.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.LightGray, // Fundo transparente
            unfocusedBorderColor = Color.Transparent,  // Cor da borda quando não focado
            focusedBorderColor = Color(0xFFFF3366), // Cor da borda quando focado
            textColor = Color.Black, // Cor do texto
            placeholderColor = Color.DarkGray // Cor do placeholder
        ),
        textStyle = TextStyle(
            textAlign = TextAlign.Start
        ),
        placeholder = { Text(text = "Digite a sua senha")},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}

@Composable
fun PasswordLabel() {
    Text(
        text = "Password",
        color = Color(0xFFFF3366),
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(5.dp, 0.dp, 0.dp, 0.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserField(user: String, onUserChange: (String) -> Unit) {

    OutlinedTextField(
        value = user,
        onValueChange = onUserChange,
        maxLines = 1,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(25.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.LightGray, // Fundo transparente
            unfocusedBorderColor = Color.Transparent,  // Cor da borda quando não focado
            focusedBorderColor = Color(0xFFFF3366), // Cor da borda quando focado
            textColor = Color.Black, // Cor do texto
            placeholderColor = Color.DarkGray // Cor do placeholder
        ),
        textStyle = TextStyle(
            textAlign = TextAlign.Start
        ),
        placeholder = { Text(text = "Digite o seu Username")},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    )
}

@Composable
fun UserLabel() {
    Text(
        text = "User",
        color = Color(0xFFFF3366),
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(5.dp, 0.dp, 0.dp, 0.dp)
    )
}

@Composable
fun WelcomeLabel() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
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
    }
}


@Composable
fun HeaderImage(modifier: Modifier) {
    Image(
        imageVector = Icons.Default.Person,
        contentDescription = "User Icon",
        modifier = modifier
            .size(100.dp)
            .background(Color.White, shape = CircleShape)
            .padding(16.dp)
    )
}


