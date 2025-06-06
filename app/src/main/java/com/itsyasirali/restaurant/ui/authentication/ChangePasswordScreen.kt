package com.itsyasirali.restaurant.ui.authentication


import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itsyasirali.restaurant.ui.AppTextField
import com.itsyasirali.restaurant.ui.FilledButton
import com.itsyasirali.restaurant.ui.ui.theme.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ChangePasswordScreen() {
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    BahgatResturantTheme {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))
            Text(
                text = "New Password",
                style = TextStyle(
                    fontSize = 30.sp,
                    fontFamily = metropolisFontFamily,
                    color = primaryFontColor
                )
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                modifier = Modifier.padding(horizontal = 60.dp),
                text = "Please enter your email to receive a" +
                        "link to  create a new password via email",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = secondaryFontColor,
                    fontFamily = metropolisFontFamily,
                    textAlign = TextAlign.Center
                )
            )
            Spacer(modifier = Modifier.height(36.dp))
            AppTextField(
                value = password,
                onValueChange = { password = it },
                hint = "New Password",
                keyboardType = KeyboardType.Password
            )
            Spacer(modifier = Modifier.height(28.dp))
            AppTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                hint = "Confirm Password",
                keyboardType = KeyboardType.Password,
                action = ImeAction.Done
            )
            Spacer(modifier = Modifier.height(28.dp))
            FilledButton(text = "Next", modifier = Modifier.padding(horizontal = 34.dp)) {}
        }
    }
}