package com.springbootbackend.repository;

import com.springbootbackend.model.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {
}
