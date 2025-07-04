package com.example.navigationdrawer.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Feed
import androidx.compose.material.icons.automirrored.outlined.Feed
import androidx.compose.material.icons.automirrored.outlined.HelpOutline
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.automirrored.outlined.Message
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Brush
import androidx.compose.material.icons.filled.CloudSync
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.PersonAddAlt1
import androidx.compose.material.icons.filled.Photo
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SettingsVoice
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material.icons.filled.VideoCameraFront
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Output
import androidx.compose.material.icons.outlined.People
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material.icons.outlined.Report
import androidx.compose.material.icons.outlined.Save
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Security
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Update
import androidx.compose.material.icons.outlined.VolunteerActivism
import androidx.compose.ui.graphics.vector.ImageVector

val list1=listOf(
    "Home" to Icons.Default.Home,
    "AI Tools",
    "Video Creator" to Icons.Default.VideoCameraFront,
    "Text to Speech" to Icons.Default.TextFields,
    "Speech to Speech" to Icons.Default.Mic,
    "AI Creation",
    "Avatar Creator" to Icons.Default.Brush,
    "Voice Cloning" to Icons.Default.CloudSync,
    "Request Twin Pro" to Icons.Default.PersonAddAlt1,
    "Media",
    "Recording History" to Icons.Default.History,
    "Voice Libraries" to Icons.Default.SettingsVoice,
    "Visual Gallery" to Icons.Default.Photo,
    "For Developers",
    "API Keys" to Icons.Default.Key
)

data class Item(
    val title:String?=null,
    val list: List<Pair<String, ImageVector>>
)
val list2=listOf(
    Item(
        list=listOf("Home" to Icons.Default.Home)
    ),
    Item(
        title = "AI Tools",
        list = listOf(
            "Video Creator" to Icons.Default.VideoCameraFront,
            "Text to Speech" to Icons.Default.TextFields,
            "Speech to Speech" to Icons.Default.Mic
        )
    ),
    Item(
        title = "AI Creation",
        list = listOf(
            "Avatar Creator" to Icons.Default.Brush,
            "Voice Cloning" to Icons.Default.CloudSync,
            "Request Twin Pro" to Icons.Default.PersonAddAlt1
        )
    ),
    Item(
        title = "Media",
        list = listOf(
            "Recording History" to Icons.Default.History,
            "Voice Libraries" to Icons.Default.SettingsVoice,
            "Visual Gallery" to Icons.Default.Photo
        )
    ),
    Item(
        title = "For Developers",
        list = listOf(
            "API Keys" to Icons.Default.Key
        )
    )
)
data class DrawerItem(
    val label: String,
    val outlinedVector: ImageVector,
    val filledVector: ImageVector
)
val list3=listOf(
    DrawerItem(
        label = "Home",
        outlinedVector = Icons.Outlined.Home,
        filledVector = Icons.Filled.Home
    ),
    DrawerItem(
        label = "Orders",
        outlinedVector = Icons.AutoMirrored.Outlined.Feed,
        filledVector = Icons.AutoMirrored.Filled.Feed
    ),
    DrawerItem(
        label = "Cart",
        outlinedVector = Icons.Outlined.ShoppingCart,
        filledVector = Icons.Filled.ShoppingCart
    ),
    DrawerItem(
        label = "Search",
        outlinedVector = Icons.Outlined.Search,
        filledVector = Icons.Filled.Search
    ),
    DrawerItem(
        label = "Saved",
        outlinedVector = Icons.Outlined.Save,
        filledVector = Icons.Filled.Save
    )
)
data class ItemSample(
    val label: String,
    val vector: ImageVector,
    val badgeCount: Int?=null
)
data class ItemModel(
    val title: String,
    val listOfItems: List<ItemSample>
)
val list4=listOf(
    ItemModel(
        title = "Account",
        listOfItems = listOf(
            ItemSample(
                label = "Personal Settings",
                vector = Icons.Outlined.Person
            ),
            ItemSample(
                label = "Notifications",
                vector = Icons.Outlined.Notifications,
                badgeCount = 2
            ),
            ItemSample(
                label = "Language",
                vector = Icons.Outlined.Language,
            )
        )
    ),
    ItemModel(
        title = "Workspace",
        listOfItems = listOf(
            ItemSample(
                label = "Members",
                vector = Icons.Outlined.People
            ),
            ItemSample(
                label = "Team Settings",
                vector = Icons.Outlined.Settings
            ),
            ItemSample(
                label = "Security",
                vector = Icons.Outlined.Security
            ),
            ItemSample(
                label = "Upgrade",
                vector = Icons.Outlined.Update
            )
        )
    )
)
data class Item1(
    val label: String,
    val vector: ImageVector,
    val hasBadge: Boolean=false
)
val list5=listOf(
    Item1(
        label = "Profile",
        vector = Icons.Outlined.PersonOutline,
    ),
    Item1(
        label = "Messages",
        vector = Icons.AutoMirrored.Outlined.Message,
        hasBadge = true
    ),
    Item1(
        label = "Activity",
        vector = Icons.Outlined.VolunteerActivism,
        hasBadge = true
    ),
    Item1(
        label = "Lists",
        vector = Icons.AutoMirrored.Outlined.List
    ),
    Item1(
        label = "Reports",
        vector = Icons.Outlined.Report
    ),
    Item1(
        label = "Statistic",
        vector = Icons.Outlined.Language
    ),
    Item1(
        label = "Sign Out",
        vector = Icons.Outlined.Output
    ),
    Item1(
        label = "Tell a Friend",
        vector = Icons.Outlined.Share
    ),
    Item1(
        label = "Help and Feedback",
        vector = Icons.AutoMirrored.Outlined.HelpOutline
    )
)