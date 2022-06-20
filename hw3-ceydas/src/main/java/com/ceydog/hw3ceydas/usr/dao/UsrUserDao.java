package com.ceydog.hw3ceydas.usr.dao;

import com.ceydog.hw3ceydas.usr.entity.UsrUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsrUserDao extends JpaRepository<UsrUser, Long> {

    UsrUser findByUsername(String username);
    boolean existsByUsername(String username);
}
