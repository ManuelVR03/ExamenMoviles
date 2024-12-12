import modelo.TipoComponente
import modelo2.*



fun main() {


    prueba1()
}
fun prueba1() {
    // Crear alimentos básicos con datos reales
    var mollete = ComponenteDieta("Mollete", "simple", 46.5, 1.1, 8.5)
    var aceite = ComponenteDieta("Aceite de Oliva", "simple", 0.0, 100.0, 0.0)
    var tomate = ComponenteDieta("Tomate", "simple", 3.9, 0.2, 1.0)
    var lecheSemi = ComponenteDieta("Leche Semidesnatada", "simple", 5.0, 1.5, 3.2)
    var huevo = ComponenteDieta("Huevo", "simple", 1.0, 11.0, 13.0)
    var harina = ComponenteDieta("Harina", "simple", 70.0, 1.0, 10.0)
    var nata = ComponenteDieta("Nata", "simple", 3.0, 30.0, 2.0)
    var sirope = ComponenteDieta("Sirope", "simple", 65.0, 0.0, 0.0)
    var pan = ComponenteDieta("Pan", "simple", 50.0, 1.0, 7.0)
    var lomo = ComponenteDieta("Lomo", "simple", 0.0, 7.0, 23.0)
    var patatas_fritas = ComponenteDieta("Patatas Fritas", "simple", 50.0, 35.0, 5.0)
    var fabada = ComponenteDieta("Fabada", "procesado", 12.0, 15.0, 10.0)

    // Crear tres recetas
    var mollete_andaluz = ComponenteDieta("Mollete Andaluz", "compuesto")
    mollete_andaluz.addIngrediente(Ingrediente(mollete_andaluz, mollete, 50.0))
    mollete_andaluz.addIngrediente(Ingrediente(mollete_andaluz, aceite, 20.0))
    mollete_andaluz.addIngrediente(Ingrediente(mollete_andaluz, tomate, 30.0))

    var tortitas = ComponenteDieta("Tortitas", "compuesto")
    tortitas.addIngrediente(Ingrediente(tortitas, harina, 50.0))
    tortitas.addIngrediente(Ingrediente(tortitas,huevo, 50.0))

    var bocadillo_lomo = ComponenteDieta("Bocadillo de Lomo", "compuesto")
    bocadillo_lomo.addIngrediente(Ingrediente(bocadillo_lomo, pan, 60.0))
    bocadillo_lomo.addIngrediente(Ingrediente(bocadillo_lomo, lomo, 40.0))

        // Crear menús
        var menu_desayuno = ComponenteDieta("Menú Desayuno", "compuesto")
        menu_desayuno.addIngrediente(Ingrediente(menu_desayuno, mollete_andaluz, 100.0))
        menu_desayuno.addIngrediente(Ingrediente(menu_desayuno, lecheSemi, 200.0))

        var menu_almuerzo = ComponenteDieta("Menú Almuerzo", "compuesto")
        menu_almuerzo.addIngrediente(Ingrediente(menu_almuerzo, fabada, 300.0))
        menu_almuerzo.addIngrediente(Ingrediente(menu_almuerzo, pan, 200.0))

        var menu_merienda = ComponenteDieta("Menú Merienda", "compuesto")
        menu_merienda.addIngrediente(Ingrediente(menu_merienda, tortitas, 100.0))
        menu_merienda.addIngrediente(Ingrediente(menu_merienda, lecheSemi, 200.0))
        menu_merienda.addIngrediente(Ingrediente(tortitas, nata, 30.0))
        menu_merienda.addIngrediente(Ingrediente(tortitas, sirope, 20.0))

         var menu_cena = ComponenteDieta("Menú Cena", "compuesto")
         menu_cena.addIngrediente(Ingrediente(menu_almuerzo, bocadillo_lomo, 100.0))
         menu_cena.addIngrediente(Ingrediente(menu_almuerzo, patatas_fritas, 100.0))


             // Crear una dieta
             var dieta_lunes = ComponenteDieta("Dieta Lunes", "compuesto")
             dieta_lunes.addIngrediente(Ingrediente(dieta_lunes, menu_desayuno, 100.0))
             dieta_lunes.addIngrediente(Ingrediente(dieta_lunes, menu_almuerzo, 100.0))
             dieta_lunes.addIngrediente(Ingrediente(dieta_lunes, menu_merienda, 100.0))
             dieta_lunes.addIngrediente(Ingrediente(dieta_lunes, menu_cena, 100.0))

             // Añadir un ingrediente en una receta
             var mayonesa = ComponenteDieta("Mayonesa", "simple", 0.0, 80.0, 1.0)
             bocadillo_lomo.addIngrediente(Ingrediente(bocadillo_lomo, mayonesa, 10.0))

             var azucar = ComponenteDieta("Azúcar", "simple", 100.0, 0.0, 0.0)
             menu_desayuno.addIngrediente(Ingrediente(menu_desayuno, azucar, 5.0))
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
    // Ver los resultados finales filtrados por tipos
    val tipos = listOf(
        mollete, aceite, tomate, lecheSemi, huevo, harina, nata, sirope, pan, lomo, patatas_fritas, fabada,
        mollete_andaluz, tortitas, bocadillo_lomo  , menu_desayuno, menu_almuerzo, menu_merienda,  menu_cena ,dieta_lunes
    )
    tipos.groupBy { it.tipo }.forEach { (tipo, alimentos) ->
        println("Tipo: $tipo")
        alimentos.forEach { println("${it.nombre}: Kcal=${it.Kcal}, HC=${it.grHC}, Lip=${it.grLip}, Pro=${it.grPro}") }
    }
}

