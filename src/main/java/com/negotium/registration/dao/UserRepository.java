package com.negotium.registration.dao;

import com.negotium.registration.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

    User findByLogin(String username);

}