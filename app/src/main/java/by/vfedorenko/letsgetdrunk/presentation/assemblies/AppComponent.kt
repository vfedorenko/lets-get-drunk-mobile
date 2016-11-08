package by.vfedorenko.letsgetdrunk.presentation.assemblies

import by.vfedorenko.letsgetdrunk.businesslogic.assemblies.NetworkModule
import by.vfedorenko.letsgetdrunk.presentation.events.assemblies.EventsComponent
import by.vfedorenko.letsgetdrunk.presentation.login.assemblies.LoginComponent
import dagger.Component
import javax.inject.Singleton

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 02.11.16.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class))
interface AppComponent {
    fun plusLogin(): LoginComponent
    fun plusEvents(): EventsComponent
//    fun plus(module: LoginModule): LoginComponent
//    fun plus(module: SettingsModule): SettingsComponent
}
