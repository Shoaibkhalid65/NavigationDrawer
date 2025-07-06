package com.example.navigationdrawer.animatedDrawer2

import android.graphics.drawable.GradientDrawable
import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.util.lerp
import com.example.navigationdrawer.ui.theme.DrawerContainerColor1
import kotlinx.coroutines.launch


@Composable
fun MainScreen2(){
    var drawerState by remember { mutableStateOf(CustomDrawerState1.Closed) }
    val isDrawerOpened=drawerState.isOpened()
    val animatedOffset by animateDpAsState(
        targetValue = if(isDrawerOpened)260.dp else 0.dp
    )
    val animatedScale by animateFloatAsState(
        targetValue = if(isDrawerOpened) 0.9f else 1f
    )
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ){
        CustomDrawer1{
            drawerState= CustomDrawerState1.Closed
        }
        MainContent1(
            modifier = Modifier
                .scale(scale = animatedScale)
                .offset(x=animatedOffset),
            customDrawerState1 = drawerState
        ) { drawerState1->
            drawerState=drawerState1
        }
    }
}
@Composable
fun MainScreen1() {
    val drawerWidth = 250.dp
    val drawerWidthPx = with(LocalDensity.current) {drawerWidth.toPx() }

    val scope = rememberCoroutineScope()
    val offsetX = remember { Animatable(0f) }

    val isDrawerOpened = offsetX.value > drawerWidthPx / 2
    val drawerState = if (isDrawerOpened) CustomDrawerState1.Opened else CustomDrawerState1.Closed

    val scale = lerp(start = 1f, stop = 0.9f, fraction = offsetX.value / drawerWidthPx)
    val cornerRadius = lerp(start = 0.dp, stop = 24.dp, fraction = offsetX.value / drawerWidthPx)


    Box(
        Modifier
            .fillMaxSize()
            .background(DrawerContainerColor1)
    ) {
        CustomDrawer1 {
            scope.launch {
                offsetX.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(durationMillis = 700, easing = FastOutSlowInEasing)
                )
            }
        }

        MainContent1(
            modifier = Modifier
                .offset { IntOffset(offsetX.value.toInt(), 0) }
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    shadowElevation = 16f
                    shape = RoundedCornerShape(cornerRadius)
                    clip = true
                }
                .draggable(
                    orientation = Orientation.Horizontal,
                    state = rememberDraggableState { delta ->
                        scope.launch {
                            val newOffset = (offsetX.value + delta).coerceIn(0f, drawerWidthPx)
                            offsetX.snapTo(newOffset)
                        }
                    },
                    onDragStopped = {
                        scope.launch {
                            if (offsetX.value > drawerWidthPx / 2) {
                                offsetX.animateTo(drawerWidthPx, tween(300))
                            } else {
                                offsetX.animateTo(0f, tween(300))
                            }
                        }
                    }
                ),
            customDrawerState1 = drawerState
        ) { newDrawerState ->
            scope.launch {
                val target = if (newDrawerState == CustomDrawerState1.Opened) drawerWidthPx else 0f
                offsetX.animateTo(target, tween(300))
            }
        }
    }
}



















@Composable
fun MainScreen3(){
    val drawerWidth=250.dp
    val drawerWithPx=with(LocalDensity.current){drawerWidth.toPx()}

    val scope=rememberCoroutineScope()
    var offsetX =remember { Animatable(0f) }

    val isDrawerOpened= offsetX.value > drawerWithPx/2
    val drawerState = if(isDrawerOpened) CustomDrawerState1.Opened else CustomDrawerState1.Closed

    val scale=lerp(start = 1f, stop = 0.9f, fraction = offsetX.value/drawerWithPx)
    val cornerRadius=lerp(start = 0.dp, stop = 24.dp, fraction = offsetX.value/drawerWithPx)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)

    ){
        CustomDrawer1 {
            scope.launch {
                offsetX.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing)
                )
            }
        }
        MainContent1(
            modifier = Modifier
                .offset{IntOffset(x=offsetX.value.toInt(),y=0)}
                .graphicsLayer(
                    scaleX=scale,
                    scaleY = scale,
                    shadowElevation = 16f,
                    shape = RoundedCornerShape(cornerRadius),
                    clip = true
                )
                .draggable(
                    orientation = Orientation.Horizontal,
                    state = rememberDraggableState { delta->
                        scope.launch {
                            val newOffset = (offsetX.value + delta).coerceIn(0f, drawerWithPx)
                            offsetX.snapTo(newOffset)
                        }
                    },
                    onDragStopped = {
                        scope.launch {
                            if(isDrawerOpened){
                                offsetX.animateTo(targetValue =drawerWithPx, animationSpec = tween(300) )
                            }else{
                                offsetX.animateTo(targetValue = 0f, animationSpec = tween(300))
                            }
                        }
                    }
                ),
            customDrawerState1 = drawerState
        ) {newDrawerState->
            scope.launch {
                offsetX.animateTo(targetValue = if(newDrawerState== CustomDrawerState1.Closed) 0f else drawerWithPx)
            }
        }

    }
}

