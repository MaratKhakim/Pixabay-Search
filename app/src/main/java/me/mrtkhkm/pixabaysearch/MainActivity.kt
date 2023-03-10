package me.mrtkhkm.pixabaysearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import me.mrtkhkm.pixabaysearch.ui.theme.PixabaySearchTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PixabaySearchTheme {
                MainApp()
            }
        }
    }
}