package com.example.restapi.service;

import com.example.restapi.entity.UserEntity;
import com.example.restapi.exceptions.UserAlreadyExist;
import com.example.restapi.exceptions.UserNotFoundException;
import com.example.restapi.model.User;
import com.example.restapi.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExist {
        if(userRepo.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExist("User with such username already exists");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException{
         UserEntity user = userRepo.findById(id).get();
        if(user==null){
        throw new UserNotFoundException("User not found");
        }
        return User.toModel(user);
    }

    public Long delete(Long id){
        userRepo.deleteById(id);
        return id;
    }
}
