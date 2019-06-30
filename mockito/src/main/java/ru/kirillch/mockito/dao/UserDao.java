package ru.kirillch.mockito.dao;

import ru.kirillch.mockito.model.User;

import java.util.List;

public interface UserDao {

    User getUserByUsername(String username) throws Exception;

    List<User> findAllUsers();
}
