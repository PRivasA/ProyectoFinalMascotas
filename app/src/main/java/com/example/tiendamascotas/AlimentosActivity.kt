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

data class Productos(val name: String, val description: String, val price: Double, val imageResId: Int)

class AlimentosActivity: ComponentActivity() {
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
            Product("Alimento para Perro", "Lata Royal Canin Hypoallergenic 400g", 76.99, R.drawable.royalcanin),
            Product("Alimento para Gato", "Hills Alimento Para Gatos Cuidado Critico A/D 5.5oz", 40.50, R.drawable.hills),
            Product("Alimento para conejo", "Heno Para Conejos Con Diente De Leon Sabor Heno", 520.99, R.drawable.heno),
            // Agrega más productos aquí
        )
    }
}

@Composable
fun AlimentosList(products: List<Product>) {
    LazyColumn {
        items(products) { product ->
            ProductItem(product = product)
            Divider() // Añade un divisor entre productos
        }
    }
}

@Composable
fun ProductossItem(product: Product) {
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
fun AlimentosListPreview() {
    TiendaMascotasTheme {
        MascotasList(products = createProductList1())
    }
}
fun createProductList1(): List<Product> {
    return listOf(
        Product("Alimento para Perro", "Lata Royal Canin Hypoallergenic 400g", 76.99, R.drawable.royalcanin),
        Product("Alimento para Gato", "Hills Alimento Para Gatos Cuidado Critico A/D 5.5oz", 40.50, R.drawable.hills),
        Product("Alimento para Conejo", "Heno Para Conejos Con Diente De Leon Sabor Heno", 520.99, R.drawable.heno),
        // Agrega más productos según sea necesario
    )
}
