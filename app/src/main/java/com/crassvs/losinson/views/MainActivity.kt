package com.crassvs.losinson.views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.crassvs.losinson.databinding.ActivityMainBinding
import com.crassvs.losinson.viewmodels.MainViewModel
import com.crassvs.losinson.views.adapters.PersonajeAdapter


private lateinit var binding: ActivityMainBinding
private lateinit var viewModel: MainViewModel
private lateinit var adapter: PersonajeAdapter


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setupRecyclerView()

        viewModel.obtenerPersonajes()

        viewModel.listaPersonajes.observe(this){
            adapter.listaPersonajes = it
            adapter.notifyDataSetChanged()
        }

        binding.tilBuscar.setEndIconOnClickListener{
            if (binding.tietBuscar.text.toString() == ""){
                viewModel.obtenerPersonajes()
            }else{
                viewModel.obtenerPersonaje(binding.tietBuscar.toString().trim())
            }
        }
    }

    fun setupRecyclerView() {
        binding.rvPersonajes.layoutManager = GridLayoutManager(this, 3)
        adapter = PersonajeAdapter(this, arrayListOf())
        binding.rvPersonajes.adapter = adapter
    }
}