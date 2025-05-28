package com.itsyasirali.restaurant.model.more

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itsyasirali.restaurant.model.More
import com.itsyasirali.restaurant.ui.AppTopBar
import com.itsyasirali.restaurant.ui.ui.theme.*
import java.awt.font.NumericShaper.Range

class About(override var icon: Int = 0, override var name: String = "") : More {

    override fun setObjectToSend(): More {
        return About()
    }

    @Composable
    override fun setContent() {
        val list = listOf(
            "Your orders has been picked up Your orders has been picked up Your orders has been picked upYour orders has been picked up",
            "Your orders has been picked up Your orders has been picked up Your orders has been picked upYour orders has been picked up",
            "Your orders has been picked up Your orders has been picked up Your orders has been picked upYour orders has been picked up",
            "Your orders has been picked up Your orders has been picked up Your orders has been picked upYour orders has been picked up",
        )
        BahgatResturantTheme() {
            Column {
                AppTopBar(title = "About Us")
                Spacer(modifier = Modifier.height(15.dp))
                LazyColumn{
                    items(list) { item ->
                        Column() {
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp, vertical = 20.dp)) {
                                Icon(painter = painterResource(id = com.itsyasirali.restaurant.R.drawable.ic_location), contentDescription = "", tint = orange)
                                Spacer(modifier = Modifier.width(30.dp))
                                Text(item, style = TextStyle(fontSize = 15.sp, fontFamily = metropolisFontFamily, color = primaryFontColor))
                            }
                        }
                    }
                }
            }
        }
    }
}