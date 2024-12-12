import modelo.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("Bd alimentos" )
    var listaCD:MutableList<ComponenteDieta> = mutableListOf()
    val conexion=BD_Fichero("alimentos")


    val daoCD: IDaoCD = DaoCD(listaCD)
    val daoIng:IDaoIngrediente=DaoIngrediente()


    //prueba1(daoCD, daoIng);
    //conexion.guardar(listaCD)
    //println("guardado")


    listaCD=conexion.leer()
    daoCD.addListaCD(listaCD)


    mostrar(daoCD)

}

//Esto sería más una función de servicio
fun mostrar(daoCD:IDaoCD) {
    daoCD.readComponentes().groupBy { it.tipo }.forEach { (tipo,cd ) ->
        println("Tipo: $tipo")
        cd.forEach { println("${it.nombre}: Kcal=${it.Kcal}, HC=${it.grHC}, Lip=${it.grLip}, Pro=${it.grPro}") }
    }
}

fun prueba1(daoCD:IDaoCD, daoIng:IDaoIngrediente) {
        val listaCD=daoCD.readComponentes()

        // Crear alimentos básicos con datos reales
        var mollete = ComponenteDieta("Mollete", TipoComponente.SIMPLE, 46.5, 1.1, 8.5)
        daoCD.CreateComponente(mollete)


        var aceite = ComponenteDieta("Aceite de Oliva", TipoComponente.SIMPLE, 0.0, 100.0, 0.0)
        daoCD.CreateComponente(aceite)

        var tomate = ComponenteDieta("Tomate", TipoComponente.SIMPLE, 3.9, 0.2, 1.0)
        listaCD.add(tomate)

        var lecheSemi = ComponenteDieta("Leche Semidesnatada", TipoComponente.SIMPLE, 5.0, 1.5, 3.2)
        listaCD.add(lecheSemi)

        var huevo = ComponenteDieta("Huevo", TipoComponente.SIMPLE, 1.0, 11.0, 13.0)
        listaCD.add(huevo)

        var harina = ComponenteDieta("Harina", TipoComponente.SIMPLE, 70.0, 1.0, 10.0)
        listaCD.add(harina)

        var nata = ComponenteDieta("Nata", TipoComponente.SIMPLE, 3.0, 30.0, 2.0)
        listaCD.add(nata)

        var sirope = ComponenteDieta("Sirope", TipoComponente.SIMPLE, 65.0, 0.0, 0.0)
        listaCD.add(sirope)

        var pan = ComponenteDieta("Pan", TipoComponente.SIMPLE, 50.0, 1.0, 7.0)
        listaCD.add(pan)

        var lomo = ComponenteDieta("Lomo", TipoComponente.SIMPLE, 0.0, 7.0, 23.0)
        listaCD.add(lomo)

        var patatas_fritas = ComponenteDieta("Patatas Fritas", TipoComponente.SIMPLE, 50.0, 35.0, 5.0)
        listaCD.add(patatas_fritas)

        var fabada = ComponenteDieta("Fabada", TipoComponente.PROCESADO, 12.0, 15.0, 10.0)
        listaCD.add(fabada)

        // Crear tres recetas
        var mollete_andaluz = ComponenteDieta("Mollete Andaluz", TipoComponente.RECETA)
        listaCD.add(mollete_andaluz) //Desde dentro
        daoIng.createIngrediente(mollete_andaluz,mollete, 50.0) //fuera


        mollete_andaluz.addIngrediente(Ingrediente(mollete, 50.0))
        mollete_andaluz.addIngrediente(Ingrediente(aceite, 20.0))
        mollete_andaluz.addIngrediente(Ingrediente(tomate, 30.0))



        var tortitas = ComponenteDieta("Tortitas", TipoComponente.RECETA)
        listaCD.add(tortitas)
        tortitas.addIngrediente(Ingrediente(harina, 50.0))
        tortitas.addIngrediente(Ingrediente(huevo, 50.0))

        var bocadillo_lomo = ComponenteDieta("Bocadillo de Lomo", TipoComponente.RECETA)
        bocadillo_lomo.addIngrediente(Ingrediente( pan, 60.0))
        bocadillo_lomo.addIngrediente(Ingrediente(lomo, 40.0))
        listaCD.add(bocadillo_lomo)

        // Crear menús
        var menu_desayuno = ComponenteDieta("Menú Desayuno", TipoComponente.MENU)
        menu_desayuno.addIngrediente(Ingrediente( mollete_andaluz, 100.0))
        menu_desayuno.addIngrediente(Ingrediente(lecheSemi, 200.0))
        listaCD.add(menu_desayuno)

        var menu_almuerzo = ComponenteDieta("Menú Almuerzo",  TipoComponente.MENU)
        menu_almuerzo.addIngrediente(Ingrediente(fabada, 300.0))
        menu_almuerzo.addIngrediente(Ingrediente( pan, 200.0))
        listaCD.add(menu_almuerzo)

        var menu_merienda = ComponenteDieta("Menú Merienda",  TipoComponente.MENU)
        menu_merienda.addIngrediente(Ingrediente(tortitas, 100.0))
        menu_merienda.addIngrediente(Ingrediente(lecheSemi, 200.0))
        menu_merienda.addIngrediente(Ingrediente(nata, 30.0))
        menu_merienda.addIngrediente(Ingrediente(sirope, 20.0))
        listaCD.add(menu_merienda)

        var menu_cena = ComponenteDieta("Menú Cena", TipoComponente.MENU)
        menu_cena.addIngrediente(Ingrediente( bocadillo_lomo, 100.0))
        menu_cena.addIngrediente(Ingrediente(patatas_fritas, 100.0))
        listaCD.add(menu_cena)


        // Crear una dieta
        var dieta_lunes = ComponenteDieta("Dieta Lunes", TipoComponente.DIETA)
        dieta_lunes.addIngrediente(Ingrediente(menu_desayuno, 100.0))
        dieta_lunes.addIngrediente(Ingrediente(menu_almuerzo, 100.0))
        dieta_lunes.addIngrediente(Ingrediente(menu_merienda, 100.0))
        dieta_lunes.addIngrediente(Ingrediente(menu_cena, 100.0))
        listaCD.add(dieta_lunes)

        // Añadir un ingrediente en una receta
        var mayonesa = ComponenteDieta("Mayonesa", TipoComponente.SIMPLE, 0.0, 80.0, 1.0)
        bocadillo_lomo.addIngrediente(Ingrediente( mayonesa, 10.0))

        var azucar = ComponenteDieta("Azúcar", TipoComponente.SIMPLE, 100.0, 0.0, 0.0)
        menu_desayuno.addIngrediente(Ingrediente( azucar, 5.0))
        /*
                     // Eliminar un alimento de un menú
                     menu_almuerzo.removeIngrediente(Ingrediente(menu_almuerzo, fabada, 300.0))
        
                     // Modificar cantidad en un ingrediente
                     mollete_andaluz.ingredientes.forEach {
                         if (it.alimentoHijo == mollete) it.cantidad = 25.0
                     }
        
                     // Modificar un valor simple en un alimento
                     //lomo.grPro += 5.0
                    // lomo.backUpdate()
        */

    }

