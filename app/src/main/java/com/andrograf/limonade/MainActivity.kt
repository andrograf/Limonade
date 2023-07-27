package com.andrograf.limonade

import android.icu.lang.UCharacter.VerticalOrientation
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andrograf.limonade.ui.theme.LimonadeTheme

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
    var imageResource = R.drawable.lemon_tree
    var imageDescription = R.string.lemon_tree
    var textDescription = R.string.select
    /*R.drawable.lemon_squeeze
    R.drawable.lemon_drink
    R.drawable.lemon_restart*/
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