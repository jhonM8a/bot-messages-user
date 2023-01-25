package com.jochoa.bot.persistence.mapper;

import com.jochoa.bot.domain.Usuario;
import com.jochoa.bot.persistence.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "nombre"),
            @Mapping(source = "lastname", target = "apellido"),
            @Mapping(source = "celphone", target = "celular"),
            @Mapping(source = "nickname", target = "apodo"),
            @Mapping(source = "mail", target = "correo")

    })
    Usuario toUsuario(User user);

    @InheritInverseConfiguration
    User toUser(Usuario usuario);
}
