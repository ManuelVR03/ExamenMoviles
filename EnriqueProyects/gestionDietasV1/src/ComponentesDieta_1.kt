package modelo1

import java.io.Serializable

data class ComponenteDieta (
    var nombre: String,
    var tipo:String="simple",
    var grHC: Double=0.0,
    var grLip:Double=0.0,
    var grPro:Double=0.0): Serializable {
    var cantidadTotal=0.0
    var Kcal:Double=0.0
    var ingredientes :MutableList<Ingrediente> = mutableListOf()
    var contenedores :MutableList<ComponenteDieta> = mutableListOf()

    init{
        if (tipo=="simple"||tipo=="procesado"){
            cantidadTotal=100.0
            calculaKcal()
        }else
            calculaKcal()
    }

    constructor() : this("", "simple", 0.0, 0.0, 0.0)

    fun addIngrediente(ing: Ingrediente){

        if (!ingredientes.contains(ing)) {
            ingredientes.add(ing)
            ing.alimentoHijo.contenedores.add(this)
            backUpdate()
        }

    }
    fun removeIngrediente(ing: Ingrediente){
        if(ingredientes.remove(ing))backUpdate()
    }

    // Cuando se añade, borra, o modifica un alimento o alguno
    // de sus ingredientes,esto afecta a otros alimentos
    // que lo contienen, por lo que el backUpdate() se debe hacer
    // recursivamente hacia atrás con todos lo alimentos que
    // lo contienen. En caso de que la persistencia sea en una BD
    // backUpdate hay que hacerlo en la capa de servicio
    // usando todos los dao que sean necesarios sobre cada alimento afectado
    fun backUpdate(){
        update()
        contenedores.forEach {it.backUpdate()}
    }

    private fun update() {
        if (ingredientes.isEmpty()) {
            // Elemento simple
            this.calculaKcal()
        } else {
            // Elemento compuesto
            this.recalcularCantidades()
            this.calculaKcal()
        }
    }
    //Para que funcione la actualización hacia atrás, cantidad
    //de los ingredientes están en %. 100.0=100%
    //cantidadTotal está en gr/ml 100.0= 100 gr/ml
    private fun recalcularCantidades() {
        this.cantidadTotal = ingredientes.sumOf { it.alimentoHijo.cantidadTotal * it.cantidad / 100 }
        this.grHC = ingredientes.sumOf { it.alimentoHijo.grHC * it.cantidad / 100 }
        this.grLip = ingredientes.sumOf { it.alimentoHijo.grLip * it.cantidad / 100 }
        this.grPro = ingredientes.sumOf { it.alimentoHijo.grPro * it.cantidad / 100 }
    }
    private fun calculaKcal() {
        this.Kcal = (4 * grHC) + (4 * grPro) + (9 * grLip)
    }
}

//cantidad de un ingrediente es un % sobre la cantidadTotal de un alimentoHijo
//si no se especifica nada se supone que es 100%
//Si un alimento no especifica su cantidadTotal, se supone 100 gr o 100 ml
data class Ingrediente(
    var alimentoPadre: modelo1.ComponenteDieta,
    var alimentoHijo: modelo1.ComponenteDieta,
    var cantidad:Double=100.0)


{ }

