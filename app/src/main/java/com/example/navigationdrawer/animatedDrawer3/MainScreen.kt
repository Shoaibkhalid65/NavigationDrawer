package com.example.navigationdrawer.animatedDrawer3


import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.util.lerp
import com.example.navigationdrawer.ui.theme.DrawerContainerColor1
import com.example.navigationdrawer.ui.theme.TopBarActionColor1
import kotlinx.coroutines.launch

@Composable
fun MainScreen(){
    val drawerWidth=250.dp
    val drawerWidthPx=with(LocalDensity.current){drawerWidth.toPx()}

    val scope = rememberCoroutineScope()
    val offsetX= remember { Animatable(0f) }

    val isDrawerOpened=offsetX.value > drawerWidthPx/2
    val drawerState = if(isDrawerOpened) CustomDrawerState.Opened else CustomDrawerState.Closed

    val scale= lerp(start = 1f, stop = 0.9f, fraction = offsetX.value/drawerWidthPx)
    val cornerRadius =lerp(start = 0.dp , stop = 24.dp, fraction = offsetX.value/drawerWidthPx)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color= DrawerContainerColor1),
    ){
        CustomDrawer()
        MainContent(
            modifier = Modifier
                .offset{ IntOffset(x=offsetX.value.toInt(),y=0) }
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale,
                    clip = true,
                    shape = RoundedCornerShape(cornerRadius),
                    shadowElevation = 16f
                )
                .draggable(
                    state = rememberDraggableState { delta->
                        scope.launch {
                            val newOffsetX=(delta+offsetX.value).coerceIn(minimumValue = 0f, maximumValue = drawerWidthPx)
                            offsetX.snapTo(newOffsetX)
                        }
                    },
                    orientation = Orientation.Horizontal,
                    onDragStopped ={
                        scope.launch {
                            if(isDrawerOpened){
                                offsetX.animateTo(
                                    targetValue = drawerWidthPx,
                                    animationSpec = tween(300)
                                )
                            }else{
                                offsetX.animateTo(
                                    targetValue = 0f,
                                    animationSpec = tween(300)
                                )
                            }
                        }
                    }
                )
            ,
            customDrawerState = drawerState
        )
        { newDrawerState->
            scope.launch {
                offsetX.animateTo(
                    targetValue = if(newDrawerState== CustomDrawerState.Opened) drawerWidthPx else 0f,
                    animationSpec = tween(300)
                )
            }

        }
    }
}