package com.example.probando_jpc_mvvm.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class Persona (val id:Int=0, val nombre:String="", val edad:Int=0)

class PersonasModelView: ViewModel() {

  //Declaramos las variables LiveData
    private val _persona = MutableLiveData(Persona())
    val persona: LiveData<Persona>  = _persona

  //Crea persona
  fun guardaPersona(persona: Persona){
    _persona.value=persona
  }

  //Creamos la funciones. Modificaciones en _variable
  fun incrementarEdad() {
    val personaActual= _persona.value
    personaActual?.let{ _persona.value = it.copy(edad=it.edad+1)}
  }


  fun cambiarEdad(valor:Int){
    val personaActual= _persona.value
    personaActual?.let{ _persona.value = it.copy(edad=valor)}
  }

  // Idem para una lista. 1) Creamos las variables _personas y personas
    private val _personas = MutableLiveData<List<Persona>>(emptyList())
    val personas: LiveData<List<Persona>> = _personas
  //2 Creamos las funciones

  //  Añadir una persona a la lista
  fun añadirPersona(nuevaPersona: Persona) {
    val listaActualizada = _personas.value?.toMutableList() ?: mutableListOf()
    listaActualizada.add(nuevaPersona)
    _personas.value = listaActualizada // Se notifica el cambio
  }

  //Actualizar una persona en la lista
  fun actualizarPersona(id: Int, nuevaPersona: Persona) {
    val listaActualizada = _personas.value?.toMutableList() ?: mutableListOf()
    val index = listaActualizada.indexOfFirst { it.id == id }
    if (index != -1) {
      listaActualizada[index] = nuevaPersona
      _personas.value = listaActualizada // Se notifica el cambio
    }
  }

  // Eliminar una persona de la lista
  fun eliminarPersona(id: Int) {
    val listaActualizada = _personas.value?.toMutableList() ?: mutableListOf()
    listaActualizada.removeAll { it.id == id }
    _personas.value = listaActualizada //Se notifica el cambio
  }

}