package com.ill.jp.assignments.views.handgraded.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

sealed class AnimationType {
    object InfiniteView : AnimationType()
    object InfiniteViewReverse : AnimationType()
    object FiniteView : AnimationType()
}

sealed class TargetViewPoint {
    object FromStartToEnd : TargetViewPoint()
    data class CustomTargetPoint(
        val start: Float,
        val end: Float
    ) : TargetViewPoint()
}

data class AnimationSettings(
    val animationType: AnimationType,
    val easing: Easing,
    val duration: Int,
    val delay: Int,
    val repeatMode: RepeatMode,
    val targetViewPoint: TargetViewPoint
)

@Composable
fun WaveAnimation(
    modifier: Modifier,
    boxSize: Size,
    resourceId: Int,
    yOffset: Dp,
    alpha: Float,
    animationSettings: AnimationSettings
) {

    val infiniteTransition = rememberInfiniteTransition()

    val initialValueInitImage = when (animationSettings.targetViewPoint) {
        is TargetViewPoint.FromStartToEnd -> {
            if (animationSettings.animationType is AnimationType.InfiniteView)
                0f else pxToDp(boxSize.width)
        }
        is TargetViewPoint.CustomTargetPoint -> {
            animationSettings.targetViewPoint.start
        }
    }

    val targetValueInitImage = when (animationSettings.targetViewPoint) {
        is TargetViewPoint.FromStartToEnd -> {
            if (animationSettings.animationType is AnimationType.InfiniteView)
                pxToDp(boxSize.width) else 0f
        }
        is TargetViewPoint.CustomTargetPoint -> {
            animationSettings.targetViewPoint.end
        }
    }

    val initialValuePreviouslyImage = when (animationSettings.targetViewPoint) {
        is TargetViewPoint.FromStartToEnd -> {
            if (animationSettings.animationType is AnimationType.InfiniteView)
                (-1 * pxToDp(boxSize.width)) else 0f
        }
        is TargetViewPoint.CustomTargetPoint -> {
            animationSettings.targetViewPoint.start
        }
    }

    val targetValuePreviouslyImage = when (animationSettings.targetViewPoint) {
        is TargetViewPoint.FromStartToEnd -> {
            if (animationSettings.animationType is AnimationType.InfiniteView)
                0f else (-1 * pxToDp(boxSize.width))
        }
        is TargetViewPoint.CustomTargetPoint -> {
            animationSettings.targetViewPoint.end
        }
    }

    val moveInitImage by infiniteTransition.animateFloat(
        initialValue = initialValueInitImage,
        targetValue = targetValueInitImage,
        animationSpec = infiniteRepeatable(
            animation = tween(
                animationSettings.duration,
                animationSettings.delay,
                easing = animationSettings.easing
            ),
            repeatMode = animationSettings.repeatMode
        )
    )
    val movePreviouslyImage by infiniteTransition.animateFloat(
        initialValue = initialValuePreviouslyImage,
        targetValue = targetValuePreviouslyImage,
        animationSpec = infiniteRepeatable(
            animation = tween(
                animationSettings.duration,
                animationSettings.delay,
                easing = animationSettings.easing
            ),
            repeatMode = animationSettings.repeatMode
        )
    )

    when (animationSettings.animationType) {
        is AnimationType.InfiniteView -> {
            Image(
                modifier = modifier
                    .alpha(alpha)
                    .clipToBounds()
                    .offset(x = moveInitImage.dp, y = yOffset)
                    .fillMaxWidth(),
                painter = painterResource(id = resourceId),
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
            Image(
                modifier = modifier
                    .alpha(alpha)
                    .clipToBounds()
                    .offset(x = movePreviouslyImage.dp, y = yOffset)
                    .fillMaxWidth(),
                painter = painterResource(id = resourceId),
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
        }
        is AnimationType.InfiniteViewReverse -> {
            Image(
                modifier = modifier
                    .alpha(alpha)
                    .clipToBounds()
                    .offset(x = moveInitImage.dp, y = yOffset)
                    .fillMaxWidth(),
                painter = painterResource(id = resourceId),
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
            Image(
                modifier = modifier
                    .alpha(alpha)
                    .clipToBounds()
                    .offset(x = movePreviouslyImage.dp, y = yOffset)
                    .fillMaxWidth(),
                painter = painterResource(id = resourceId),
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
        }
        is AnimationType.FiniteView -> {
            Image(
                modifier = modifier
                    .alpha(alpha)
                    .clipToBounds()
                    .offset(x = moveInitImage.dp, y = yOffset)
                    .fillMaxSize(),
                painter = painterResource(id = resourceId),
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
        }
    }

}