package com.example.tiendamascotas

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var username by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var isValid by remember { mutableStateOf(false) }
            var showError by remember { mutableStateOf(false) }
            val context = LocalContext.current
            val keyboardController = LocalSoftwareKeyboardController.current

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Usuario") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { keyboardController?.show() }
                    )
                )

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Contraseña") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            isValid = checkCredentials(username, password)
                            if (isValid) {

                                startActivity(Intent(context, HomeActivity::class.java))
                            } else {
                                showError = true
                            }
                        }
                    )
                )

                if (showError) {
                    Text(
                        text = "Usuario y/o contraseña incorrectos",
                        color = Color.Red,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        isValid = checkCredentials(username, password)
                        if (isValid) {
                            // Iniciar actividad Home
                            startActivity(Intent(context, HomeActivity::class.java))
                        } else {
                            showError = true
                        }
                    }
                ) {
                    Text("Iniciar sesión")
                }
            }
        }
    }

    private fun checkCredentials(username: String, password: String): Boolean {
        // Aquí deberías implementar la lógica para verificar las credenciales.
        // Por ahora, solo devolverá true si el usuario es "admin" y la contraseña es "admin123".
        return username == "admin" && password == "admin123"
    }
}
