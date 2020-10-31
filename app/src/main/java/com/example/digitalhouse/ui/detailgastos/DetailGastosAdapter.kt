package com.example.digitalhouse.ui.detailgastos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalhouse.R
import com.example.digitalhouse.domain.Gasto

class DetailGastosAdapter(private val listGastos: List<Gasto>) : RecyclerView.Adapter<DetailGastosAdapter.DetailGastosViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailGastosViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_gasto, parent, false)
        return DetailGastosViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DetailGastosViewHolder, position: Int) {

        val currentItem: Gasto = listGastos[position]

        holder.tvDescricao.text = currentItem.descricao
        holder.tvCategoria.text = currentItem.categoria
        holder.tvDataHora.text = currentItem.dataEHora
        holder.tvValor.text = currentItem.valor.toString()
    }

    override fun getItemCount(): Int {
        return listGastos.size
    }

    class DetailGastosViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvDescricao: TextView = itemView.findViewById(R.id.tvDescricao)
        val tvCategoria: TextView = itemView.findViewById(R.id.tvCategoria)
        val tvDataHora: TextView = itemView.findViewById(R.id.tvDataHora)
        val tvValor: TextView = itemView.findViewById(R.id.tvValor)
    }
}