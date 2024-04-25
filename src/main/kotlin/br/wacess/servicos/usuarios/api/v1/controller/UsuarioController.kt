package br.wacess.servicos.usuarios.api.v1.controller

import br.wacess.servicos.usuarios.api.v1.repository.UsuarioRepository
import br.wacess.servicos.usuarios.api.v1.service.impl.UsuarioService
import br.wacess.servicos.usuarios.dto.LoginRequest
import br.wacess.servicos.usuarios.dto.UsuarioDTO
import br.wacess.servicos.usuarios.dto.toEntity
import br.wacess.servicos.usuarios.entidades.Usuario
import br.wacess.servicos.usuarios.entidades.UsuarioNivel
import br.wacess.servicos.usuarios.entidades.UsuarioStatus
import br.wood.wacess.view.UsuarioView
import br.wood.wacess.view.toViewList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/usuario")
class UsuarioController(private val usuarioService: UsuarioService) {
    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    @Autowired
    private lateinit var usuarioRepository: UsuarioRepository

    @PostMapping("/login")
    fun login(@RequestBody payload: LoginRequest): String {
        val usuario = usuarioRepository.findByEmail(payload.email)
        return if (passwordEncoder.matches(payload.password, usuario.passwordHash)) {
            // Autenticação bem-sucedida
            "redirect:/home"
        } else {
            // Autenticação falhou
            "redirect:/login?error"
        }
    }

    @GetMapping
    @ResponseBody
    fun getUsuario(@RequestParam email: String) : Usuario {
        return usuarioRepository.findByEmail(email)
    }

    @GetMapping("/lista")
    @ResponseBody
    fun getListaUsuario() : List<UsuarioView> {
        val result = usuarioRepository.findAll()
        return result.toViewList()
    }

    @GetMapping("{id}")
    @ResponseBody
    fun getListaUsuarioId(@PathVariable id: Int) : Optional<Usuario> {
        return usuarioRepository.findById(id)
    }

    @PostMapping
    @ResponseBody
    fun insertUsuario(@RequestBody payload: UsuarioDTO) : ResponseEntity<String> {
        val payloadUsuario = payload.copy(passwordHash = passwordEncoder.encode(payload.passwordHash))
        val usuario = this.usuarioService.save(payloadUsuario.toEntity(UsuarioStatus(2, ""), UsuarioNivel(2, "")))
        return ResponseEntity.ok("Usuário ${usuario.nome} cadastrado com sucesso !")
    }

}