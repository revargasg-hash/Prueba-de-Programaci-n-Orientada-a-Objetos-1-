enum class TipoAlojamiento {
    HABITACION,
    CABANA,
    DEPARTAMENTO;

    fun descripcion(): String {
        return when (this) {
            HABITACION -> "Habitacion"
            CABANA -> "Cabaña"
            DEPARTAMENTO -> "Departamento"
        }
    }
}
