package com.itsyasirali.restaurant.model.more

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itsyasirali.restaurant.model.More
import com.itsyasirali.restaurant.model.Order
import com.itsyasirali.restaurant.ui.AppTopBar
import com.itsyasirali.restaurant.ui.FilledButton
import com.itsyasirali.restaurant.ui.ui.theme.*

class MyOrder(override var icon: Int = 0, override var name: String = "") : More {

    val list = listOf<Order>(
        Order("Beef Burger", 1, 16.0),
        Order("Beef Burger", 1, 16.0),
        Order("Beef Burger", 1, 16.0),
        Order("Beef Burger", 1, 16.0),
    )

    override fun setObjectToSend(): More {
        return MyOrder()
    }

    @Composable
    override fun setContent() {
        Scaffold(
            topBar = {
                AppTopBar(title = "My Order")
            }
        ) {
            Column() {
                Row(modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)) {
                    CircleImage(image = com.itsyasirali.restaurant.R.drawable.restaurent_b)
                    Spacer(modifier = Modifier.width(17.dp))
                    Column() {
                        Text(text = "King Burgers", style = TextStyle(fontFamily = metropolisFontFamily, color = primaryFontColor, fontSize = 16.sp, fontWeight = FontWeight.Bold))
                        Spacer(modifier = Modifier.height(5.dp))
                        Row(){
                            Image(painter = painterResource(id = com.itsyasirali.restaurant.R.drawable.ic_star), contentDescription = "")
                            Text(text = "4.9", style = TextStyle(fontFamily = metropolisFontFamily, color = orange, fontSize = 12.sp))
                            Text(text = "(124 rating)", style = TextStyle(fontFamily = metropolisFontFamily, color = secondaryFontColor, fontSize = 12.sp))
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        Row(){
                            Text(text = "Burger     Western Food", style = TextStyle(fontFamily = metropolisFontFamily, color = secondaryFontColor, fontSize = 12.sp))
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        Row(){
                            Image(painter = painterResource(id = com.itsyasirali.restaurant.R.drawable.ic_location), contentDescription = "")
                            Text(text = "No 03, 4th Lane, Newyork", style = TextStyle(fontFamily = metropolisFontFamily, color = secondaryFontColor, fontSize = 12.sp))
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Box() {
                    LazyColumn {
                        itemsIndexed(list) { index, item ->
                            Box(modifier = Modifier.background(gray2)) {
                                Column() {
                                    Row(modifier = Modifier
                                        .padding(horizontal = 20.dp, vertical = 20.dp)
                                        .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                        Text(text = item.productName  + " x" +item.productCount, style = TextStyle(fontFamily = metropolisFontFamily, fontSize = 13.sp, color = primaryFontColor))
                                        Text(text = item.productPrice.toString() + "$", style = TextStyle(fontFamily = metropolisFontFamily, fontSize = 13.sp, color = primaryFontColor), fontWeight = FontWeight.Bold)
                                    }
                                    if(index != list.size - 1){
                                        Divider()
                                    }
                                }
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Sub Total", style = TextStyle(fontFamily = metropolisFontFamily, fontSize = 13.sp, color = primaryFontColor, fontWeight = FontWeight.Bold))
                    Text(text = "15$", style = TextStyle(fontFamily = metropolisFontFamily, fontSize = 13.sp, color = orange), fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(15.dp))
                Row(modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Sub Total", style = TextStyle(fontFamily = metropolisFontFamily, fontSize = 13.sp, color = primaryFontColor, fontWeight = FontWeight.Bold))
                    Text(text = "15$", style = TextStyle(fontFamily = metropolisFontFamily, fontSize = 13.sp, color = orange), fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(15.dp))
                Divider()
                Spacer(modifier = Modifier.height(20.dp))
                Row(modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Sub Total", style = TextStyle(fontFamily = metropolisFontFamily, fontSize = 13.sp, color = primaryFontColor, fontWeight = FontWeight.Bold))
                    Text(text = "15$", style = TextStyle(fontFamily = metropolisFontFamily, fontSize = 22.sp, color = orange), fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(20.dp))
                FilledButton(text = "Checkout", modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)) {
                    
                }
            }
        }
    }
}

@Composable
fun CircleImage(modifier: Modifier = Modifier, image: Int) {
    Image(
        painter = painterResource(id = image),
        contentDescription = "avatar",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(80.dp)
            .clip(shape = RoundedCornerShape(14.dp))
    )
}