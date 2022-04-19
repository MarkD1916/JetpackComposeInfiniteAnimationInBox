package com.example.jetpackcomposewaveanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material.Text

import androidx.compose.ui.unit.dp
import com.example.jetpackcomposewaveanimation.ui.theme.JetpackComposeWaveAnimationTheme
import com.ill.jp.assignments.views.handgraded.components.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeWaveAnimationTheme {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 10.dp)
                ) {
                    item {
                        Box(modifier = Modifier.fillMaxSize()) {
                            BoxWithWaveInfinite(
                                modifier = Modifier
                                    .heightIn(max = 180.dp)
                                    .fillMaxSize(),
                                backgroundColor = Color(0xFFFFFFFF)
                            ) {
                                Text(modifier= Modifier.align(Alignment.TopCenter),
                                    text = "Infinite View")
                            }
                        }
                    }

                    item {
                        Box(modifier = Modifier.fillMaxSize()) {

                            BoxWithWaveInfiniteReverse(
                                modifier = Modifier
                                    .heightIn(max = 180.dp)
                                    .fillMaxSize(),
                                backgroundColor = Color(0xFFFFFFFF)
                            ) {
                                Text(modifier= Modifier.align(Alignment.TopCenter),
                                    text = "Infinite View Reverse")
                            }
                        }
                    }

                    item {
                        Box(modifier = Modifier.fillMaxSize()) {
                            BoxWithWaveInfiniteReverseAnimation(
                                modifier = Modifier
                                    .heightIn(max = 180.dp)
                                    .fillMaxSize(),
                                backgroundColor = Color(0xFFFFFFFF)
                            ) {
                                Text(modifier= Modifier.align(Alignment.TopCenter),
                                    text = "Infinite View Reverse Animation Revers")
                            }
                        }
                    }
                    item {
                        Box(modifier = Modifier.fillMaxSize()) {
                            BoxWithWaveFiniteReverse(
                                modifier = Modifier
                                    .heightIn(max = 180.dp)
                                    .fillMaxSize(),
                                backgroundColor = Color(0xFFFFFFFF)
                            ) {
                                Text(modifier= Modifier.align(Alignment.TopCenter),
                                    text = "Finite View Reverse")
                            }
                        }
                    }
                    item {
                        Box(modifier = Modifier.fillMaxSize()) {
                            BoxWithWaveAllAndAlpha(
                                modifier = Modifier
                                    .heightIn(max = 180.dp)
                                    .fillMaxSize(),
                                backgroundColor = Color(0xFFFFFFFF)
                            ) {
                                Text(modifier= Modifier.align(Alignment.TopCenter),
                                    text = "Some setup with alpha")
                            }
                        }
                    }
                }
            }
        }
    }
}
