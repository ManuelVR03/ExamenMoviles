package modelo

class DaoCD (var lista:MutableList<ComponenteDieta>):IDaoCD {



    override fun addListaCD(lista: MutableList<ComponenteDieta>) {
        this.lista=lista
    }


    override fun CreateComponente(componente: ComponenteDieta) {
        lista.add(componente)

    }

    override fun readComponentes(): MutableList<ComponenteDieta> {
       return lista
    }

    override fun readComponentesByTipo(tipo: TipoComponente): MutableList<ComponenteDieta> {
        return lista.filter { it.tipo==tipo } as MutableList<ComponenteDieta>
    }

    override fun readComponente(id: Int): ComponenteDieta? {
        TODO("Not yet implemented")
    }

    override fun readComponente(nombre: String): ComponenteDieta? {
        return lista.find { it.nombre==nombre }
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


}