package com.example.politicalver3

sealed class Screen(val route: String) {
    object RegisterScreen : Screen("register_screen")
    object LoginScreen : Screen("login_screen")
    object PreferenceScreen : Screen("preference_screen")
    object SwipeScreen : Screen("swipe_screen")
    object CelebProfileScreen : Screen("celeb_profile_screen")



    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}

