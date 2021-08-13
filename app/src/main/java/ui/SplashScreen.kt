package ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.e.motivation.R
import infra.MotivationConstants
import infra.SecuritySharedPreferences
import kotlinx.android.synthetic.main.activity_splapsh_screen.*

class SplashScreen : AppCompatActivity(), View.OnClickListener {

    private lateinit var sharedPreferences : SecuritySharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splapsh_screen)

        sharedPreferences = SecuritySharedPreferences(this)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        buttonSalve.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonSalve) {
            salveName()
        }
    }

    private fun salveName() {
        val name = editName.text.toString()
        if (name == "") {
            Toast.makeText(this, getString(R.string.mensagen_error), Toast.LENGTH_SHORT).show()
        } else {
            sharedPreferences.storeString(MotivationConstants.Key.PERSON_NAME, name)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}