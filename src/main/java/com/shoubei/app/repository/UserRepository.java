package com.shoubei.app.repository;

import com.shoubei.app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    //通过level查询
    public List<User> findByLevel(String level);
}
