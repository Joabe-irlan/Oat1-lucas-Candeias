enum class StatusUsuario { ATIVO, INATIVO }

data class Usuario(
    val id: Int,
    var nome: String,
    var email: String,
    var status: StatusUsuario = StatusUsuario.ATIVO
)

data class Evento(
    val id: Int,
    var nome: String,
    var organizadorId: Int,
    var estaAtivo: Boolean = true
)
