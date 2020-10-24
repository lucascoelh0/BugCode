package com.example.digitalhouse.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.digitalhouse.R
import com.example.digitalhouse.`interface`.ContractMainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_entradas.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private lateinit var cma: ContractMainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        view.btnGastos.setOnClickListener {
            cma.callFragDetailGastos()
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        cma.mudarCorHome(R.color.colorPurple)
    }

    override fun onPause() {
        super.onPause()
        cma.mudarCorHome(R.color.colorWhite)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ContractMainActivity) cma = context
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}