fun inativarUsuario() {
    val id = readInt("ID do usuário para INATIVAR: ", "ID inválido!")
    val usuario = Repositorio.buscarUsuarioPorId(id)
    if (usuario != null) {
        usuario.status = StatusUsuario.INATIVO
        println("✅ Usuário ${usuario.nome} agora está INATIVO.")
    } else {
        println("❌ Usuário não encontrado.")
    }
}

fun reativarUsuario() {
    val id = readInt("ID do usuário para REATIVAR: ", "ID inválido!")
    val usuario = Repositorio.buscarUsuarioPorId(id)
    if (usuario != null) {
        usuario.status = StatusUsuario.ATIVO
        println("✅ Usuário ${usuario.nome} agora está ATIVO.")
    } else {
        println("❌ Usuário não encontrado.")
    }
}

// Adicione aqui as outras funções (Cadastrar, Alterar, etc.) seguindo o mesmo padrão.
