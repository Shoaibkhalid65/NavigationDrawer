package com.example.navigationdrawer.animatedDrawer3

enum class CustomDrawerState {
    Opened,
    Closed
}
fun CustomDrawerState.isOpened(): Boolean{
    return this.name=="Opened"
}
fun CustomDrawerState.opposite(): CustomDrawerState{
    return if(!isOpened()) CustomDrawerState.Opened
    else CustomDrawerState.Closed
}