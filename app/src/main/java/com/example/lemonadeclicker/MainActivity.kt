package com.example.lemonadeclicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                    MyLemonadeApp()
            }
        }
    }
}

@Composable
private fun DoLemonade(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
){
    var currentImage by remember {
        mutableStateOf(1)
    }

    var random by remember {
        mutableStateOf(0)
    }

    when(currentImage){
        1 ->
            Column(
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {
                    random = (2..4).random()
                    currentImage = 2}) {
                    Image(
                        painter = painterResource(R.drawable.lemon_tree),
                        contentDescription = stringResource(R.string.tree)
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                Text(text = stringResource(R.string.tap_tree))
            }

        2 ->
            Column(
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {
                    when(random) {
                        0 -> currentImage = 3
                        else -> {random--
                        currentImage = 2}
                    }
                }) {
                    Image(
                        painter = painterResource(R.drawable.lemon_squeeze),
                        contentDescription = stringResource(R.string.lemon)
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                Text(text = stringResource(R.string.tap_lemon))
            }
        3 ->
            Column(
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = { currentImage = 4}) {
                    Image(
                        painter = painterResource(R.drawable.lemon_drink),
                        contentDescription = stringResource(R.string.glass_of_lemonade)
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                Text(text = stringResource(R.string.tap_lemonade))
            }
        else ->
            Column(
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {currentImage = 1}) {
                    Image(
                        painter = painterResource(R.drawable.lemon_restart),
                        contentDescription = stringResource(R.string.empty_glass)
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                Text(text = stringResource(R.string.tap_glass))
            }
    }
}

@Preview(showBackground = true)
@Composable
private fun MyLemonadeApp(){
    DoLemonade()
}