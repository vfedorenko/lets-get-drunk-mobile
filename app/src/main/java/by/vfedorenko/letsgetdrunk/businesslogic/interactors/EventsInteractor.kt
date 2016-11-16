package by.vfedorenko.letsgetdrunk.businesslogic.interactors

import by.vfedorenko.letsgetdrunk.businesslogic.webapi.EventsService
import by.vfedorenko.letsgetdrunk.entities.Event
import rx.Single
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 08.11.16.
 */
class EventsInteractor @Inject constructor(val eventsService: EventsService) {
    fun getEvents(): Single<List<Event>> = eventsService.getEvents()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun createEvent(event: Event): Single<Event> = eventsService.createEvent(event)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}
