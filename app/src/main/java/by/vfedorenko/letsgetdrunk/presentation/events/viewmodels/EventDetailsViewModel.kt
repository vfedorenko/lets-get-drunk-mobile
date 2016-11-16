package by.vfedorenko.letsgetdrunk.presentation.events.viewmodels

import android.view.View
import by.vfedorenko.letsgetdrunk.businesslogic.interactors.EventsInteractor
import by.vfedorenko.letsgetdrunk.entities.Event
import by.vfedorenko.letsgetdrunk.presentation.BaseView
import javax.inject.Inject

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 16.11.16.
 */
class EventDetailsViewModel @Inject constructor(val interactor: EventsInteractor) {
    var baseView: BaseView? = null
    var event: Event = Event()

    fun getTitle() = event.title
    fun setTitle(title: String) {
        event.title = title
    }
    fun getDescription() = event.description
    fun setDescription(description: String) {
        event.description = description
    }

    fun onDoneClick(v: View) {
        interactor.createEvent(event)
                .subscribe({baseView?.finish()}, {handleError(it)})
    }

    fun handleError(error: Throwable) {
        baseView?.showError(error.message)
    }
}
