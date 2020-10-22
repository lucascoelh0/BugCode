package com.example.digitalhouse

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class EntradasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_entradas, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Toast.makeText(context, "Entradas fragment", Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun newInstance() = EntradasFragment()
    }
}