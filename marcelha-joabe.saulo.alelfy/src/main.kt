import java.util.Scanner

fun main() {

    val scanner = Scanner(System.`in`)

    val usuarios = mutableListOf<Usuario>()
    val eventos = mutableListOf<Evento>()

    var opcao = -1

    while (opcao != 0) {

        println("\n===== DENDÊ EVENTOS =====")
        println("1 - Cadastrar usuário comum")
        println("2 - Cadastrar organizador")
        println("3 - Visualizar usuários")
        println("4 - Cadastrar evento")
        println("5 - Listar eventos")
        println("6 - Feed de eventos")
        println("0 - Sair")

        print("Escolha: ")
        opcao = scanner.nextInt()
        scanner.nextLine()

        when (opcao) {

            1 -> {
                println("\nCadastro de usuário comum")

                print("Nome: ")
                val nome = scanner.nextLine()

                print("Data de nascimento: ")
                val data = scanner.nextLine()

                print("Sexo: ")
                val sexo = scanner.nextLine()

                print("Email: ")
                val email = scanner.nextLine()

                print("Senha: ")
                val senha = scanner.nextLine()

                var emailExiste = false

                for (u in usuarios) {
                    if (u.email == email) {
                        emailExiste = true
                    }
                }

                if (emailExiste) {
                    println("Email já cadastrado.")
                } else {

                    val usuario = Usuario(
                        nome,
                        data,
                        sexo,
                        email,
                        senha,
                        true,
                        false
                    )

                    usuarios.add(usuario)

                    println("Usuário cadastrado com sucesso.")
                }
            }

            2 -> {
                println("\nCadastro de organizador")

                print("Nome: ")
                val nome = scanner.nextLine()

                print("Data de nascimento: ")
                val data = scanner.nextLine()

                print("Sexo: ")
                val sexo = scanner.nextLine()

                print("Email: ")
                val email = scanner.nextLine()

                print("Senha: ")
                val senha = scanner.nextLine()

                val usuario = Usuario(
                    nome,
                    data,
                    sexo,
                    email,
                    senha,
                    true,
                    true
                )

                usuarios.add(usuario)

                println("Organizador cadastrado.")
            }

            3 -> {

                println("\nLista de usuários")

                for (u in usuarios) {
                    println("Nome: ${u.nome}")
                    println("Email: ${u.email}")
                    println("Organizador: ${u.organizador}")
                    println("Ativo: ${u.ativo}")
                    println("--------------------")
                }

            }

            4 -> {

                println("\nCadastro de evento")

                print("Email do organizador: ")
                val emailOrg = scanner.nextLine()

                var organizadorExiste = false

                for (u in usuarios) {
                    if (u.email == emailOrg && u.organizador) {
                        organizadorExiste = true
                    }
                }

                if (!organizadorExiste) {
                    println("Organizador não encontrado.")
                } else {

                    print("Nome do evento: ")
                    val nome = scanner.nextLine()

                    print("Descrição: ")
                    val descricao = scanner.nextLine()

                    print("Data início: ")
                    val inicio = scanner.nextLine()

                    print("Data fim: ")
                    val fim = scanner.nextLine()

                    println("Tipo do evento:")
                    val tipos = TipoEvento.values()
                    for (i in tipos.indices) {
                        println("$i - ${tipos[i]}")
                    }

                    val tipoEscolhido = scanner.nextInt()
                    scanner.nextLine()

                    val tipo = tipos[tipoEscolhido]

                    println("Modalidade:")
                    val modalidades = ModalidadeEvento.values()
                    for (i in modalidades.indices) {
                        println("$i - ${modalidades[i]}")
                    }

                    val modEscolhida = scanner.nextInt()
                    scanner.nextLine()

                    val modalidade = modalidades[modEscolhida]

                    print("Capacidade: ")
                    val capacidade = scanner.nextInt()
                    scanner.nextLine()

                    print("Local: ")
                    val local = scanner.nextLine()

                    print("Preço do ingresso: ")
                    val preco = scanner.nextDouble()
                    scanner.nextLine()

                    val evento = Evento(
                        nome,
                        descricao,
                        inicio,
                        fim,
                        tipo,
                        modalidade,
                        capacidade,
                        local,
                        false,
                        preco,
                        emailOrg
                    )

                    eventos.add(evento)

                    println("Evento cadastrado com sucesso (inativo).")
                }
            }

            5 -> {

                println("\nLista de eventos")

                for (e in eventos) {
                    println("Nome: ${e.nome}")
                    println("Descrição: ${e.descricao}")
                    println("Início: ${e.inicio}")
                    println("Local: ${e.local}")
                    println("Preço: ${e.preco}")
                    println("Ativo: ${e.ativo}")
                    println("-------------------")
                }

            }

            6 -> {

                println("\nFeed de eventos ativos")

                for (e in eventos) {

                    if (e.ativo) {

                        println("Evento: ${e.nome}")
                        println("Início: ${e.inicio}")
                        println("Local: ${e.local}")
                        println("Preço: ${e.preco}")
                        println("------------------")
                    }

                }

            }

            0 -> {
                println("Encerrando sistema...")
            }

            else -> {
                println("Opção inválida.")
            }

        }

    }

}