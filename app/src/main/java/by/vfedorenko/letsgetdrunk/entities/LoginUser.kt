package by.vfedorenko.letsgetdrunk.entities

import by.vfedorenko.letsgetdrunk.presentation.App

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 02.11.16.
 */
data class LoginUser(var name: String = App.EMPTY_STRING,
                     var email: String = App.EMPTY_STRING,
                     var password: String = App.EMPTY_STRING)
