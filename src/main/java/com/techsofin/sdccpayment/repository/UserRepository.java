package com.techsofin.sdccpayment.repository;

import com.techsofin.sdccpayment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);

    User findByUsername(String name);

    User findByMobileAndName(String mobile, String name);

    User findByNameAndMobile(String name, String mobile);

    List<User> findByNameLike(String nameLike);

    List<User> findByNameLikeAndUsernameEquals(String name, String username);

    List<User> findByNameLikeAndUsernameLike(String name, String username);

}
