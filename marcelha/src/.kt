import java.util.*
// Dende Eventos - Sistema de gerenciamento de eventos
data class Usuario(
    var nome: String,
    var dataNascimento: String,
    var sexo: String,
    var email: String,
    var senha: String,
    var ativo: Boolean,
    var organizador: Boolean
)

// Tipo de evento: social, corporativo, academico, cultural, religioso, esportivo, feira, congresso, oficina, curso, treinamento, aula, seminário, palestra, show, festival, exposição, retiro, culto, celebração, campeonato, corrida
data class Evento(
    var nome: String,
    var descricao: String,
    var inicio: String,
    var fim: String,
    var tipo: TipoEvento,
    var modalidade: ModalidadeEvento,
    var capacidade: Int,
    var local: String,
    var ativo: Boolean,
    var preco: Double,
    var organizadorEmail: String
)

// Tipos de eventos
enum class TipoEvento {
    SOCIAL,
    CORPORATIVO,
    ACADEMICO,
    CULTURAL,
    RELIGIOSO,
    ESPORTIVO,
    FEIRA,
    CONGRESSO,
    OFICINA,
    CURSO,
    TREINAMENTO,
    AULA,
    SEMINARIO,
    PALESTRA,
    SHOW,
    FESTIVAL,
    EXPOSICAO,
    RETIRO,
    CULTO,
    CELEBRACAO,
    CAMPEONATO,
    CORRIDA
}

// Modalidade do evento: presencial, remoto, híbrido
enum class ModalidadeEvento {
    PRESENCIAL,
    REMOTO,
    HIBRIDO
}

// Sistema de gerenciamento de eventos