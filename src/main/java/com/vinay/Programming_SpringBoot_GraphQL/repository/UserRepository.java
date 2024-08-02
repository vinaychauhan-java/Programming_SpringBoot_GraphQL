package com.vinay.Programming_SpringBoot_GraphQL.repository;

import com.vinay.Programming_SpringBoot_GraphQL.domain.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

}
