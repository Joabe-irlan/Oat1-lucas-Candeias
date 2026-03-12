fun main() {
    while (true) {
        println("\n--- DENDE EVENTOS (MARSELHA) ---")
        println("1. Inativar Usuário")
        println("2. Reativar Usuário")
        println("3. Listar Usuários")
        println("0. Sair")
        
        val opcao = readInt("Escolha: ", "Opção inválida!", 0..3)
        
        when (opcao) {
            1 -> inativarUsuario()
            2 -> reativarUsuario()
            3 -> printTable("TODOS OS USUARIOS", Repositorio.usuarios)
            0 -> {
                println("Encerrando...")
                break
            }
        }
    }
}
