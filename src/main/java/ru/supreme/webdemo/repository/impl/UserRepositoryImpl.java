package ru.supreme.webdemo.repository.impl;

import org.springframework.stereotype.Repository;
import ru.supreme.webdemo.model.User;
import ru.supreme.webdemo.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private List<User> users = new ArrayList<>();
//
//    CREATE TABLE User (
//    id int NOT NULL AUTO_INCREMENT,
//    username varchar(50) NOT NULL,
//    password varchar(50) NOT NULL,
//    PRIMARY KEY(id)
//    );
//
//    INSERT INTO User (username, password) VALUES


    public UserRepositoryImpl() {
        users.add(new User(1L, "Egorka", "2302"));
        users.add(new User(2L, "Sashka", "2009"));
    }

    @Override
    public User findByUsername(String username) {
        for (User foundUser : users) {
            if (foundUser.getUsername().equals(username)) {
                return foundUser;
            }
        }
        return null;
    }


    @Override
    public boolean save(User user) {
        for (User findUser : users) {
            if (findUser.getUsername().equals(user.getUsername())) {
                return false;
            }
        }
        users.add(user);
        return true;
    }
}
