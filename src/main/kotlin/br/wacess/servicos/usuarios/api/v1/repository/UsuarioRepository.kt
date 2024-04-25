package br.wacess.servicos.usuarios.api.v1.repository

import br.wacess.servicos.usuarios.entidades.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UsuarioRepository : JpaRepository<Usuario, Int> {

    @Query("""
        SELECT a.usuario_id,
               a.nome,
               a.email,
               a.password_hash,
               a.status_id,
               b.descricao as descricao_status,
               a.nivel_id,
               c.descricao as descricao_nivel_usuario 
       FROM public.usuario  a
        left join usuario_status b on (b.status_id = a.status_id)
        left join usuario_nivel  c on (c.nivel_id = a.nivel_id)
       where a.email = ?1 
    """, nativeQuery = true)
    fun findByEmail(email: String) : Usuario

}