package com.example.webshop.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, Long> {
   User findByLogin(String login);
   User findByEmail(String email);
}
