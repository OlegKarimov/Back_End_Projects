package de.aittr.mvc_10_07;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository repisitory;
    public UserService(UserRepository repisitory) {
        this.repisitory = repisitory;
    }

    List<User> getAllUsers(){
        return repisitory.findAll();
    }



}
