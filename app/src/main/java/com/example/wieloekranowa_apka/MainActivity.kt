@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.wieloekranowa_apka

import android.os.Bundle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val name=""
            val surname =""
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "home") {

                composable("home") { HomeScreen(myName = name, mySurName = surname, navController =navController ) }

                composable(
                    "detail/{name}/{surname}",
                    arguments = listOf(
                        navArgument("name") { type = NavType.StringType },
                        navArgument("surname") { type = NavType.StringType },
                    )
                ) {
                        backStackEntry ->
                    val name1 = backStackEntry.arguments?.getString("name")
                    val surname1 = backStackEntry.arguments?.getString("surname")
                    DetailScreen(name1, surname1,navController)
                }
                composable(
                    "trzeci/{name}/{surname}",
                    arguments = listOf(
                        navArgument("name") { type = NavType.StringType },
                        navArgument("surname") { type = NavType.StringType },
                    )
                ) {
                        backStackEntry ->
                    val name2 = backStackEntry.arguments?.getString("name")
                    val surname2 = backStackEntry.arguments?.getString("surname")
                    TrzeciScreen(myName = name2, mySurName = surname2, navController = navController)
                }
                composable(
                    "trzeci/{name}/{surname}",
                    arguments = listOf(
                        navArgument("name") { type = NavType.StringType },
                        navArgument("surname") { type = NavType.StringType },
                    )
                ) {
                        backStackEntry ->
                    val name3 = backStackEntry.arguments?.getString("name")
                    val surname3 = backStackEntry.arguments?.getString("surname")
                    TrzeciScreen(myName =name3 , mySurName =surname3 , navController =navController )
                }
                composable(
                    "home/{name}/{surname}",
                    arguments = listOf(
                        navArgument("name") { type = NavType.StringType },
                        navArgument("surname") { type = NavType.StringType },
                    )
                ) {
                        backStackEntry ->
                    val name4 = backStackEntry.arguments?.getString("name")
                    val surname4 = backStackEntry.arguments?.getString("surname")
                    HomeScreen(myName = name4, mySurName = surname4, navController = navController)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(myName:String?,mySurName:String?,navController: NavHostController) {
    val modifier = Modifier
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var nameValue by remember {
            mutableStateOf(" ")
        }
        var SurNameValue by remember {
            mutableStateOf(" ")
        }

            Text(text = "Ekran nr 1", fontSize = 26.sp, color = Color.Blue)
            Spacer(modifier = modifier.height(65.dp))
            TextField(
                value = nameValue,
                onValueChange = { nameValue = it },
                modifier.padding(10.dp),
                label = {Text(text = "podaj swoje imie")})

            TextField(
                value = SurNameValue,
                onValueChange = { SurNameValue = it }, modifier.padding(20.dp),
                label = {Text(text = "podaj swoje nazwisko")})

            Button(onClick = {

                navController.navigate("detail/${nameValue}/${SurNameValue}")

            }) {
                Text(text = "Ekran nr 2", fontSize = 10.sp)

            }
            Button(onClick = {
                navController.navigate("trzeci/${nameValue}/${mySurName}")

            }) {
                Text(text = "Ekran nr 3", fontSize = 10.sp)

            }
            if (mySurName !="" || myName != "") {
                Text(text = "Wiadomość z porzedniej strony", fontSize = 18.sp)
                Spacer(modifier = Modifier.height(45.dp))
                Text(text = "Twoje imię to $myName", fontSize = 18.sp)
                Spacer(modifier = Modifier.height(45.dp))
                Text(text = "Twoje nazwisko to $mySurName", fontSize = 18.sp)
            }

        }
    }

    @Composable
    fun DetailScreen(myName: String?, mySurName: String?, navController: NavHostController) {
        val modifier = Modifier
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var nameValue by remember {
                mutableStateOf(" ")
            }
            var SurNameValue by remember {
                mutableStateOf(" ")
            }
            Text(text = "Ekran nr 2", fontSize = 26.sp, color = Color.Red)
            Spacer(modifier = modifier.height(65.dp))
            TextField(
                value = nameValue,
                onValueChange = { nameValue = it },
                modifier.padding(10.dp),
                label = {Text(text = "podaj swoje imie")})
            TextField(
                value = SurNameValue,
                onValueChange = { SurNameValue = it }, modifier.padding(20.dp),
                label = {Text(text = "podaj swoje nazwisko")})
            Button(onClick = {
                navController.navigate("trzeci/${nameValue}/${SurNameValue}")


            }) {
                Text(text = "Przejdz do ekranu nr 3", fontSize = 10.sp)

            }

            Text(text = "Wiadomość z porzedniej strony", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(45.dp))
            Text(text = "Twoje imię to $myName", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(45.dp))
            Text(text = "Twoje nazwisko to $mySurName", fontSize = 18.sp)

        }

    }

    @Composable
    fun TrzeciScreen(myName: String?, mySurName: String?, navController: NavHostController) {
        val modifier = Modifier
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var nameValue by remember {
                mutableStateOf(" ")
            }
            var SurNameValue by remember {
                mutableStateOf(" ")
            }
            Text(text = "Ekran nr 3", fontSize = 26.sp, color = Color.Yellow)
            Spacer(modifier = modifier.height(65.dp))
            TextField(
                value = nameValue,
                onValueChange = { nameValue = it },
                modifier.padding(10.dp),
                label = {Text(text = "podaj swoje imie")})
            TextField(
                value = SurNameValue,
                onValueChange = { SurNameValue = it }, modifier.padding(20.dp),
                label = {Text(text = "podaj swoje nazwisko")})
            Button(onClick = {
                navController.navigate("home/${nameValue}/${SurNameValue}")


            }) {
                Text(text = "Przejdź do ekranu nr 1", fontSize = 10.sp)

            }
            Text(text = "Wiadomość z porzedniej strony", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(45.dp))
            Text(text = "Twoje imię to $myName", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(45.dp))
            Text(text = "Twoje nazwisko to $mySurName", fontSize = 18.sp)

        }

    }
