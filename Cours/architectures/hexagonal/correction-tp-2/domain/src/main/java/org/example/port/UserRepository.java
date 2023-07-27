package org.example.port;

import org.example.entity.UserApp;

public interface UserRepository {
    UserApp save(UserApp userApp);
    UserApp findByUsernameAndPassword(String username, String password);
    UserApp findByUsername(String username);
}
