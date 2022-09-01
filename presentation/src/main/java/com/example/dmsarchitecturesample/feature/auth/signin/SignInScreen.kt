package com.example.dmsarchitecturesample.feature.auth.signin

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dmsarchitecturesample.R
import com.example.dmsarchitecturesample.feature.auth.IdTextField
import com.example.dmsarchitecturesample.feature.auth.PasswordTextField
import com.example.dmsarchitecturesample.util.Spacers

@Composable
fun SignInScreen(
    signInViewModel: SignInViewModel = hiltViewModel()
) {
    val state = signInViewModel.state.collectAsState().value
    Scaffold {
        Column(
            modifier = Modifier.padding(14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacers(orientation = stringResource(id = R.string.height), value = -20)
            Title()
            Spacers(orientation = stringResource(id = R.string.height), value = 50)
            val idLabel = stringResource(id = R.string.id)
            IdTextField(
                text = state.id,
                label = idLabel,
                doOnValueChange = {
                    signInViewModel.setId(it)
                },
                imeAction = ImeAction.Next
            )

            val passwordLabel = stringResource(id = R.string.password)
            PasswordTextField(
                text = state.password,
                label = passwordLabel,
                doOnValueChange = {
                    signInViewModel.setPassword(it)
                },
                imeAction = ImeAction.Done
            )
            Spacers(orientation = stringResource(id = R.string.height), value = 40)
            LoginButton()
        }
    }
}



@Composable
fun Title() {
    Text(
        text = stringResource(id = R.string.login),
        color = Color.Black,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun LoginButton() {
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.LightGray,
            contentColor = Color.Black
        )
    ) {
        Text("로그인")
    }
}

@Preview
@Composable
fun PreView() {
    SignInScreen()
}