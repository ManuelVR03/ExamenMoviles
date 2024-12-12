package modelo

import java.io.Serializable

enum class TipoComponente {

    SIMPLE,PROCESADO,MENU,RECETA,DIETA

}

data class ComponenteDieta(
    var nombre: String,
    var tipo:TipoComponente=TipoComponente.SIMPLE,
    var grHC_ini: Double=0.0,
    var grLip_ini:Double=0.0,
    var grPro_ini:Double=0.0): Serializable {

    val grHC: Double
        get() = if(tipo.esSimpleOProcesado()) grHC_ini
        else  ingredientes.sumOf { it.cd.grHC * it.cantidad / 100 }

    val grLip: Double
        get() =  if(tipo.esSimpleOProcesado())  grLip_ini
        else ingredientes.sumOf { it.cd.grLip * it.cantidad / 100 }

    val grPro: Double
        get() = if(tipo.esSimpleOProcesado())  grPro_ini
        else ingredientes.sumOf { it.cd.grPro * it.cantidad / 100 }

    val cantidadTotal: Double
        get() =if(tipo.esSimpleOProcesado())  100.0
        else ingredientes.sumOf { it.cd.cantidadTotal * it.cantidad / 100 }

    val Kcal: Double
        get() = (4 * grHC) + (4 * grPro) + (9 * grLip)

    val ingredientes: MutableList<Ingrediente> = mutableListOf()


    constructor() : this("",TipoComponente.SIMPLE,0.0, 0.0, 0.0)

    fun TipoComponente.esSimpleOProcesado() = this == TipoComponente.SIMPLE || this == TipoComponente.PROCESADO

    fun addIngrediente(ing: Ingrediente) : Boolean {
        return if (!ingredientes.contains(ing)) {
            ingredientes.add(ing)
            true
        } else false
    }
    fun removeIngrediente(ing: Ingrediente): Boolean  {
        return ingredientes.remove(ing)
    }

}

//Cantidad de un ingrediente es un % sobre la cantidadTotal de un componenteDieta
//si no se especifica nada se supone que es 100%
//Si un alimento no especifica su cantidadTotal, se supone 100 gr o 100 ml
data class Ingrediente(
    var cd: ComponenteDieta,
    var cantidad:Double=100.0): Serializable
{ }
