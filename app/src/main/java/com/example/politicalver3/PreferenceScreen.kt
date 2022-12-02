package com.example.politicalver3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PreferenceScreen(navController: NavController) {
    var gender = listOf<String>("Male" , "Female" , "Prefers not to say", "Other")
    var selectedGender by remember { mutableStateOf("this is the first ") }
    var age = listOf<String>("18-25", "26-32", "33-40", "41-50", "51-60", "61-70", "71-80", "More then 81")
    var selectedAge by remember { mutableStateOf(" this is the second ") }

    Column(modifier = Modifier.fillMaxWidth()) {
        // add h1 to the top of the page
        Text(text = "Preferences" , modifier = Modifier.padding(20.dp) , style = MaterialTheme.typography.h4)
        dropDownMenu(list = gender, labeli = "Select gender", onSelected = { selectedGender = it })
        dropDownMenu(list = age, labeli = "Select age" , onSelected = { selectedAge = it })
        Text(text = selectedGender)
        Text(text = selectedAge)


        // blue submit button with round edges on the center
        Button(onClick = {
                         navController.navigate(Screen.SwipeScreen.route)

        }, modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()) {
            Text(text = "Submit")
        }
    }
}