package br.wacess.servicos.usuarios.entidades

import jakarta.persistence.*

@Entity
@Table(name = "usuario")
data class Usuario(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    val usuarioId: Int = 0,

    @Column(name = "nome", length = 50, nullable = false)
    val nome: String = "",

    @Column(name = "password_hash", length = 100, nullable = false)
    val passwordHash: String = "",

    @Column(name = "email", length = 100, nullable = false)
    val email: String = "",

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id", nullable = false)
    val status: UsuarioStatus,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nivel_id", nullable = false)
    val nivel: UsuarioNivel
)
