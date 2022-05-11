package com.example.airbnbcloneback.repository;

import com.example.airbnbcloneback.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByUserName(String username);
}
