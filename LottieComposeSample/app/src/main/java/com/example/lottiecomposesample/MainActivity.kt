package com.example.lottiecomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.example.lottiecomposesample.ui.theme.LottieComposeSampleTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LottieComposeSampleTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = {
                        SmallTopAppBar(
                            title = {
                                Text(text = "LottieComposeSample")
                            },
                        )
                    },
                    content = { Greeting() }
                )
            }
        }
    }
}

@Composable
private fun Greeting() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation_party_parrot))
    var isPlaying by remember { mutableStateOf(false) }
    var restartOnPlay by remember { mutableStateOf(false) }
    val progress by animateLottieCompositionAsState(
        composition = composition,
        speed = 0.2f,
        isPlaying = isPlaying,
        restartOnPlay = restartOnPlay,
        // cancellationBehavior = LottieCancellationBehavior.Immediately, // default
        iterations = LottieConstants.IterateForever,
        // clipSpec = LottieClipSpec.Progress(0f, 1f), // default
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        LottieAnimation(
            composition,
            progress,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            OutlinedButton(onClick = {
                isPlaying = true
                restartOnPlay = false
            }, modifier = Modifier.weight(1f)) {
                Text(text = "resume")
            }
            OutlinedButton(onClick = {
                isPlaying = false
                restartOnPlay = false
            }, modifier = Modifier.weight(1f)) {
                Text(text = "pause")
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            OutlinedButton(onClick = {
                isPlaying = true
                restartOnPlay = true
            }, modifier = Modifier.weight(1f)) {
                Text(text = "play")
            }
            OutlinedButton(onClick = {
                isPlaying = false
                restartOnPlay = true
            }, modifier = Modifier.weight(1f)) {
                Text(text = "cancel")
            }
        }
    }
}