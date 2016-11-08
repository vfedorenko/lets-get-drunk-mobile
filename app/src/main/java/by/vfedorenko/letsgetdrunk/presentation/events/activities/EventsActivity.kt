package by.vfedorenko.letsgetdrunk.presentation.events.activities

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import by.vfedorenko.letsgetdrunk.R
import by.vfedorenko.letsgetdrunk.databinding.ActivityEventsBinding
import by.vfedorenko.letsgetdrunk.presentation.App
import by.vfedorenko.letsgetdrunk.presentation.events.viewmodels.EventsViewModel

class EventsActivity : AppCompatActivity() {
    companion object {
        fun createIntent(context: Context) = Intent(context, EventsActivity::class.java)
    }

    lateinit var viewModel: EventsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as App).injectMe(this)

        val binding = DataBindingUtil.setContentView<ActivityEventsBinding>(this, R.layout.activity_events)
        binding.viewModel = viewModel

        setSupportActionBar(binding.toolbar)
    }
}
