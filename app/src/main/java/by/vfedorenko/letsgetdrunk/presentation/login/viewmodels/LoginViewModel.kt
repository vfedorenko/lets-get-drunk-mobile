package by.vfedorenko.letsgetdrunk.presentation.login.viewmodels

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import by.vfedorenko.letsgetdrunk.businesslogic.interactors.LoginInteractor
import by.vfedorenko.letsgetdrunk.entities.LoginUser
import by.vfedorenko.letsgetdrunk.presentation.events.activities.EventsActivity
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 02.11.16.
 */
class LoginViewModel @Inject constructor(val loginInteractor: LoginInteractor) {
    val isRegistration = ObservableBoolean(false)
    val errorName = ObservableField<String>()
    val errorEmail = ObservableField<String>()
    val errorPassword = ObservableField<String>()

    val requestFocus = ObservableBoolean(false)

    private val user = LoginUser()

    fun getName() = user.name
    fun setName(name: String) {
        user.name = name
    }

    fun getEmail() = user.email
    fun setEmail(email: String) {
        user.email = email
    }

    fun getPassword() = user.password
    fun setPassword(password: String) {
        user.password = password
    }

    fun onLoginClick(v: View) {
        val single = if (isRegistration.get()) {
            loginInteractor.register(user)
        } else {
            loginInteractor.login(user)
        }

        single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it) {
                        v.context.startActivity(EventsActivity.createIntent(v.context))
                    } else {
                        Toast.makeText(v.context, "Failed", Toast.LENGTH_SHORT).show()
                    }
                }, {
                    it.printStackTrace()
                    Toast.makeText(v.context, "Failed", Toast.LENGTH_SHORT).show()
                })
    }

    fun switchMode(v: View) {
        isRegistration.set(!isRegistration.get())
        requestFocus.set(isRegistration.get())
    }

    fun init(activity: AppCompatActivity) {
        if (loginInteractor.isLoggedIn()) {
            activity.startActivity(EventsActivity.createIntent(activity))
            activity.finish()
        }
    }
}
