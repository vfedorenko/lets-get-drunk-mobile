package by.vfedorenko.letsgetdrunk.presentation.events.activities

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import by.vfedorenko.letsgetdrunk.R
import by.vfedorenko.letsgetdrunk.databinding.ActivityEventsBinding
import by.vfedorenko.letsgetdrunk.presentation.App
import by.vfedorenko.letsgetdrunk.presentation.BaseActivity
import by.vfedorenko.letsgetdrunk.presentation.events.viewmodels.EventsViewModel
import javax.inject.Inject

class EventsActivity : BaseActivity() {
    companion object {
        fun createIntent(context: Context) = Intent(context, EventsActivity::class.java)
    }

    @Inject
    lateinit var viewModel: EventsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as App).injectMe(this)

        val binding = DataBindingUtil.setContentView<ActivityEventsBinding>(this, R.layout.activity_events)
        binding.viewModel = viewModel

        setupToolbar(binding.toolbar)
    }

    override fun onResume() {
        super.onResume()
        viewModel.init()
    }
}
