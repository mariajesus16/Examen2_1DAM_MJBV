import kotlin.math.sqrt
import kotlin.math.pow

class Punto(var idPunto: String) {
    var x: Int = 0
    var y: Int = 0

    constructor(idPunto: String, x: Int, y: Int) : this(idPunto) {
        this.x = x
        this.y = y
    }

    fun obtenerCoordenadas() = Pair(x, y) //Devuelve coordenadas del punto.

    override fun toString(): String {
        return "punto $idPunto -> [$x,$y]"
    }

    companion object {
        //Resta entre dos puntos.
        fun componenteDeVector(punto1: Punto, punto2: Punto): Punto =
            Punto((punto1.idPunto) + (punto2.idPunto), (punto2.x - punto1.x), (punto2.y - punto1.y))

        //Diferencia entre dos puntos.
        fun distancia(punto1: Punto, punto2: Punto): Double =
            sqrt((punto2.x - punto1.x).toDouble().pow(2) + (punto2.y - punto1.y).toDouble().pow(2))

        //Clasificación geográfica de dos puntos.
        fun localizacionGeograficaNS(puntos: Array<Punto>): Map<String, List<Punto>> {
            val norte = puntos.filter { it.y >= 0 }
            val sur = puntos.filter { it.y < 0 }
            val map: Map<String, List<Punto>> = mapOf("Norte" to norte, "Sur" to sur)
            return map
        }
    }
}

fun main() {
    //Programa 1
    val puntoA = Punto("pA", 3, 2)
    val puntoB = Punto("pB", 1, 3)
    println(Punto.componenteDeVector(puntoA, puntoB))

    //Programa 2
    val punto1 = Punto("p1", -1, 0)
    val punto2 = Punto("p2", 3, -1)
    val punto3 = Punto("p3", -4, 4)
    val punto4 = Punto("p4", -3, 2)
    val punto5 = Punto("p5", 6, -4)
    val punto6 = Punto("p6", -5, 6)
    val punto7 = Punto("p7", 10, -8)
    val punto8 = Punto("p8", 1, 5)
    val punto9 = Punto("p9", 6, -7)
    val puntos = arrayOf(punto1, punto2, punto3, punto4, punto5, punto6, punto7, punto8, punto9)
    println(puntos.contentToString())
    println(Punto.localizacionGeograficaNS(puntos))
}