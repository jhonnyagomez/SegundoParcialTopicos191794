package com.example.tabs.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tabs.R
import com.example.tabs.adapter.ListaAdapter
import com.example.tabs.helpers.DataBasePersonaje
import com.example.tabs.models.Personaje
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ConsultaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ConsultaFragment : Fragment() {
    private var listaPersonaje= mutableListOf<Personaje>()
    private lateinit var rvList : RecyclerView
    private lateinit var adapter: ListaAdapter
    private var dataBasePersonaje: DataBasePersonaje? =  null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_consulta, container, false)
        initComponent(view)
        initListener()
        return view
    }

    override fun onResume() {
        super.onResume()
        initListener()
    }

    private fun initComponent(view :View){
        dataBasePersonaje = DataBasePersonaje(view.context)
        rvList =  view.findViewById(R.id.rvListPersonaje)
        adapter = ListaAdapter(listaPersonaje)
        rvList.layoutManager = LinearLayoutManager(view.context)
        rvList.adapter = adapter

    }


    private fun initListener(){
        Log.i("Error" ,"eeeee")
        dataBasePersonaje?.let {
            Log.i("Error" , "adsfadsfadsfadsfadsfasdf")

            val lp = it.selectAllPersonaje()
            Log.i("Error" , lp.toString())
           // viewLifecycleOwner.lifecycleScope.launch {
                listaPersonaje.clear()
                listaPersonaje.addAll(lp)
                adapter.notifyDataSetChanged()
           // }
        }


    }
}