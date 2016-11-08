package by.vfedorenko.letsgetdrunk.businesslogic.webapi

import by.vfedorenko.letsgetdrunk.entities.DeviceId
import by.vfedorenko.letsgetdrunk.entities.LoginUser
import by.vfedorenko.letsgetdrunk.entities.User
import retrofit2.Response
import retrofit2.http.*
import rx.Single

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 02.11.16.
 */
interface UserService {
    @Headers("Content-Type:application/json")
    @POST("/users")
    fun register(@Body user: LoginUser): Single<Response<User>>

    @Headers("Content-Type:application/json")
    @POST("/users/sign_in")
    fun logIn(@Body user: LoginUser): Single<Response<User>>

    @DELETE("/users/sign_out")
    fun logOut(): Single<Void>

    @GET("/users")
    fun getUsers(): Single<List<User>>

    @Headers("Content-Type:application/json")
    @PUT("/users/add_device_id")
    fun sendDeviceId(@Body deviceId: DeviceId): Single<Void>
}
