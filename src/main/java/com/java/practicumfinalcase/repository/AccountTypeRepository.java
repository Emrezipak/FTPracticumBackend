package com.java.practicumfinalcase.repository;

import com.java.practicumfinalcase.entity.AccountType;
import com.java.practicumfinalcase.entity.AccountTypeName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType,Long> {

    Optional<AccountType> getAccountTypeByAccountTypeName(AccountTypeName accountTypeName);
}
