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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.androidexample.model.Author
import com.example.androidexample.network.ExampleApi
import com.example.androidexample.ui.theme.AndroidExampleTheme
import com.example.androidexample.vm.AuthorViewModel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AndroidExampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize().padding(32.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AuthorScreen()
                }
            }
        }
    }
}

@Composable
@Preview
fun AuthorScreen(modifier: Modifier = Modifier.padding(80.dp)) {

    val authorViewModel: AuthorViewModel = viewModel()
    AuthorCard(authorViewModel.authorData, modifier = Modifier.padding(16.dp))
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
        Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(horizontal=16.dp)) {
            Text(text = author.name)
            Text(text = author.email)
        }
    }
}