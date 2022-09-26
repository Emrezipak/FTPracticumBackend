package com.java.practicumfinalcase.repository;

import com.java.practicumfinalcase.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<Admin,Long> {

    boolean existsAdminById(Long id);
}
