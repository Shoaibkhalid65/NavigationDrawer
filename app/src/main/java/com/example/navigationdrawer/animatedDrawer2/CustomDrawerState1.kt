package com.example.navigationdrawer.animatedDrawer2

enum class CustomDrawerState1 {
    Opened,
    Closed
}
fun CustomDrawerState1.isOpened(): Boolean{
    return this.name=="Opened"
}
fun CustomDrawerState1.opposite(): CustomDrawerState1{
    return if(this.isOpened()) CustomDrawerState1.Closed
    else CustomDrawerState1.Opened
}