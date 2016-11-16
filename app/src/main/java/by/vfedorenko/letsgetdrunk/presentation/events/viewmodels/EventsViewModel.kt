package by.vfedorenko.letsgetdrunk.presentation.events.viewmodels

import android.util.Log
import android.view.View
import by.vfedorenko.letsgetdrunk.businesslogic.interactors.EventsInteractor
import by.vfedorenko.letsgetdrunk.presentation.events.activities.CreateEventActivity
import by.vfedorenko.letsgetdrunk.presentation.events.adapters.EventsAdapter
import javax.inject.Inject

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 08.11.16.
 */
class EventsViewModel @Inject constructor(val interactor: EventsInteractor) {
    val adapter by lazy {
        EventsAdapter()
    }

    fun init() {
        interactor.getEvents()
                .subscribe({ adapter.refreshItems(it) },
                        { Log.e("1111", "Failed to get Events", it) })
    }

    fun onAddClick(v: View) {
        v.context.startActivity(CreateEventActivity.createIntent(v.context))
    }
}
