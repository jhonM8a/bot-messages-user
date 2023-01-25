package com.jochoa.bot.persistence;

import com.jochoa.bot.domain.Usuario;
import com.jochoa.bot.domain.repository.UsuarioRepository;
import com.jochoa.bot.persistence.crud.UserCrudRepository;
import com.jochoa.bot.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;

    @Autowired(required=true)
    private UserMapper mapper;

    @Override
    public Optional<Usuario> getUser(int idUser) {
        System.out.println("IdUser: "+idUser);
        return userCrudRepository.findById(idUser).map(user -> mapper.toUsuario(user));
    }
}
