package com.example.tiendamascotas

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.example.tiendamascotas.ui.theme.TiendaMascotasTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TiendaMascotasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Agregamos la imagen o cualquier otro contenido que desees en el centro
        MyImage()

        Spacer(modifier = Modifier.height(16.dp))

        // Agregamos los botones del menú inferior
        BottomMenuButtons()
    }
}

@Composable
fun BottomMenuButtons() {
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BottomMenuButton("Mascotas", Icons.Default.Home) {
            startActivity(context, MascotasActivity::class.java)
        }

        BottomMenuButton("Alimentos", Icons.Default.Add) {
            startActivity(context, AlimentosActivity::class.java)
        }

        BottomMenuButton("Accesorios", Icons.Default.Create) {
            startActivity(context, AccesoriosActivity::class.java)
        }
    }
}
@Composable
fun BottomMenuButton(text: String, icon: ImageVector, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable { onClick() }
    ) {
        Icon(imageVector = icon, contentDescription = null)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)
    }
}

@Composable
fun MyImage() {
    val painter: Painter = painterResource(id = R.drawable.logoss)

    // Modifica el tamaño y otros atributos según sea necesario
    Image(
        painter = painter,
        contentDescription = "Descripción de la imagen",
        modifier = Modifier.size(200.dp)
    )
}

fun startActivity(context: Context, activity: Class<*>) {
    val intent = Intent(context, activity)
    ContextCompat.startActivity(context, intent, null)
}
