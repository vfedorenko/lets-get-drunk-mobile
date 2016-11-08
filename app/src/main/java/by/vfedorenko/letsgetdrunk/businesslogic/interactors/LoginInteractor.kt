package by.vfedorenko.letsgetdrunk.businesslogic.interactors

import by.vfedorenko.letsgetdrunk.businesslogic.utils.AuthorizedUserManager
import by.vfedorenko.letsgetdrunk.businesslogic.webapi.NetworkError
import by.vfedorenko.letsgetdrunk.businesslogic.webapi.UserService
import by.vfedorenko.letsgetdrunk.entities.LoginUser
import by.vfedorenko.letsgetdrunk.entities.User
import retrofit2.Response
import rx.Single
import rx.Single.Transformer
import rx.Single.just
import rx.exceptions.Exceptions
import javax.inject.Inject

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 02.11.16.
 */
class LoginInteractor @Inject constructor(val userService: UserService,
                                          val authorizedUserManager: AuthorizedUserManager) {
    fun register(user: LoginUser): Single<Boolean> {
        return userService.register(user)
                .compose(saveHeaders())
                .compose(saveUserData())
    }

    fun login(user: LoginUser): Single<Boolean> {
        return userService.logIn(user)
                .compose(saveHeaders())
                .compose(saveUserData())
    }

    private fun saveHeaders() = Transformer<Response<User>, User>() {
        it.flatMap { response ->
            if (!response.isSuccessful) {
                Exceptions.propagate(NetworkError("Something wrong"))
            }

            val token = response.headers().get("access-token")
            val client = response.headers().get("client")
            val uid = response.headers().get("uid")

            if (!token.isEmpty() && !client.isEmpty() && !uid.isEmpty()) {
                authorizedUserManager.saveToken(token)
                authorizedUserManager.saveClient(client)
                authorizedUserManager.saveUid(uid)
            } else {
                Exceptions.propagate(IllegalStateException("Cannot save headers"))
            }

            just(response.body())
        }
    }

    private fun saveUserData() = Transformer<User, Boolean>() {
        it.flatMap { user ->
            authorizedUserManager.saveMyId(user.id)
            just(true)
        }
    }

    fun isLoggedIn() = !authorizedUserManager.getToken().isEmpty()
}
