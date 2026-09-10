import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

suspend fun consultarDisponibilidad() {
    println("Consultando disponibilidad...")
    delay(1000)
    println("Listo, ya se puede reservar")
}

fun main() = runBlocking {

    val mantenedor = MantenedorReservas()

    consultarDisponibilidad()

    val lista = listOf(
        ReservaAlojamiento(1, "Ana Perez", 3, 45000.0, 2, TipoAlojamiento.HABITACION),
        ReservaAlojamiento(2, "Juan Soto", 5, 60000.0, 4, TipoAlojamiento.CABANA),
        ReservaAlojamiento(3, "Marta Diaz", 2, 80000.0, 3, TipoAlojamiento.DEPARTAMENTO),
        ReservaAlojamiento(4, "", 2, 30000.0, 1, TipoAlojamiento.HABITACION),
        ReservaAlojamiento(1, "Pedro Rojas", 1, 20000.0, 1, TipoAlojamiento.CABANA)
    )

    for (r in lista) {
        try {
            println(mantenedor.registrar(r))
        } catch (e: Exception) {
            println("Error inesperado: ${e.message}")
        }
    }

    println("\nReservas registradas:")
    val registradas = mantenedor.obtenerReservas()

    for (r in registradas) {
        println("${r.identificador} - ${r.nombreCliente} - ${r.cantidadNoches} noches - valor por noche ${r.valorPorNoche} - total ${r.calcularTotal()}")
        println(r.describir())
    }

    val total = registradas.sumOf { it.calcularTotal() }
    println("\nTotal de todas las reservas: $total")

    val caras = registradas.filter { it.calcularTotal() > 100000 }
    println("\nReservas con total mayor a 100000:")
    for (r in caras) {
        println("${r.nombreCliente}: ${r.calcularTotal()}")
    }

    val reservaGeneral: Reserva = registradas[0]
    println("\nUsando la reserva como tipo Reserva: ${reservaGeneral.describir()}")
}
