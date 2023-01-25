package com.jochoa.bot.persistence.crud;

import com.jochoa.bot.persistence.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<User, Integer> {
}
