// Kotlin Playground: https://pl.kotl.in/gvS2sqowJ

enum class Nivel { BÁSICO, INTERMEDIÁRIO, AVANÇADO }

data class Usuario(val nome: String, val email: String, val id: Int, val curso: Nivel){
    override fun toString(): String{
        return "Usuario: $nome, email: $email, id: $id, curso: $curso"
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    fun adicionarUsuario(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun consultarUsuario(id: Int): Usuario? {
        return inscritos.find { it.id == id }
    }

    fun removerUsuario(id: Int) {
        inscritos.removeIf { it.id == id }
    }
}

fun main() {
    val formacao = Formacao("Desafio DIO", listOf(
        ConteudoEducacional("Basico", 40),
        ConteudoEducacional("Intermediario", 90),
        ConteudoEducacional("Avançado", 120)))

    // add usuario
    formacao.adicionarUsuario(Usuario("João Silva", "joao@email.com", 1, Nivel.BÁSICO))
    formacao.adicionarUsuario(Usuario("Maria Oliveira", "maria@email.com", 2, Nivel.INTERMEDIÁRIO))
    formacao.adicionarUsuario(Usuario("Carlos Sousa", "carlos@email.com", 3, Nivel.AVANÇADO))

    // Consulta de usuario
    val usuario1 = formacao.consultarUsuario(1)
    val usuario2 = formacao.consultarUsuario(2)
    val usuario3 = formacao.consultarUsuario(3)
    println("$usuario1")
    println("$usuario2")
    println("$usuario3")

    // remover usuario
    formacao.removerUsuario(2)
    println("Usuários inscritos após remoção: ${formacao.inscritos}")
}
