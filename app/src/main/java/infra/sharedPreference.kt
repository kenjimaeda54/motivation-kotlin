package infra

import android.content.Context


class SecuritySharedPreferences (context: Context) {
    private val mSharedPreferences =  context.getSharedPreferences("motivation",Context.MODE_PRIVATE)

    fun storeString(key: String, value: String) {
        mSharedPreferences.edit().putString(key,value).apply()
    }

    fun getString(key:String): String{
      return mSharedPreferences.getString(key, " ")  ?: ""
//      ?: este operador e recurso do kotlin conhecido como elvis,
//      se for nullo retorno valor do lado direito
//      se comecar acusar erro , repara no Found,e verifica se o retorno esta
//      de acordo com sua funcao
    }


}