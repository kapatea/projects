package com.kaptea.wspart1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kaptea.wspart1.entity.User;

public interface UserRepository extends JpaRepository<User, Long>
{

}