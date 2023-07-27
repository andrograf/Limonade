package com.andrograf.limonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavBar(){
    Box{
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Lemonade Maker",
                    fontWeight = FontWeight.Bold
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.Yellow,
                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        )
    }

}

@Composable
fun InteractiveImageWithText(modifier: Modifier = Modifier){
    val starterValue = 1
    val maxSteps = 4
    var step by remember { mutableStateOf(starterValue) }
    var taps by remember { mutableStateOf(maxSteps - starterValue) }

    var imageResource = when(step){

        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }
    var imageDescription = when(step){

        2 -> R.string.lemon_content_description
        3 -> R.string.glass_content_description
        4 -> R.string.empty_glass_content_description
        else -> R.string.lemon_tree_content_description
    }
    var textDescription = when(step){

        2 -> R.string.squeeze
        3 -> R.string.drink
        4 -> R.string.restart
        else -> R.string.select
    }


    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                if(step < maxSteps) {

                    if(step == 2 && taps > 0){
                        taps--
                    }
                    else {
                        step++
                    }
                } else {
                    taps = (3..6).random()
                    step = starterValue
                }
            },
            shape = RoundedCornerShape(percent = 15),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(
                    red = 137,
                    green = 236,
                    blue = 171
                    )
            ),
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = imageDescription.toString(),
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(textDescription),
            color = Color.Black,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}


@Composable
fun Test(modifier: Modifier = Modifier){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "text1")
        Text(text = "text2")
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun LemonadeApp(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)
) {
    NavBar()
    InteractiveImageWithText(modifier)
}