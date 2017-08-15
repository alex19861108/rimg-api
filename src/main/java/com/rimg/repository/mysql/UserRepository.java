package com.rimg.repository.mysql;

import com.rimg.entity.mysql.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by alex on 2017/8/6.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
