package by.vfedorenko.letsgetdrunk.presentation.login

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import by.vfedorenko.letsgetdrunk.R
import by.vfedorenko.letsgetdrunk.databinding.ActivityLoginBinding
import by.vfedorenko.letsgetdrunk.presentation.App
import by.vfedorenko.letsgetdrunk.presentation.login.viewmodels.LoginViewModel
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).injectMe(this)

        val binding = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        binding.viewModel = viewModel

        viewModel.init(this)
    }

}
