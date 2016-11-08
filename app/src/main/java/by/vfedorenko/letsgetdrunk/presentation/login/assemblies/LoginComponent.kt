package by.vfedorenko.letsgetdrunk.presentation.login.assemblies

import by.vfedorenko.letsgetdrunk.presentation.login.LoginActivity
import dagger.Subcomponent

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 02.11.16.
 */
@Subcomponent
interface LoginComponent {
    fun inject(activity: LoginActivity)
}
