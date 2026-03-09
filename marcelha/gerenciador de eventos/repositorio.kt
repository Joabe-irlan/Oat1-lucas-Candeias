object Repositorio {
    val usuarios = mutableListOf<Usuario>()
    val eventos = mutableListOf<Evento>()

    fun salvarUsuario(usuario: Usuario) = usuarios.add(usuario)
    
    fun buscarUsuarioPorId(id: Int) = usuarios.find { it.id == id }

    fun listarAtivos() = usuarios.filter { it.status == StatusUsuario.ATIVO }
    
    fun excluirUsuario(id: Int) = usuarios.removeIf { it.id == id }
}
