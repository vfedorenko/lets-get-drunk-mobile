package by.vfedorenko.letsgetdrunk.presentation

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Toast

abstract class BaseActivity : AppCompatActivity(), BaseView {
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        android.R.id.home -> {
            finish()
            true
        }
        else -> onOptionsItemSelected(item)
    }

    override fun showError(msg: String?) {
        Toast.makeText(this, "Error: $msg", Toast.LENGTH_SHORT).show()
    }

    fun setupToolbar(toolbar: Toolbar, hasBack: Boolean = false, title: String = App.EMPTY_STRING) {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(hasBack)

        if (title.isNotEmpty()) {
            supportActionBar?.title = title
        }
    }
}
