package com.itsyasirali.restaurant.ui.home

import androidx.compose.runtime.Composable
import com.itsyasirali.restaurant.ui.AppTopBar
import com.itsyasirali.restaurant.ui.ui.theme.BahgatResturantTheme

@Composable
fun ChangeAddressScreen(){
    BahgatResturantTheme() {
        AppTopBar(title = "Change Address", backIcon = true)
    }
}