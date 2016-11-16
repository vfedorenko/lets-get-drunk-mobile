package by.vfedorenko.letsgetdrunk.presentation.events.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.vfedorenko.letsgetdrunk.BR
import by.vfedorenko.letsgetdrunk.R
import by.vfedorenko.letsgetdrunk.databinding.ItemEventBinding
import by.vfedorenko.letsgetdrunk.entities.Event
import by.vfedorenko.letsgetdrunk.presentation.events.viewmodels.EventItemViewModel

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 09.11.16.
 */
class EventsAdapter: RecyclerView.Adapter<EventsAdapter.BindingHolder>() {
    class BindingHolder(item: View) : RecyclerView.ViewHolder(item) {
        var binding: ItemEventBinding
            private set

        init {
            binding = DataBindingUtil.bind(item)
        }
    }

    val events: MutableList<Event> = mutableListOf()

    override fun getItemCount() = events.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) =
            EventsAdapter.BindingHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_event, parent, false))

    override fun onBindViewHolder(holder: BindingHolder?, position: Int) {
        val viewModel = EventItemViewModel()
        viewModel.event = events[position]

        holder?.binding?.setVariable(BR.viewModel, viewModel)
        holder?.binding?.executePendingBindings()
    }

    fun refreshItems(items: List<Event>) {
        events.clear()
        events.addAll(items)
        notifyDataSetChanged()
    }
}
