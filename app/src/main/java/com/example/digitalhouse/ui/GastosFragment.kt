package com.example.digitalhouse.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.digitalhouse.R
import com.example.digitalhouse.`interface`.ContractMainActivity
import kotlinx.android.synthetic.main.fragment_home.view.*

class GastosFragment : Fragment() {

    private lateinit var cma: ContractMainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_gastos, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ContractMainActivity) cma = context
    }

    override fun onResume() {
        super.onResume()
        cma.mudarCorGastos(R.color.colorPurple)
    }

    override fun onPause() {
        super.onPause()
        cma.mudarCorGastos(R.color.colorWhite)
    }

    companion object {
        fun newInstance() = GastosFragment()
    }
}