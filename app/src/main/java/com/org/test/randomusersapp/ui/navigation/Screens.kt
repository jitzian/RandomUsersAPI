package com.org.test.randomusersapp.ui.navigation

sealed class Screens(
    val title: String,
    val route: String,
) {
    data object MainNavScreen : Screens(
        title = "Main Screen",
        route = "main_screen"
    )

    data object DetailsNavScreen : Screens(
        title = "Detail Screen",
        route = "detail_screen"
    ) {
        const val id = "id"
    }

    // build navigation path (for screen navigation)
    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

    // build and setup route format (in navigation graph)
    fun withArgsFormat(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/{$arg}")
            }
        }
    }
}