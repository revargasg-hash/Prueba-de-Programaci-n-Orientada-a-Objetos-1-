class MantenedorReservas {

    private val reservas = mutableListOf<ReservaAlojamiento>()


    fun registrar(reserva: ReservaAlojamiento): String {

        if (reserva.identificador <= 0) {
            return "Error: El ID debe ser mayor que 0"
        }

        if (reserva.nombreCliente.isBlank()) {
            return "Error: El nombre no puede estar vacío"
        }

        if (reserva.cantidadNoches <= 0) {
            return "Error: Las noches deben ser mayores que 0"
        }

        if (reserva.valorPorNoche <= 0) {
            return "Error: El valor debe ser mayor que 0"
        }

        if (reserva.cantidadPersonas <= 0) {
            return "Error: La cantidad de personas debe ser mayor que 0"
        }


        if (reservas.any { it.identificador == reserva.identificador }) {
            return "Error: Ya existe una reserva con ese ID"
        }


        reservas.add(reserva)

        return "Reserva registrada correctamente"
    }


    fun obtenerReservas(): List<ReservaAlojamiento> {

        return reservas.toList()
    }
}
