package by.vfedorenko.letsgetdrunk.presentation.events.viewmodels

import android.view.View
import by.vfedorenko.letsgetdrunk.entities.Event

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 08.11.16.
 */
class EventItemViewModel {
    var event: Event = Event()

    fun getCreatorName() = event.creator.name
    fun getAvatarUrl() = event.creator.image
    fun getLastUpdate() = event.lastUpdate
    fun getImageUrl() = event.imageUrl
    fun getTitle() = event.title
    fun getDescription() = event.description

    fun onEventClick(v: View) {
        // TODO start details
    }
}
