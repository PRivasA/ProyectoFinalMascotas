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

data class Products(val name: String, val description: String, val price: Double, val imageResId: Int)

class AccesoriosActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TiendaMascotasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AcceriosList(products = createProductList())
                }
            }
        }
    }

    fun createProductList(): List<Product> {
        return listOf(
            Product("Accesorio", "Cama Dognut Macho Talla M", 229.99, R.drawable.cama),
            Product("Accesorio", "Juego Rascador Para Gatos ", 59.50, R.drawable.juego),
            Product("Accesorio", "Trixie Set conejos, totalmente ajustable", 136.50, R.drawable.set),
            // Agrega más productos aquí
        )
    }
}

@Composable
fun AcceriosList(products: List<Product>) {
    LazyColumn {
        items(products) { product ->
            ProductItem(product = product)
            Divider() // Añade un divisor entre productos
        }
    }
}

@Composable
fun ProductsItem(product: Product) {
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
        Text(text = product.name, style = MaterialTheme.typography.bodySmall, color= Color.Blue)
        Text(text = product.description)
        Text(text = "$${product.price}", color = Color.Red)
    }
}

@Preview(showBackground = true)
@Composable
fun AccesoriosListPreview() {
    TiendaMascotasTheme {
        MascotasList(products = createProductList())
    }
}
fun createProductsList(): List<Product> {
    return listOf(
        Product("Acesorio", "Cama Dognut Macho Talla M", 229.99, R.drawable.cama),
        Product("Acesorio", "Juego Rascador Para Gatos ", 59.50, R.drawable.juego),
        Product("Acesorio", "Trixie Set conejos, totalmente ajustable", 136.50, R.drawable.set),
        // Agrega más productos según sea necesario
    )
}
