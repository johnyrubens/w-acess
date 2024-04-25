package br.wacess.servicos.usuarios.entidades

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "usuario_nivel", schema = "public")
data class UsuarioNivel(
    @Id
    @Column(name = "nivel_id")
    val nivelId: Int,

    @Column(name = "descricao", length = 50, nullable = false)
    val descricao: String
)
