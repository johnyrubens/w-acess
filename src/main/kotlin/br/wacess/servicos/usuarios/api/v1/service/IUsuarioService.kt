package br.wacess.servicos.usuarios.api.v1.service

import br.wacess.servicos.usuarios.entidades.Usuario

interface IUsuarioService {
    fun findByEmail(email: String) : Usuario
    fun save(usuario: Usuario) : Usuario
}