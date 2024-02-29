package com.mobile.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mobile.calculator.ui.theme.CalculatorTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    CalculatorButtons()
                }
            }
        }
    }
}

@Composable
fun CalculatorButtons() {
// RelativeLayout(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
    Text(text = "", color = Color(ContextCompat.getColor(LocalContext.current, R.color.white)), fontSize = 15.sp, maxLines = 1, modifier = Modifier.fillMaxWidth().height(70.dp).padding(10.dp))
    Text(text = "", color = Color(0xfff.toInt()), fontSize = 50.sp, maxLines = 1, modifier = Modifier.fillMaxWidth().height(100.dp).padding(10.dp))
    Card(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
        Column {
            Column {
                Row {
                    Row {
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = "AC", textAlign = TextAlign.Center)
                        }
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = "C", textAlign = TextAlign.Center)
                        }
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = "(", textAlign = TextAlign.Center)
                        }
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = ")", textAlign = TextAlign.Center)
                        }
                    }
                }
                Row {
                    Row {
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = "sin", textAlign = TextAlign.Center)
                        }
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = "cos", textAlign = TextAlign.Center)
                        }
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = "tan", textAlign = TextAlign.Center)
                        }
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = "log", textAlign = TextAlign.Center)
                        }
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = "ln", textAlign = TextAlign.Center)
                        }
                    }
                }
                Row {
                    Row {
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = "x!", textAlign = TextAlign.Center)
                        }
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = "x²", textAlign = TextAlign.Center)
                        }
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = "√", textAlign = TextAlign.Center)
                        }
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = "1/x", textAlign = TextAlign.Center)
                        }
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = "÷", textAlign = TextAlign.Center)
                        }
                    }
                }
                Row {
                    Row {
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = "7", textAlign = TextAlign.Center)
                        }
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = "8", textAlign = TextAlign.Center)
                        }
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = "9", textAlign = TextAlign.Center)
                        }
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = "×", textAlign = TextAlign.Center)
                        }
                    }
                }
                Row {
                    Row {
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = "4", textAlign = TextAlign.Center)
                        }
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = "5", textAlign = TextAlign.Center)
                        }
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = "6", textAlign = TextAlign.Center)
                        }
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = "-", textAlign = TextAlign.Center)
                        }
                    }
                }
                Row {
                    Row {
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = "1", textAlign = TextAlign.Center)
                        }
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = "2", textAlign = TextAlign.Center)
                        }
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = "3", textAlign = TextAlign.Center)
                        }
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = "+", textAlign = TextAlign.Center)
                        }
                    }
                }
                Row {
                    Row {
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = "π", textAlign = TextAlign.Center)
                        }
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = "0", textAlign = TextAlign.Center)
                        }
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = ".", textAlign = TextAlign.Center)
                        }
                        Button(onClick = {}, modifier = Modifier.padding(6.dp)) {
                            Text(text = "=", textAlign = TextAlign.Center)
                        }
                    }
                }
            }
        }
    }
// }
}