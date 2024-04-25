package br.wood.wacess.view

import br.wacess.servicos.usuarios.entidades.Usuario

data class UsuarioView(
    val usuarioId: Int,
    val nome: String,
    val email: String,
    val status: String,
    val nivel: String
) {
    constructor(usuario: Usuario) : this(
        usuarioId = usuario.usuarioId,
        nome = usuario.nome,
        email = usuario.email,
        status = usuario.status.descricao,
        nivel = usuario.nivel.descricao
    )
}

fun Usuario.toView() : UsuarioView {
    return UsuarioView(
        usuarioId = this.usuarioId,
        nome = this.nome,
        email = this.email,
        status = this.status.descricao,
        nivel = this.nivel.descricao
    )
}

fun List<Usuario>.toViewList() = map { it.toView() }