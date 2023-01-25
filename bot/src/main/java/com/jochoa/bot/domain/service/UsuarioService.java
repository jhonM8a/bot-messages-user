package com.jochoa.bot.domain.service;

import com.jochoa.bot.domain.Usuario;
import com.jochoa.bot.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> getUsuario(Integer id){
        return usuarioRepository.getUser(id);
    }
}
