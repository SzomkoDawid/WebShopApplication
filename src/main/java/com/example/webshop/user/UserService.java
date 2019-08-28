package com.example.webshop.user;
import java.util.List;

public interface UserService {
    List<User> findAll();
    User findByLogin(String login);
    User findByEmail(String email);
    void saveUser(User user);
}
