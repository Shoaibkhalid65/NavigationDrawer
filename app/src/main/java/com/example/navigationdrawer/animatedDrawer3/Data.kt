package com.example.navigationdrawer.animatedDrawer3

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Dashboard
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.navigationdrawer.R
import com.example.navigationdrawer.ui.theme.CodeColor1
import com.example.navigationdrawer.ui.theme.CodeColor2
import com.example.navigationdrawer.ui.theme.CodeColor3
import com.example.navigationdrawer.ui.theme.CodeColor4
import com.example.navigationdrawer.ui.theme.DocumentationColor1
import com.example.navigationdrawer.ui.theme.DocumentationColor2
import com.example.navigationdrawer.ui.theme.GithubColor1
import com.example.navigationdrawer.ui.theme.GithubColor2

enum class BottomBarItem(
    val label: String,
    val outlinedVector: ImageVector,
    val filledVector: ImageVector
){
    HOME(
        label = "Home",
        outlinedVector = Icons.Outlined.Home,
        filledVector = Icons.Default.Home
    ),
    PROJECTS(
        label = "Projects",
        outlinedVector = Icons.Outlined.Dashboard,
        filledVector = Icons.Default.Dashboard
    ),
    SETTINGS(
        label = "Settings",
        outlinedVector = Icons.Outlined.Settings,
        filledVector = Icons.Default.Settings
    )
}
enum class BoxItem(
    @DrawableRes
    val iconId: Int,
    val gradientColors: List<Color>,
    val title:String,
    val subtitle: String
){
    CODE(
        iconId = R.drawable.code,
        gradientColors = listOf(
            CodeColor1,
            CodeColor2,
            CodeColor3,
            CodeColor4
        ),
        title = "Get Started",
        subtitle = "Deploy your first project"
    ),
    DOCUMENT(
        iconId = R.drawable.book,
        gradientColors = listOf(
            DocumentationColor2,
            DocumentationColor1
        ),
        title = "Documentation",
        subtitle = "Learn more about features"
    ),
    GITHUB(
        iconId = R.drawable.github_logo,
        gradientColors = listOf(
            GithubColor1,
            GithubColor2
        ),
        title = "GitHub",
        subtitle = "Connect your repository"
    )
}

data class ItemSample(
    val label:String,
    val iconId: Int,
    val hasBadgeIcon:Boolean=false
)
enum class DrawerItem(
    val title: String,
    val items: List<ItemSample>
){
    MAIN(
        title= "MAIN",
        items= listOf(
            ItemSample(
                label = "Dashboard",
                iconId = R.drawable.home_02_svgrepo_com
            ),
            ItemSample(
                label = "Audience",
                iconId = R.drawable.person_svgrepo_com,
                hasBadgeIcon = true
            ),
            ItemSample(
                label = "Posts",
                iconId = R.drawable.document_ui_svgrepo_com
            ),
            ItemSample(
                label = "Schedules",
                iconId = R.drawable.calendar_svgrepo_com
            ),
            ItemSample(
                label = "Income",
                iconId = R.drawable.chart_bars_svgrepo_com,
                hasBadgeIcon = true
            )
        )
    ),
    SETTINGS(
        title = "SETTINGS",
        items = listOf(
            ItemSample(
                label = "Settings",
                iconId = R.drawable.settings_svgrepo_com,
                hasBadgeIcon = true
            ),
            ItemSample(
                label = "Help",
                iconId = R.drawable.help_svgrepo_com
            ),
            ItemSample(
                label = "Logout Account",
                iconId = R.drawable.log_out_1_svgrepo_com
            )
        )
    )
}