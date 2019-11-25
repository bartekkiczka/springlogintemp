package com.negotium.registration.dao;

import com.negotium.registration.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
