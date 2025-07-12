package com.example.navigationdrawer.animatedDrawer3

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ripple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigationdrawer.R
import com.example.navigationdrawer.ui.theme.BottomBarIconColor
import com.example.navigationdrawer.ui.theme.CardBorderColor
import com.example.navigationdrawer.ui.theme.CardColor
import com.example.navigationdrawer.ui.theme.CardTextColor
import com.example.navigationdrawer.ui.theme.CodeColor1
import com.example.navigationdrawer.ui.theme.CodeColor2
import com.example.navigationdrawer.ui.theme.ScreenBackground
import com.example.navigationdrawer.ui.theme.TextColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(
    modifier: Modifier,
    customDrawerState: CustomDrawerState,
    onNavigationIconClick:(CustomDrawerState)-> Unit
){
    Scaffold (
        modifier = modifier
            .systemBarsPadding()
            .then(
                if (customDrawerState.isOpened()) {
                    Modifier.clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        onNavigationIconClick(CustomDrawerState.Closed)
                    }
                } else Modifier
            ),
        containerColor = ScreenBackground,
        topBar = {
            CustomTopBar(
                customDrawerState = customDrawerState
            ){
                onNavigationIconClick(it)
            }
        },
        bottomBar = {
            CustomBottomBar()
        }
    ){innerPadding->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(R.drawable.triangle),
                        contentDescription = "Triangle icon",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(top = 18.dp)
                            .size(50.dp)
                    )
                    Text(
                        text = "Hello World",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 20.dp),
                        fontSize = 40.sp
                    )
                    Text(
                        text = "Welcome to my new project",
                        color = TextColor,
                        modifier = Modifier.padding(top = 15.dp),
                        fontSize = 17.sp
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                }
            }

            items(BoxItem.entries) { item ->
                CustomBox(
                    iconId = item.iconId,
                    gradientColors = item.gradientColors,
                    title = item.title,
                    subtitle = item.subtitle
                )
            }
        }
    }
}

@Preview
@Composable
fun MainContentPreview(){
    MainContent(
        modifier = Modifier,
        customDrawerState = CustomDrawerState.Closed,
    ) { }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(
    customDrawerState: CustomDrawerState,
    onNavigationIconClick:(CustomDrawerState)-> Unit
){
    TopAppBar(
        title = {},
        navigationIcon = {
            IconButton(
                onClick = {
                    onNavigationIconClick(customDrawerState.opposite())
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = Color.White
                )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(R.drawable.notification_10_svgrepo_com),
                    contentDescription = "Notifications",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }

            Box(
                modifier = Modifier
                    .padding(end = 15.dp)
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                CodeColor1,
                                CodeColor2
                            )
                        )
                    )
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(bounded = false)
                    ) {
                        // Handle profile click
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "AV",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
    )
}

@Composable
fun CustomBottomBar(){
    var selectedIndex by remember { mutableIntStateOf(0) }
    NavigationBar(
        containerColor = Color.Transparent,
        tonalElevation = 16.dp,
        modifier = Modifier.border(
            width = 2.dp,
            color = CardBorderColor,
            shape = RoundedCornerShape(12.dp)
        )
    ) {
        BottomBarItem.entries.forEachIndexed { index, item ->
            val isSelected = selectedIndex == index
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    selectedIndex = index
                },
                icon = {
                    Icon(
                        imageVector = if(isSelected) item.filledVector else item.outlinedVector,
                        contentDescription = item.label
                    )
                },
                label = {
                    Text(
                        text = item.label
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = BottomBarIconColor,
                    selectedTextColor = Color.White,
                    unselectedTextColor = BottomBarIconColor,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}

@Composable
fun CustomBox(
    @DrawableRes
    iconId: Int,
    gradientColors: List<Color>,
    title: String,
    subtitle: String
){
    Box(
        modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 20.dp)
            .fillMaxWidth()
            .height(120.dp)
            .background(
                color = CardColor,
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                width = 2.dp,
                color = CardBorderColor,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple()
            ) {
                // Handle box click
            }
    ){
        Row (
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card (
                    modifier = Modifier
                        .size(50.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = gradientColors,
                            ),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    )
                ){
                    Icon(
                        painter = painterResource(iconId),
                        contentDescription = title,
                        tint = Color.White,
                        modifier = Modifier
                            .padding(10.dp)
                            .size(30.dp)
                    )
                }
                Column (
                    modifier = Modifier.padding(start = 20.dp)
                ){
                    Text(
                        text = title,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Text(
                        text = subtitle,
                        color = CardTextColor,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                }
            }

            Icon(
                imageVector = Icons.AutoMirrored.Default.ArrowForward,
                contentDescription = "Navigate",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}