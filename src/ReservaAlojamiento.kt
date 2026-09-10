data class ReservaAlojamiento(
    val identificador: Int,
    val nombreCliente: String,
    val cantidadNoches: Int,
    val valorPorNoche: Double,
    val cantidadPersonas: Int,
    val tipo: TipoAlojamiento

) : Reserva(
    identificador,
    nombreCliente,
    cantidadNoches
) {

    override fun describir(): String {

        var descripcion = super.describir()

        descripcion += "\nTipo de alojamiento: ${tipo.descripcion()}"
        descripcion += "\nCantidad de personas: $cantidadPersonas"

        return descripcion
    }


    fun calcularTotal(): Double {

        return valorPorNoche * cantidadNoches
    }
}
