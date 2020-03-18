package com.example.online_shop.repository;

import com.example.online_shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);

    Collection<User> findAllByRole(String role);

}
