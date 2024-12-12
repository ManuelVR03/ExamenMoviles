import modelo.ComponenteDieta
import java.io.*

class BD_Fichero (val nombre:String): Serializable {



    fun guardar(lista:MutableList<ComponenteDieta>) {
        try {
            ObjectOutputStream(FileOutputStream(nombre)).use { oos ->
                oos.writeObject(lista)
            }
        } catch (e: IOException) {
            println("Error al guardar: ${e.message}")
        }
    }

    fun leer(): MutableList<ComponenteDieta> {
       return try {
            ObjectInputStream(FileInputStream(nombre)).use { ois ->
                ois.readObject() as MutableList<ComponenteDieta>
            }
        } catch (e: FileNotFoundException) {
            println("Archivo no encontrado, devolviendo lista vacía")
            mutableListOf()
        } catch (e: IOException) {
            println("Error al leer el archivo: ${e.message}")
            mutableListOf()
        } catch (e: ClassNotFoundException) {
            println("Error de clase: ${e.message}")
            mutableListOf()
        }
    }

    fun borrarArchivo() {
        val archivo = File(nombre)
        if (archivo.exists()) {
            if (archivo.delete()) {
                println("Archivo eliminado correctamente")
            } else {
                println("No se pudo eliminar el archivo")
            }
        } else {
            println("El archivo no existe")
        }
    }


}