package by.vfedorenko.letsgetdrunk.businesslogic.webapi

import by.vfedorenko.letsgetdrunk.entities.Event
import retrofit2.http.*
import rx.Single

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 08.11.16.
 */
interface EventsService {
    @GET("/events")
    fun getEvents(): Single<List<Event>>

    @Headers("Content-Type:application/json")
    @POST("/events")
    fun createEvent(@Body event: Event): Single<Event>

    @Headers("Content-Type:application/json")
    @PUT("/events/{event_id}")
    fun updateEvent(@Path("event_id") eventId: Long, @Body event: Event): Single<Event>

    @DELETE("/events/{event_id}")
    fun deleteEvent(@Path("event_id") eventId: Long): Single<Boolean>
}
