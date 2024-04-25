package br.wacess.servicos.usuarios.dto

import br.wacess.servicos.usuarios.entidades.UsuarioStatus

data class UsuarioStatusDTO(
    val statusId: Int,
    val descricao: String
)

fun UsuarioStatus.toDTO(): UsuarioStatusDTO {
    return UsuarioStatusDTO(
        statusId = this.statusId,
        descricao = this.descricao
    )
}

fun UsuarioStatusDTO.toEntity(): UsuarioStatus {
    return UsuarioStatus(
        statusId = this.statusId,
        descricao = this.descricao
    )
}