package com.itsyasirali.restaurant.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itsyasirali.restaurant.ui.AppTextField
import com.itsyasirali.restaurant.ui.FilledButton
import com.itsyasirali.restaurant.ui.AppTopBar
import com.itsyasirali.restaurant.ui.ui.theme.*

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ProfileScreen(){
    val scrollState = rememberScrollState()
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    BahgatResturantTheme {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.verticalScroll(state = scrollState)) {
            AppTopBar(title = "Profile", backIcon = false)
            Spacer(modifier = Modifier.height(30.dp))
            ProfileImage(image = com.itsyasirali.restaurant.R.drawable.profile_picture)
            TextButtonWithImage(textButton = "edit Profile", image = com.itsyasirali.restaurant.R.drawable.ic_edit){}
            Text("Samer Mushtaha", style = TextStyle(fontFamily = metropolisFontFamily, color = primaryFontColor, fontSize = 16.sp, fontWeight = FontWeight.Bold))
            SignOut("SignOut"){}
            Spacer(modifier = Modifier.height(15.dp))
            AppTextField(value = fullName, onValueChange = { fullName = it }, hint = "Full name")
            Spacer(modifier = Modifier.height(15.dp))

            AppTextField(value = email, onValueChange = { email = it }, hint = "Email")
            Spacer(modifier = Modifier.height(15.dp))

            AppTextField(value = phone, onValueChange = { phone = it }, hint = "Mobile no")
            Spacer(modifier = Modifier.height(15.dp))

            AppTextField(value = address, onValueChange = { address = it }, hint = "Address")
            Spacer(modifier = Modifier.height(15.dp))

            AppTextField(value = password, onValueChange = { password = it }, hint = "Password")
            Spacer(modifier = Modifier.height(15.dp))

            AppTextField(value = confirmPassword, onValueChange = { confirmPassword = it }, hint = "Confirm password")
            Spacer(modifier = Modifier.height(20.dp))
            FilledButton(text = "Save", modifier = Modifier.padding(horizontal = 30.dp)) {}
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Composable
fun ProfileImage(modifier: Modifier = Modifier, image: Int) {
    Box(
        modifier = modifier
            .background(white, shape = RoundedCornerShape(200.dp)),
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )
    }
}

@Composable
fun TextButtonWithImage(textButton: String, image: Int, onClick: () -> Unit){
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painterResource(id = image), contentDescription = null)
        Spacer(modifier = Modifier.width(2.dp))
        TextButton(onClick = onClick) {
            Text(
                textButton,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = orange,
                    fontFamily = metropolisFontFamily,
                )
            )
        }
    }
}

@Composable
fun SignOut(textButton: String, onClick: () -> Unit){
    TextButton(onClick = onClick) {
        Text(
            textButton,
            style = TextStyle(
                fontSize = 14.sp,
                color = secondaryFontColor,
                fontFamily = metropolisFontFamily,
                fontWeight = FontWeight.Bold
            )
        )
    }
}