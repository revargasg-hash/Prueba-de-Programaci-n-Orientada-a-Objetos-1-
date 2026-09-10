open class Reserva(
    val id: Int,
    val cliente: String,
    val noches: Int
) {

    open fun describir(): String {

        return "Reserva de $cliente por $noches noches"
    }
}
