package com.example.online_shop.service.impl;


import com.example.online_shop.entity.Cart;
import com.example.online_shop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.online_shop.enums.ResultEnum;
import com.example.online_shop.exception.MyException;
import com.example.online_shop.repository.CartRepository;
import com.example.online_shop.repository.UserRepository;
import com.example.online_shop.service.UserService;

import java.util.Collection;

@Service
@DependsOn("passwordEncoder")
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CartRepository cartRepository;

    @Override
    public User findOne(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Collection<User> findByRole(String role) {
        return userRepository.findAllByRole(role);
    }

    @Override
    @Transactional
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try {
            User savedUser = userRepository.save(user);
            Cart savedCart = cartRepository.save(new Cart(savedUser));
            savedUser.setCart(savedCart);
            return userRepository.save(savedUser);

        } catch (Exception e) {
            throw new MyException(ResultEnum.VALID_ERROR);
        }

    }

    @Override
    @Transactional
    public User update(User user) {
        User oldUser = userRepository.findByEmail(user.getLogin());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(passwordEncoder.encode(user.getPassword()));
        oldUser.setName(user.getName());
        return userRepository.save(oldUser);
    }

}
