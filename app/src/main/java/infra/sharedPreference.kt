package infra

import android.content.Context
import android.content.SharedPreferences

class SecuritySharedPreferences (context: Context) {
    private val mSharedPreferences =  context.getSharedPreferences("motivation",Context.MODE_PRIVATE)

    fun storeString(key: String, value: String) {
        mSharedPreferences.edit().putString(key,value);
    }

    fun getString(key:String){

    }


}