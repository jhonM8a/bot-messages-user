package com.jochoa.bot.persistence;

import com.jochoa.bot.domain.Usuario;
import com.jochoa.bot.domain.repository.UsuarioRepository;
import com.jochoa.bot.persistence.crud.UserCrudRepository;
import com.jochoa.bot.persistence.entity.User;
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
        return userCrudRepository.findById(idUser).map(user -> mapper.toUsuario(user));
    }

    @Override
    public Optional<Usuario> updateUsuer(Usuario usuario) {
        if(this.getUser(usuario.getId()).isPresent()){
            User user = mapper.toUser(usuario);
            return Optional.of(mapper.toUsuario(userCrudRepository.save(user)));
        }else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Usuario> saveUsuario(Usuario usuario) {
        User user = mapper.toUser(usuario);
        return Optional.of(mapper.toUsuario(userCrudRepository.save(user)));

    }

    @Override
    public void deleteUsuario(Integer userId) {
        userCrudRepository.deleteById(userId);
    }
}
