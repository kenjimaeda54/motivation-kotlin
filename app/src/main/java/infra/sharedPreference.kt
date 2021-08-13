package infra

import android.content.Context
import android.content.SharedPreferences

class sharedPreference(context: Context)  {

    private val sharedPreferences =  context.getSharedPreferences("motivation",Context.MODE_PRIVATE)


    fun storeString(key: String, value:String) {
      sharedPreferences.edit().putString(key,value).apply()
    }

    fun getString(key: String){

    }

}