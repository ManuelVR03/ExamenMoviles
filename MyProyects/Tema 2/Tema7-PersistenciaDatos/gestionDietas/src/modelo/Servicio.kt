package modelo

import modelo2.ComponenteDieta
import modelo2.Ingrediente

class Servicio:IServicio {
    override fun CreateComponente(listaComponente: MutableList<ComponenteDieta>, componente: ComponenteDieta) {
        TODO("Not yet implemented")
    }

    override fun readComponentes(): MutableList<ComponenteDieta> {
        TODO("Not yet implemented")
    }

    override fun readComponentesByTipo(tipo: TipoComponente): MutableList<ComponenteDieta> {
        TODO("Not yet implemented")
    }

    override fun readComponente(id: Int): ComponenteDieta? {
        TODO("Not yet implemented")
    }

    override fun readComponente(nombre: String): ComponenteDieta? {
        TODO("Not yet implemented")
    }

    override fun readComponenteByIngrediente() {
        TODO("Not yet implemented")
    }

    override fun updateComponente(componenteOld: ComponenteDieta, componenteNew: ComponenteDieta) {
        TODO("Not yet implemented")
    }

    override fun deleteComponente(componente: ComponenteDieta): Boolean {
        TODO("Not yet implemented")
    }

    override fun createIngrediente(padre: ComponenteDieta,hijo: ComponenteDieta, cantidad:Double) {
        val ing = Ingrediente(padre, hijo, cantidad)
        if (!padre.ingredientes.contains(ing)) {
            padre.ingredientes.add(ing)
        }
    }

    override fun readIngredienteByComponente(Componente: ComponenteDieta, nombreIngrediente: String): Ingrediente? {
        TODO("Not yet implemented")
    }

    override fun updateIngrediente(ingrediente: Ingrediente, cantidad: Double) {
        TODO("Not yet implemented")
    }

    override fun deleteIngredientebyComponente() {
        TODO("Not yet implemented")
    }


}