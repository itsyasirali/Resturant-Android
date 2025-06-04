package com.itsyasirali.restaurant.ui.authentication

//import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.itsyasirali.restaurant.ui.AppTextField
import com.itsyasirali.restaurant.ui.FilledButton
import com.itsyasirali.restaurant.ui.Footer
import com.itsyasirali.restaurant.ui.ui.theme.BahgatResturantTheme
import com.itsyasirali.restaurant.ui.ui.theme.metropolisFontFamily
import com.itsyasirali.restaurant.ui.ui.theme.primaryFontColor
import com.itsyasirali.restaurant.ui.ui.theme.secondaryFontColor


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignUpScreen(navigateToSignInScreen: () -> Unit) {

    val viewModel: UserViewModel = viewModel()

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    /*val isSuccess = viewModel.isSignUpSuccessful.observeAsState()
    val error = viewModel.errorMessage.observeAsState()*/

    /*LaunchedEffect(isSuccess.value) {
        if (isSuccess.value == true) {
            navigateToSignInScreen()
        }
    }
*/
    BahgatResturantTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))
            Text(
                text = "Sign Up",
                style = TextStyle(
                    fontSize = 30.sp,
                    fontFamily = metropolisFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = primaryFontColor
                )
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Add your details to sign up",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = metropolisFontFamily,
                    fontWeight = FontWeight.Medium,
                    color = secondaryFontColor,
                )
            )

            Spacer(modifier = Modifier.height(36.dp))

            AppTextField(hint = "Name", value = name, onValueChange = { name = it })
            Spacer(modifier = Modifier.height(28.dp))

            AppTextField(hint = "Email", value = email, onValueChange = { email = it }, keyboardType = KeyboardType.Email)
            Spacer(modifier = Modifier.height(28.dp))

            AppTextField(hint = "Mobile no", value = phone, onValueChange = { phone = it }, keyboardType = KeyboardType.Phone)
            Spacer(modifier = Modifier.height(28.dp))

            AppTextField(hint = "Address", value = address, onValueChange = { address = it })
            Spacer(modifier = Modifier.height(28.dp))

            AppTextField(hint = "Password", value = password, onValueChange = { password = it }, keyboardType = KeyboardType.Password)
            Spacer(modifier = Modifier.height(28.dp))

            AppTextField(
                hint = "Confirm password",
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                keyboardType = KeyboardType.Password,
                action = ImeAction.Done
            )
            Spacer(modifier = Modifier.height(28.dp))

            FilledButton(text = "Sign Up", modifier = Modifier.fillMaxWidth()) {
                if (password == confirmPassword) {
                    viewModel.signUp(name, email, phone, address, password)
                }
            }

            /*error.value?.let {
                Spacer(modifier = Modifier.height(16.dp))
                Text("❌ $it", color = MaterialTheme.colors.error)
            }*/

            Spacer(modifier = Modifier.height(28.dp))
            Footer(
                text = "Already have an Account?",
                textButton = "Login",
                onClick = navigateToSignInScreen
            )
        }
    }
}
