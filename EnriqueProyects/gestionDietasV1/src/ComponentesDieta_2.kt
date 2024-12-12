package modelo2

import modelo.TipoComponente

data class ComponenteDieta (
    var nombre: String,
    var tipo:String="simple",
    var grHC_ini: Double=0.0,
    var grLip_ini:Double=0.0,
    var grPro_ini:Double=0.0) {



    val grHC: Double
        get() = if(tipo=="simple"||tipo=="procesado")
                    grHC_ini
                else
                    ingredientes.sumOf { it.alimentoHijo.grHC * it.cantidad / 100 }

    val grLip: Double
        get() = if (ingredientes.isEmpty()) grLip_ini
        else ingredientes.sumOf { it.alimentoHijo.grLip * it.cantidad / 100 }

    val grPro: Double
        get() = if (ingredientes.isEmpty()) grPro_ini
        else ingredientes.sumOf { it.alimentoHijo.grPro * it.cantidad / 100 }

    val cantidadTotal: Double
        get() = if (ingredientes.isEmpty()) 100.0
        else ingredientes.sumOf { it.alimentoHijo.cantidadTotal * it.cantidad / 100 }

    val Kcal: Double
        get() = (4 * grHC) + (4 * grPro) + (9 * grLip)

    val ingredientes: MutableList<Ingrediente> = mutableListOf()

    constructor() : this("","simple", 0.0, 0.0, 0.0)


    fun addIngrediente(ing: Ingrediente) {
        if (!ingredientes.contains(ing)) {
            ingredientes.add(ing)
        }
    }

    fun removeIngrediente(ing: Ingrediente) {


    }

}

//cantidad de un ingrediente es un % sobre la cantidadTotal de un alimentoHijo
//si no se especifica nada se supone que es 100%
//Si un alimento no especifica su cantidadTotal, se supone 100 gr o 100 ml
data class Ingrediente(
    var alimentoPadre: modelo2.ComponenteDieta,
    var alimentoHijo: modelo2.ComponenteDieta,
    var cantidad:Double=100.0)


{ }

//Eliminar ingredientes y sustituir por Maps
//Cambiar la cantidad en % por cantidad en gr