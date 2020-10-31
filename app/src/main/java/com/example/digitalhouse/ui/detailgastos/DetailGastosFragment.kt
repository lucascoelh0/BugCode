package com.example.digitalhouse.ui.detailgastos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.digitalhouse.R
import com.example.digitalhouse.domain.Gasto
import kotlinx.android.synthetic.main.fragment_detail_gastos.view.*

class DetailGastosFragment : Fragment() {

    private var listGastos = getListaGastos()
    private val adapter = DetailGastosAdapter(listGastos)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_detail_gastos, container, false)
        view.rcListaGastos.adapter = adapter
        view.rcListaGastos.layoutManager = LinearLayoutManager(context)
        view.rcListaGastos.setHasFixedSize(true)

        return view
    }

    fun getListaGastos(): ArrayList<Gasto> {

        val gasto0 = Gasto("Aluguel", "fixo", "30/10/2020", 1045.0)
        val gasto1 = Gasto("Aposta", "variavel", "10/10/2020", 30.0)
        val gasto2 = Gasto("Compra de produtos", "variavel", "05/10/2020", 500.0)
        val gasto3 = Gasto("Perdi na rua", "variavel", "01/10/2020", 50.0)

        return arrayListOf(
            gasto0,
            gasto1,
            gasto2,
            gasto3,
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.getString("key")?.let {

        }
    }

    companion object {
        @JvmStatic
        fun newInstance(msg: String) =
            DetailGastosFragment().apply {
                arguments = Bundle().apply {
                    putString("key", msg)
                }
            }
    }
}