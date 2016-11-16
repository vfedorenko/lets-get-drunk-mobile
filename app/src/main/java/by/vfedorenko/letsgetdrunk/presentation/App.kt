package by.vfedorenko.letsgetdrunk.presentation

import android.app.Application
import android.support.v7.app.AppCompatActivity
import by.vfedorenko.letsgetdrunk.presentation.assemblies.AppComponent
import by.vfedorenko.letsgetdrunk.presentation.assemblies.AppModule
import by.vfedorenko.letsgetdrunk.presentation.assemblies.DaggerAppComponent
import by.vfedorenko.letsgetdrunk.presentation.events.activities.CreateEventActivity
import by.vfedorenko.letsgetdrunk.presentation.events.activities.EventsActivity
import by.vfedorenko.letsgetdrunk.presentation.events.assemblies.EventsComponent
import by.vfedorenko.letsgetdrunk.presentation.login.LoginActivity
import by.vfedorenko.letsgetdrunk.presentation.login.assemblies.LoginComponent

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 02.11.16.
 */
class App : Application() {
    companion object {
        const val EMPTY_STRING = ""
        const val NO_ID = -1L
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(applicationContext))
                .build()
    }

    val loginComponent: LoginComponent by lazy {
        appComponent.plusLogin()
    }

    val eventsComponent: EventsComponent by lazy {
        appComponent.plusEvents()
    }

    fun injectMe(activity: AppCompatActivity) {
        when (activity) {
            is LoginActivity -> loginComponent.inject(activity)
            is EventsActivity -> eventsComponent.inject(activity)
            is CreateEventActivity -> eventsComponent.inject(activity)
        }
    }
}
