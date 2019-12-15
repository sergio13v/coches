package com.example.tenis

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.util.ArrayList



class CreacionListado(private val context: Context, private val jugadoresArrayList: ArrayList<Jugadores>) :
    BaseAdapter() {

    override fun getViewTypeCount(): Int {
        return count
    }

    override fun getItemViewType(posicion: Int): Int {

        return posicion
    }

    override fun getCount(): Int {
        return jugadoresArrayList.size
    }

    override fun getItem(posicion: Int): Any {
        return jugadoresArrayList[posicion]
    }

    override fun getItemId(posicion: Int): Long {
        return 0
    }

    override fun getView(posicion: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val holder: ViewHolder

        if (convertView == null) {
            holder = ViewHolder()
            val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.lv_item, null, true)

            holder.tvnombre = convertView!!.findViewById(R.id.nombre) as TextView
            holder.tvpais = convertView.findViewById(R.id.pais) as TextView
            holder.tvciudad = convertView.findViewById(R.id.ciudad) as TextView

            convertView.tag = holder
        } else {

            holder = convertView.tag as ViewHolder
        }

        holder.tvnombre!!.text = "Nombre: " + jugadoresArrayList[posicion].getNombres()
        holder.tvpais!!.text = "Pais: " + jugadoresArrayList[posicion].getPaises()
        holder.tvciudad!!.text = "Ciudad: " + jugadoresArrayList[posicion].getCiudades()

        return convertView
    }

    private inner class ViewHolder {

         var tvnombre: TextView? = null
         var tvpais: TextView? = null
         var tvciudad: TextView? = null
    }

}