package com.jochoa.bot.domain.repository;

import com.jochoa.bot.domain.Usuario;

import java.util.Optional;

public interface UsuarioRepository {
    Optional<Usuario> getUser(int idUser);

    Optional<Usuario> updateUsuer(Usuario usuario);

    Optional<Usuario> saveUsuario(Usuario usuario);

    void deleteUsuario(Integer userId);
}
