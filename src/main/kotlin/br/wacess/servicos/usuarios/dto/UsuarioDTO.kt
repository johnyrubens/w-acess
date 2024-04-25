package br.wacess.servicos.usuarios.dto

import br.wacess.servicos.usuarios.entidades.Usuario
import br.wacess.servicos.usuarios.entidades.UsuarioNivel
import br.wacess.servicos.usuarios.entidades.UsuarioStatus
import jakarta.validation.constraints.NotEmpty

data class LoginRequest (
   val email: String,
   val password: String,
)

data class UsuarioDTO(
    @field:NotEmpty(message = "O Nome é obrigatória ser informado !")
    val nome: String,
    @field:NotEmpty(message = "A senha é obrigatória ser informado !")
    val passwordHash: String,
    @field:NotEmpty(message = "O e-mail é obrigatório ser informado !")
    val email: String,
    val status_id: Int?,
    val nivel_id: Int?
) {
    constructor(usuario: Usuario) : this(
        nome = usuario.nome,
        passwordHash = usuario.passwordHash,
        email = usuario.email,
        status_id = usuario.status.statusId,
        nivel_id = usuario.nivel.nivelId
    )
}

fun Usuario.toDTO(): UsuarioDTO {
    return UsuarioDTO(
        nome = this.nome,
        passwordHash = this.passwordHash,
        email = this.email,
        status_id = this.status.statusId,
        nivel_id = this.nivel.nivelId
    )
}

fun UsuarioDTO.toEntity(status: UsuarioStatus, nivel: UsuarioNivel): Usuario {
    return Usuario(
        nome = this.nome,
        passwordHash = this.passwordHash,
        email = this.email,
        status = status,
        nivel = nivel
    )
}

