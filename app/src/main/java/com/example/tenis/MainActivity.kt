package com.example.tenis

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import org.json.JSONException
import org.json.JSONObject
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.android.extension.responseJson
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    internal var URL = "https://demonuts.com/Demonuts/JsonTest/Tennis/json_parsing.php"
    private val jsoncode = 1
    private var listView: ListView? = null
    private var jugadoresArrayList: ArrayList<Jugadores>? = null
    private var creacionListado: CreacionListado? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.lv) as ListView

        mostrarListado()


    }

   private fun mostrarListado() {

        try {

            Fuel.post(URL, listOf()).responseJson { request, response, result ->
                Log.d("plzzzzz", result.get().content)
                tareaCompletada(result.get().content)
            }
        } catch (e: Exception) {

        } finally {

        }
    }


    fun tareaCompletada(response: String) {
        Log.d("responsejson", response)

        jugadoresArrayList = getInformacion(response)
        creacionListado = CreacionListado(this, jugadoresArrayList!!)
        listView!!.adapter = creacionListado
    }

    fun getInformacion(response: String): ArrayList<Jugadores> {
        val jugadoresArrayList = ArrayList<Jugadores>()
        try {
            val jsonObject = JSONObject(response)
            if (jsonObject.getString("status") == "true") {

                val dataArray = jsonObject.getJSONArray("data")

                for (i in 0 until dataArray.length()) {
                    val jugadores = Jugadores()
                    val dataobj = dataArray.getJSONObject(i)
                    jugadores.setNombres(dataobj.getString("name"))
                    jugadores.setPaises(dataobj.getString("country"))
                    jugadores.setCiudades(dataobj.getString("city"))
                    jugadoresArrayList.add(jugadores)
                }
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return jugadoresArrayList
    }

}


