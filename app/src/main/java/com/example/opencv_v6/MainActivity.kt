package com.example.opencv_v6

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.opencv_v6.ui.theme.OpenCV_V6Theme

import org.opencv.android.OpenCVLoader
import org.opencv.core.Core
import org.opencv.core.CvType
import org.opencv.core.Mat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OpenCV_V6Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
        // Check if OpenCV library is loaded successfully
        if (!OpenCVLoader.initDebug()) {
            println("OpenCV initialization failed.")
            return
        }

        // If initialization is successful, create a sample matrix
        val mat = Mat(3, 3, CvType.CV_8UC1)
        Core.randn(mat, 0.0, 1.0)

        // Print the matrix data to the console
        println("Sample Matrix:")
        println(mat.dump())
        Log.d("Test_OpenCV","Sample Matrix:")
        Log.d("Test_OpenCV",mat.dump())
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OpenCV_V6Theme {
        Greeting("Android")
    }
}