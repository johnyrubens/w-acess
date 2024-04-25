package br.wacess.servicos.usuarios.api.v1.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1")
class AcessoController {

    @GetMapping("/login")
    fun login() : String {
        return  "redirect:/home"
    }
}