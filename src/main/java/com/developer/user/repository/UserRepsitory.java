package com.developer.user.repository;

import com.developer.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepsitory extends JpaRepository<User,Long> {
    User findByUserId(Long userId);
}
