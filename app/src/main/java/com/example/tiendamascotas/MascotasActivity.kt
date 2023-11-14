package com.example.tiendamascotas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tiendamascotas.ui.theme.TiendaMascotasTheme
import androidx.compose.ui.res.painterResource

data class Product(val name: String, val description: String, val price: Double, val imageResId: Int)

class MascotasActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TiendaMascotasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MascotasList(products = createProductList())
                }
            }
        }
    }

    fun createProductList(): List<Product> {
        return listOf(
            Product("Perro Husky", "Es un fantástico perro de compañía realmente popular por su bonita tez, resistente cuerpo y aspecto parecido al del lobo", 1800.0, R.drawable.husky),
            Product("Gato Ragdoll", "Es un gato muy dormilón y tranquilo, al cual no le gusta demasiado realizar ejercicio pero detesta la soleda,es un animal al que le gusta el ambiente familiar", 1200.0, R.drawable.ragdoll),
            Product("Conejo Hotot", "Suelen ser algo miedosos pero con el tiempo se acostumbrarán a tu presencia. Destaca por sus características físicas como lo son sus ojos castaños enmarcados por un círculo negro", 520.0, R.drawable.hotot),
            // Agrega más productos aquí
        )
    }
}

@Composable
fun MascotasList(products: List<Product>) {
    LazyColumn {
        items(products) { product ->
            ProductItem(product = product)
            Divider() // Añade un divisor entre productos
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Agrega la imagen del producto
        Image(
            painter = painterResource(id = product.imageResId),
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .background(MaterialTheme.colorScheme.primary)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Agrega el nombre, descripción y precio del producto
        Text(text = product.name, style = MaterialTheme.typography.bodySmall, color = Color.Blue)
        Text(text = product.description)
        Text(text = "$${product.price}", color = Color.Red)
    }
}

@Preview(showBackground = true)
@Composable
fun MascotasListPreview() {
    TiendaMascotasTheme {
        MascotasList(products = createProductList())
    }
}
fun createProductList(): List<Product> {
    return listOf(
        Product("Perro Husky", "Es un fantástico perro de compañía realmente popular por su bonita tez, resistente cuerpo y aspecto parecido al del lobo", 1800.0, R.drawable.husky),
        Product("Gato Ragdoll", "Es un gato muy dormilón y tranquilo, al cual no le gusta demasiado realizar ejercicio pero detesta la soleda,es un animal al que le gusta el ambiente familiar", 1200.0, R.drawable.ragdoll),
        Product("Conejo Hotot", "Suelen ser algo miedosos pero con el tiempo se acostumbrarán a tu presencia. Destaca por sus características físicas como lo son sus ojos castaños enmarcados por un círculo negro", 520.0, R.drawable.hotot),
        // Agrega más productos según sea necesario
    )
}
