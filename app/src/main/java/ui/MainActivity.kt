package ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.e.motivation.R
import infra.MotivationConstants
import infra.SecuritySharedPreferences
import kotlinx.android.synthetic.main.activity_main.*
import repository.Mock

class MainActivity : AppCompatActivity(), View.OnClickListener {
    //precisei usar o metodo lateinit no var sharedPreferences,porque ele usa contexto
    private lateinit var sharedPreferences: SecuritySharedPreferences
    private var mPhaserFilter: Int = MotivationConstants.Phrase.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonNewPhrase.setOnClickListener(this)
        imgAll.setOnClickListener(this)
        imgHappy.setOnClickListener(this)
        imgSum.setOnClickListener(this)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        sharedPreferences = SecuritySharedPreferences(this)
        val name = sharedPreferences.getString(MotivationConstants.Key.PERSON_NAME)
        textName.text = "Ola  $name !"
        imgAll.setColorFilter(resources.getColor(R.color.purple_200))
        generateNewPhrase()

    }


    override fun onClick(view: View) {
        val listImg = listOf(R.id.imgAll, R.id.imgHappy, R.id.imgSum)
        val id = view.id;
        if (id == R.id.buttonNewPhrase) {
            generateNewPhrase()
        } else if (id in listImg) {
            filterPhase(id)
        }

    }

    private fun filterPhase(id: Int) {
        imgAll.setColorFilter(resources.getColor(R.color.white))
        imgSum.setColorFilter(resources.getColor(R.color.white))
        imgHappy.setColorFilter(resources.getColor(R.color.white))
        when (id) {
            R.id.imgSum -> {
                imgSum.setColorFilter(resources.getColor(R.color.purple_200))
                mPhaserFilter = MotivationConstants.Phrase.SUM
                generateNewPhrase()

            }
            R.id.imgAll -> {
                imgAll.setColorFilter(resources.getColor(R.color.purple_200))
                mPhaserFilter = MotivationConstants.Phrase.ALL
                generateNewPhrase()
            }
            R.id.imgHappy -> {
                imgHappy.setColorFilter(resources.getColor(R.color.purple_200))
                mPhaserFilter = MotivationConstants.Phrase.HAPPY
                generateNewPhrase()
            }
        }


    }

    private fun generateNewPhrase() {
        textPhrase.text = Mock().getPhrase(mPhaserFilter)
    }

}

