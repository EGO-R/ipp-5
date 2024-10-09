package org.java4me.ipp5.repository;

import org.java4me.ipp5.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
