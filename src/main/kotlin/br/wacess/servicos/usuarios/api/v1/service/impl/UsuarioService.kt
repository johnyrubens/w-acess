package br.wacess.servicos.usuarios.api.v1.service.impl

import br.wacess.servicos.usuarios.api.v1.repository.UsuarioRepository
import br.wacess.servicos.usuarios.api.v1.service.IUsuarioService
import br.wacess.servicos.usuarios.entidades.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioService (private val usuarioRepository : UsuarioRepository) : IUsuarioService {
    override fun findByEmail(email: String): Usuario {
        val resultUsuario = this.usuarioRepository.findByEmail(email)
        return resultUsuario
    }

    override fun save(usuario: Usuario) : Usuario {
        return this.usuarioRepository.save(usuario)
    }

}