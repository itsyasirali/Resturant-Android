package com.itsyasirali.restaurant.ui.authentication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itsyasirali.restaurant.ui.AppTextField
import com.itsyasirali.restaurant.ui.ButtonWithImage
import com.itsyasirali.restaurant.ui.FilledButton
import com.itsyasirali.restaurant.ui.Footer
import com.itsyasirali.restaurant.ui.ui.theme.*

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignInScreen(
    navigateToResetPasswordScreen: () -> Unit,
    navigateToSignUpScreen: () -> Unit,
    navigateToHomeScreen: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    BahgatResturantTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))
            Text(
                text = "Login",
                style = TextStyle(
                    fontSize = 30.sp,
                    fontFamily = metropolisFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = primaryFontColor
                )
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Add your details to login",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = secondaryFontColor,
                    fontWeight = FontWeight.Medium,
                    fontFamily = metropolisFontFamily
                )
            )
            Spacer(modifier = Modifier.height(36.dp))
            AppTextField(
                value = email,
                onValueChange = { email = it },
                hint = "Your Email",
                keyboardType = KeyboardType.Email
            )
            Spacer(modifier = Modifier.height(28.dp))
            AppTextField(
                value = password,
                onValueChange = { password = it },
                hint = "Password",
                keyboardType = KeyboardType.Password,
                action = ImeAction.Done
            )
            Spacer(modifier = Modifier.height(28.dp))

            FilledButton(
                text = "Sign In",
                modifier = Modifier.padding(horizontal = 34.dp)
            ) {

                //temporary
                navigateToHomeScreen()
            }
            Spacer(modifier = Modifier.height(24.dp))
            TextButton(onClick = {
                navigateToResetPasswordScreen()
            }) {
                Text(
                    "Forgot your password?",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = secondaryFontColor,
                        fontFamily = metropolisFontFamily,
                        fontWeight = FontWeight.Medium
                    )
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                modifier = Modifier.padding(top = 9.dp),
                text = "or login with",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = secondaryFontColor,
                    fontFamily = metropolisFontFamily,
                    fontWeight = FontWeight.Medium
                )
            )
            Spacer(modifier = Modifier.height(28.dp))
            ButtonWithImage(
                text = "Login with Facebook",
                image = com.itsyasirali.restaurant.R.drawable.ic_facebook,
                modifier = Modifier.padding(horizontal = 34.dp),
                color = blue
            ) {}
            Spacer(modifier = Modifier.height(28.dp))
            ButtonWithImage(
                text = "Login with Google",
                image = com.itsyasirali.restaurant.R.drawable.ic_google,
                modifier = Modifier.padding(horizontal = 34.dp),
                color = red
            ) {}
            Spacer(modifier = Modifier.height(28.dp))
            Footer(
                text = "Don't have an Account?",
                textButton = "Sign Up",
            ) {
                navigateToSignUpScreen()
            }
        }
    }
}






