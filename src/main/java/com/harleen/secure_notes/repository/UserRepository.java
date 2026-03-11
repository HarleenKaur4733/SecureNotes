package com.harleen.secure_notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harleen.secure_notes.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
