package by.vfedorenko.letsgetdrunk.presentation.events.assemblies

import by.vfedorenko.letsgetdrunk.presentation.events.activities.CreateEventActivity
import by.vfedorenko.letsgetdrunk.presentation.events.activities.EventDetailsActivity
import by.vfedorenko.letsgetdrunk.presentation.events.activities.EventsActivity
import dagger.Subcomponent

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 08.11.16.
 */
@Subcomponent
interface EventsComponent {
    fun inject(activity: EventsActivity)
    fun inject(activity: CreateEventActivity)
    fun inject(activity: EventDetailsActivity)
}
