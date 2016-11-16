package by.vfedorenko.letsgetdrunk.businesslogic.assemblies

import by.vfedorenko.letsgetdrunk.businesslogic.utils.AuthorizedUserManager
import by.vfedorenko.letsgetdrunk.businesslogic.webapi.EventsService
import by.vfedorenko.letsgetdrunk.businesslogic.webapi.UserService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 02.11.16.
 */
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideEventsService(retrofit: Retrofit): EventsService = retrofit.create(EventsService::class.java)

    @Singleton
    @Provides
    fun provideUserService(retrofit: Retrofit): UserService = retrofit.create(UserService::class.java)

    @Singleton
    @Provides
    fun provideRetrofit(baseUrl: String, client: OkHttpClient, gson: Gson): Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun provideOkHttpClient(interceptor: Interceptor) = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

    @Singleton
    @Provides
    fun provideInterceptor(authUserManager: AuthorizedUserManager) = Interceptor {
        val originalRequest = it.request()

        val token = authUserManager.getToken()
        val client = authUserManager.getClient()
        val uid = authUserManager.getUid()

        if (token.isEmpty() || client.isEmpty() || uid.isEmpty()) {
            it.proceed(originalRequest)
        } else {
            val requestBuilder = originalRequest.newBuilder()
                    .header("access-token", token)
                    .header("client", client)
                    .header("uid", uid)
                    .method(originalRequest.method(), originalRequest.body())

            val request = requestBuilder.build()
            it.proceed(request)
        }
    }

    @Singleton
    @Provides
    fun provideBaseUrl() = "https://lets-get-drunk-vfedorenko.c9users.io"
}
