package modelo

class DaoIngrediente: IDaoIngrediente {


    override fun createIngrediente(padre: ComponenteDieta, hijo: ComponenteDieta, cantidad: Double):Boolean {

        val ing= Ingrediente(hijo, cantidad)
        return if (!padre.ingredientes.contains(ing)) {
            padre.ingredientes.add(ing)
            true
        } else false
    }

    override fun readIngredientesByComponente(componente: ComponenteDieta):MutableList<Ingrediente> {
       return componente.ingredientes
    }

    override fun readIngredienteByComponente(componente: ComponenteDieta, ing:Ingrediente):Ingrediente?{
       return componente.ingredientes.find { it==ing }
    }


    override fun updateIngrediente(componente: ComponenteDieta, ingrediente: Ingrediente, cantidad: Double) {

    }

    override fun deleteIngredientebyComponente(componente: ComponenteDieta, ing:Ingrediente ):Boolean {

        return componente.ingredientes.remove(ing)

    }
}