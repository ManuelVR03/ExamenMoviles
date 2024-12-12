package modelo

import modelo2.ComponenteDieta
import modelo2.Ingrediente

interface IServicio {

    fun CreateComponente(listaComponente:MutableList<ComponenteDieta>,componente:ComponenteDieta)
    fun readComponentes(): MutableList<ComponenteDieta>
    fun readComponentesByTipo(tipo: TipoComponente): MutableList<ComponenteDieta>
    fun readComponente(id:Int):ComponenteDieta?
    fun readComponente(nombre:String):ComponenteDieta?
    fun readComponenteByIngrediente()
    fun updateComponente(componenteOld:ComponenteDieta,componenteNew:ComponenteDieta)
    fun deleteComponente(componente:ComponenteDieta):Boolean

    fun createIngrediente(padre: ComponenteDieta, hijo: ComponenteDieta, cantidad: Double)

    fun readIngredienteByComponente(Componente:ComponenteDieta,nombreIngrediente:String):Ingrediente?
    fun updateIngrediente (ingrediente:Ingrediente, cantidad:Double)
    fun deleteIngredientebyComponente()

   }