package com.example.politicalver3


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun Navigation() {
    val navCotroller = rememberNavController()
    NavHost(navController = navCotroller, startDestination = Screen.LoginScreen.route) {
//        composable(route = Screen.MainScreen.route) {
//            MainScreen(navController = navCotroller)
//        }
//        // if we want the name to be optional we can use navArgument with nullable = true
//        // we specify the route with ? to make it optional and we can use it in the composable
//        // ?name={name}
//        // if we want more than 1 parameter
//        // /{name}/{age}
//        composable(route = Screen.DetailScreen.route + "/{name}" , arguments = listOf(
//            navArgument("name") {
//                type = NavType.StringType
//                defaultValue = "Yaakov"
//                nullable = true
//            }
//        )
//        ){entry ->
//            DetailScreen(name = entry.arguments?.getString("name"))
//        }




        composable(route = Screen.RegisterScreen.route) {
            RegisterScreen(navController = navCotroller)
        }

        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navCotroller)
        }

        composable(route = Screen.PreferenceScreen.route) {
            PreferenceScreen(navController = navCotroller)
        }

        composable(route = Screen.SwipeScreen.route) {
            SwipeScreen(navController = navCotroller)
        }





    }
}





