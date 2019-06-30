package ru.kirillch.mockito.services;

import ru.kirillch.mockito.dao.UserDao;
import ru.kirillch.mockito.model.User;

public class UserService {

    private UserDao dao;

    public UserService(UserDao dao) {
        this.dao = dao;
    }

    public boolean checkUserPresence(User user) throws Exception {
        User u = dao.getUserByUsername(user.getUsername());

        return u != null;
    }

}
