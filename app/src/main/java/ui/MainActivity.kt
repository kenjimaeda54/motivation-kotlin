package ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.e.motivation.R
import infra.MotivationConstants
import infra.SecuritySharedPreferences
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SecuritySharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(supportActionBar  != null ){
            supportActionBar!!.hide()
        }
        sharedPreferences = SecuritySharedPreferences(this)
        val name = sharedPreferences.getString(MotivationConstants.Key.PERSON_NAME)
        textName.text = name

    }
}