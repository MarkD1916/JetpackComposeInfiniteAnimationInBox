package com.ill.jp.assignments.views.handgraded.components

import android.content.res.Resources
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.example.jetpackcomposewaveanimation.R



@Composable
fun BoxWithWaveInfiniteReverse(
    modifier: Modifier,
    backgroundColor: Color,
    content: @Composable BoxScope.() -> Unit
) {

    var lastValue by remember { mutableStateOf(Size.Zero) }

    val animationSettingsUpperWave = AnimationSettings(
        animationType = AnimationType.InfiniteViewReverse,
        easing = LinearEasing,
        duration = 5500,
        delay = 0,
        repeatMode = RepeatMode.Restart,
        targetViewPoint = TargetViewPoint.FromStartToEnd
    )

//    val animationSettingsMiddleWave = AnimationSettings(
//        animationType = AnimationType.FiniteView,
//        easing = LinearEasing,
//        duration = 4500,
//        delay = 0,
//        repeatMode = RepeatMode.Reverse,
//        targetViewPoint = TargetViewPoint.CustomTargetPoint(
//            start = pxToDp(lastValue.width),
//            end = (pxToDp(lastValue.width)) / 3
//        )
//    )
//
//    val animationSettingsMiddleWaveReverse = AnimationSettings(
//        animationType = AnimationType.FiniteView,
//        easing = LinearEasing,
//        duration = 4500,
//        delay = 0,
//        repeatMode = RepeatMode.Reverse,
//        targetViewPoint = TargetViewPoint.CustomTargetPoint(
//            start = -1*pxToDp(lastValue.width),
//            end = -1*(pxToDp(lastValue.width)) / 3
//        )
//    )
//
//    val animationSettingsLowWave = AnimationSettings(
//        animationType = AnimationType.InfiniteView,
//        easing = LinearEasing,
//        duration = 7500,
//        delay = 0,
//        repeatMode = RepeatMode.Restart,
//        targetViewPoint = TargetViewPoint.FromStartToEnd
//    )
//    val animationSettingsLowWaveReverse = AnimationSettings(
//        animationType = AnimationType.InfiniteViewReverse,
//        easing = LinearEasing,
//        duration = 10200,
//        delay = 0,
//        repeatMode = RepeatMode.Restart,
//        targetViewPoint = TargetViewPoint.FromStartToEnd
//    )

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .border(
            width = 2.dp,
            color = Color(0xFF071DE2),
            shape = RoundedCornerShape(12.dp)
        )
            .onGloballyPositioned { coordinates ->
                lastValue = coordinates.size.toSize()
            }
            .fillMaxSize()
            .heightIn(min = 185.dp, max = 185.dp)
            .background(color = backgroundColor)
    ) {
        WaveAnimation(
            modifier.align(Alignment.BottomCenter),
            lastValue,
            R.drawable.ic_wave2,
            yOffset = 30.dp,
            alpha = 1f,
            animationSettings = animationSettingsUpperWave
        )

//        WaveAnimation(
//            modifier.align(Alignment.BottomCenter),
//            lastValue,
//            R.drawable.ic_wave2,
//            yOffset = 85.dp,
//            alpha = 0.35f,
//            animationSettings = animationSettingsMiddleWave
//        )
//        WaveAnimation(
//            modifier.align(Alignment.BottomCenter),
//            lastValue,
//            R.drawable.ic_wave2,
//            yOffset = 85.dp,
//            alpha = 0.35f,
//            animationSettings = animationSettingsMiddleWaveReverse
//        )
//
//        WaveAnimation(
//            modifier.align(Alignment.BottomCenter),
//            lastValue,
//            R.drawable.ic_wave2,
//            yOffset = 85.dp,
//            alpha = 0.65f,
//            animationSettings = animationSettingsLowWave
//        )
//
//        WaveAnimation(
//            modifier.align(Alignment.BottomCenter),
//            lastValue,
//            R.drawable.ic_wave2,
//            yOffset = 90.dp,
//            alpha = 0.65f,
//            animationSettings = animationSettingsLowWaveReverse
//        )

        content()
    }
}