package com.example.androidexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidexample.model.Author
import com.example.androidexample.ui.theme.AndroidExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidExampleTheme {
                Scaffold() { innerPadding ->
                    AuthorCard(
                        author = Author(name="Ilja", email = "poputnikov@bmstu.ru"),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun AuthorCard(
    author: Author,
    modifier: Modifier
) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.author),
            contentDescription = "Author Placeholder Pic",
            Modifier.height(64.dp)
        )
        Column (horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = author.name)
            Text(text = author.email)
        }
    }
}