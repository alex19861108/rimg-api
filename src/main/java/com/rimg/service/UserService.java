package com.rimg.service;

import com.rimg.entity.mysql.User;
import com.rimg.repository.mysql.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alex on 2017/8/12.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public List<User> findAll() {
        return userRepository.findAll();
    }
    
    public User save(User user) {
        return userRepository.save(user);
    }
}
