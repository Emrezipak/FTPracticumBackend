package com.java.practicumfinalcase.service;

import com.java.practicumfinalcase.entity.AccountType;
import com.java.practicumfinalcase.entity.AccountTypeName;
import com.java.practicumfinalcase.payload.response.AccountTypeResponse;
import com.java.practicumfinalcase.repository.AccountTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountTypeService {

    private final AccountTypeRepository accountTypeRepository;

    public AccountType save(AccountType accountType) {
       return accountTypeRepository.save(accountType);
    }
    public List<AccountType> getAllAccountsType() {
        return accountTypeRepository.findAll();
    }

    public AccountTypeResponse getAccountTypeByName(AccountTypeName accountTypeName){
        System.out.println(accountTypeName);
        AccountTypeResponse.AccountTypeResponseBuilder accountTypeResponseBuilder = AccountTypeResponse.builder();
        Optional<AccountType> accountType = accountTypeRepository.getAccountTypeByAccountTypeName(accountTypeName);
        if(accountType.isPresent()){
            return accountTypeResponseBuilder.accountType(accountType.get())
                    .account(true)
                    .message("success").build();
        }
       return accountTypeResponseBuilder.account(false)
               .message("not found accountType").build();
    }
}
