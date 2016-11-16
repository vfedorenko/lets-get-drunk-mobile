package by.vfedorenko.letsgetdrunk.presentation.events.activities

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import by.vfedorenko.letsgetdrunk.R
import by.vfedorenko.letsgetdrunk.databinding.ActivityEventBinding
import by.vfedorenko.letsgetdrunk.presentation.App
import by.vfedorenko.letsgetdrunk.presentation.BaseActivity
import by.vfedorenko.letsgetdrunk.presentation.events.viewmodels.EventDetailsViewModel
import javax.inject.Inject

class CreateEventActivity : BaseActivity() {
    companion object {
        fun createIntent(context: Context) = Intent(context, CreateEventActivity::class.java)
    }

    @Inject
    lateinit var viewModel: EventDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as App).injectMe(this)

        viewModel.baseView = this

        val binding = DataBindingUtil.setContentView<ActivityEventBinding>(this, R.layout.activity_event)
        binding.viewModel = viewModel

        setupToolbar(binding.toolbar, hasBack = true)
    }
}
