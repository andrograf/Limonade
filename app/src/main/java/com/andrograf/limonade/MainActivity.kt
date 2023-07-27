package com.andrograf.limonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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


@Composable
fun InteractiveImageWithText(modifier: Modifier = Modifier){
    var step by remember { mutableStateOf(1) }
    var imageResource = when(step){
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    var imageDescription = when(step){
        1 -> R.string.lemon_tree_content_description
        2 -> R.string.lemon_content_description
        3 -> R.string.glass_content_description
        else -> R.string.empty_glass_content_description
    }
    var textDescription = when(step){
        1 -> R.string.select
        2 -> R.string.squeeze
        3 -> R.string.drink
        else -> R.string.restart
    }

    Text(
        text = "Lemonade",
        //modifier = Modifier.background(Color.Yellow),
        textAlign = TextAlign.Center
    )
    Button(
        onClick = { /*TODO*/ },
        modifier =  modifier.width(imageResource.dp)) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
          //  verticalArrangement = Arrangement.Center
        ){

            Image(painter = painterResource(id = imageResource), contentDescription = imageDescription.toString())
            Spacer(modifier = modifier.height(16.dp))
            Text(text = stringResource(textDescription))

        }
    }


}

@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    InteractiveImageWithText()
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun LemonadePreview() {
    LemonadeApp(
        modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}