package com.example.charlesli_simplearithmetic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.charlesli_simplearithmetic.ui.theme.CharlesLiSimpleArithmeticTheme

import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.RadioButton
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.text.BasicText
import kotlin.math.roundToInt
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CharlesLiSimpleArithmeticTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var val1 by remember { mutableStateOf("") }
    var val2 by remember { mutableStateOf("") }

    var option by remember { mutableIntStateOf(1)}

    var texted by remember { mutableStateOf("") }
    var answer by remember { mutableFloatStateOf (0f) }

    Column(modifier = Modifier
        .fillMaxHeight()
        .padding(horizontal = 16.dp))
    {
        Text(text = "calculator!:", modifier = Modifier.padding(top = 64.dp, bottom = 16.dp))

        TextField(
            value = val1,
            onValueChange = { val1 = it },
            label = { Text("Enter First Value") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        TextField(
            value = val2,
            onValueChange = { val2 = it },
            label = { Text("Enter Second Value") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(modifier = Modifier.padding(16.dp, bottom = 0.dp), horizontalArrangement = Arrangement.spacedBy(48.dp)){
            Text("+", modifier = Modifier.padding(2.dp))
            Text("-", modifier = Modifier.padding(2.dp))
            Text("x", modifier = Modifier.padding(2.dp))
            Text("÷", modifier = Modifier.padding(2.dp))
            Text("%", modifier = Modifier.padding(2.dp))

        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            RadioButton(
                selected = option == 1,
                onClick = { option = 1 }
            )
            RadioButton(
                selected = option == 2,
                onClick = { option = 2 }
            )
            RadioButton(
                selected = option == 3,
                onClick = { option = 3 }
            )
            RadioButton(
                selected = option == 4,
                onClick = { option = 4 }
            )
            RadioButton(
                selected = option == 5,
                onClick = { option = 5 }
            )
        }

        Button(onClick = {
            if (option == 4 && (val2.toInt()).equals(0)){
                texted = "Divide by zero error!"
            } else if (val1.toInt() > 100000000 || val2.toInt() > 100000000){
                texted = "Values are too big!"
            } else {
                texted = ""
                answer = when(option){
                    1 -> (val1.toFloat() + val2.toFloat())
                    2 -> (val1.toFloat() - val2.toFloat())
                    3 -> (val1.toFloat() * val2.toFloat())
                    4 -> (val1.toFloat() / val2.toFloat())
                    5 -> (val1.toInt() % val2.toInt()).toFloat()
                    else -> (0f)
                }
            }
        }) {
            Text("Submit")
        }

        Text(text = "Answer: ${if (texted != "") texted else answer}", modifier = Modifier.padding(top = 64.dp, bottom = 16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CharlesLiSimpleArithmeticTheme {
        Greeting()
    }
}