package br.wacess.servicos.usuarios.dto

import br.wacess.servicos.usuarios.entidades.UsuarioNivel

data class UsuarioNivelDTO(
    val nivelId: Int,
    val descricao: String
)

fun UsuarioNivel.toDTO(): UsuarioNivelDTO {
    return UsuarioNivelDTO(
        nivelId = this.nivelId,
        descricao = this.descricao
    )
}

fun UsuarioNivelDTO.toEntity(): UsuarioNivel {
    return UsuarioNivel(
        nivelId = this.nivelId,
        descricao = this.descricao
    )
}

