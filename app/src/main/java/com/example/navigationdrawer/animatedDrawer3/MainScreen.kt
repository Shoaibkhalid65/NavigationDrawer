package com.example.navigationdrawer.animatedDrawer3

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.util.lerp
import androidx.compose.ui.zIndex
import com.example.navigationdrawer.ui.theme.DrawerContainerColor1
import kotlinx.coroutines.launch
import kotlin.math.abs

@Composable
fun MainScreen() {
    // Responsive drawer width based on screen size
    val configuration = LocalConfiguration.current
    val drawerWidth = when {
        configuration.screenWidthDp < 600 -> 280.dp  // Compact screens
        configuration.screenWidthDp < 840 -> 320.dp  // Medium screens
        else -> 360.dp                               // Large screens
    }

    val drawerWidthPx = with(LocalDensity.current) { drawerWidth.toPx() }
    val scope = rememberCoroutineScope()
    val offsetX = remember { Animatable(0f) }

    // Use derivedStateOf for better performance
    val isDrawerOpened by remember {
        derivedStateOf { offsetX.value > drawerWidthPx / 2 }
    }

    val drawerState by remember {
        derivedStateOf {
            if (isDrawerOpened) CustomDrawerState.Opened else CustomDrawerState.Closed
        }
    }

    // Improved interpolation with bounds checking
    val fraction = (offsetX.value / drawerWidthPx).coerceIn(0f, 1f)

    // Responsive scale based on screen size
    val minScale = when {
        configuration.screenWidthDp < 600 -> 0.85f   // More scaling on small screens
        configuration.screenWidthDp < 840 -> 0.90f   // Medium scaling
        else -> 0.93f                                // Less scaling on large screens
    }

    val scale = lerp(start = 1f, stop = minScale, fraction = fraction)
    val cornerRadius = lerp(start = 0.dp, stop = 24.dp, fraction = fraction)

    // Animation function with improved performance
    fun animateToState(targetState: CustomDrawerState) {
        scope.launch {
            val targetValue = if (targetState == CustomDrawerState.Opened) drawerWidthPx else 0f
            offsetX.animateTo(
                targetValue = targetValue,
                animationSpec = tween(durationMillis = 300)
            )
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = DrawerContainerColor1)
    ) {
        // Drawer layer
        CustomDrawer()

        // Main content layer with responsive design
        MainContent(
            modifier = Modifier
                .fillMaxSize()
                .zIndex(1f) // Ensure proper layering
                .offset { IntOffset(x = offsetX.value.toInt(), y = 0) }
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale,
                    clip = true,
                    shape = RoundedCornerShape(cornerRadius),
                    shadowElevation = if (fraction > 0f) {
                        // Responsive shadow based on screen density
                        when {
                            configuration.densityDpi >= 480 -> 20f  // XXXHDPI
                            configuration.densityDpi >= 320 -> 16f  // XXHDPI
                            configuration.densityDpi >= 240 -> 12f  // XHDPI
                            else -> 8f                              // HDPI and below
                        }
                    } else 0f
                )
                // Enhanced drag handling for physical devices
                .pointerInput(drawerWidthPx) {
                    detectDragGestures(
                        onDragStart = { /* Optional: Handle drag start */ },
                        onDragEnd = {
                            scope.launch {
                                val targetValue = if (isDrawerOpened) drawerWidthPx else 0f
                                offsetX.animateTo(
                                    targetValue = targetValue,
                                    animationSpec = tween(durationMillis = 300)
                                )
                            }
                        }
                    ) { _, dragAmount ->
                        scope.launch {
                            val newOffsetX = (offsetX.value + dragAmount.x).coerceIn(
                                minimumValue = 0f,
                                maximumValue = drawerWidthPx
                            )
                            offsetX.snapTo(newOffsetX)
                        }
                    }
                }
                // Improved draggable with velocity handling
                .draggable(
                    state = rememberDraggableState { delta ->
                        scope.launch {
                            val newOffsetX = (delta + offsetX.value).coerceIn(
                                minimumValue = 0f,
                                maximumValue = drawerWidthPx
                            )
                            offsetX.snapTo(newOffsetX)
                        }
                    },
                    orientation = Orientation.Horizontal,
                    onDragStopped = { velocity ->
                        scope.launch {
                            // Responsive velocity threshold based on screen density
                            val velocityThreshold = when {
                                configuration.densityDpi >= 480 -> 800f   // Higher threshold for high DPI
                                configuration.densityDpi >= 320 -> 600f   // Medium threshold
                                else -> 400f                              // Lower threshold for low DPI
                            }

                            val targetValue = when {
                                abs(velocity) > velocityThreshold -> {
                                    if (velocity > 0) drawerWidthPx else 0f
                                }
                                else -> {
                                    if (isDrawerOpened) drawerWidthPx else 0f
                                }
                            }

                            offsetX.animateTo(
                                targetValue = targetValue,
                                animationSpec = tween(durationMillis = 300)
                            )
                        }
                    }
                ),
            customDrawerState = drawerState,
            onNavigationIconClick = { newDrawerState ->
                animateToState(newDrawerState)
            }
        )
    }
}