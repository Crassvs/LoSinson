package com.crassvs.losinson.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crassvs.losinson.core.RetrofitClient
import com.crassvs.losinson.models.Personaje
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {

    //Modifica Lista de personajes
    private var _listaPersonajes = MutableLiveData<List<Personaje>>()
    //Solo Lectura
    val listaPersonajes: LiveData<List<Personaje>> get() = _listaPersonajes

    fun obtenerPersonajes(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.obtenerPersonajes()
            withContext(Dispatchers.Main){
                _listaPersonajes.value= response.body()
            }
        }
    }

    fun obtenerPersonaje(personaje: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.obtenerPersonaje(personaje)
            withContext(Dispatchers.Main){
                _listaPersonajes.value = response.body()
            }
        }
    }

}