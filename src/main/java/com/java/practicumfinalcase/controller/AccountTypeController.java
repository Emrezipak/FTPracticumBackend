package com.java.practicumfinalcase.controller;

import com.java.practicumfinalcase.entity.AccountType;
import com.java.practicumfinalcase.service.AccountService;
import com.java.practicumfinalcase.service.AccountTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/accountType")
@RequiredArgsConstructor
public class AccountTypeController {

    private final AccountTypeService accountTypeService;

    @PostMapping("/save")
    public ResponseEntity<AccountType> save(@RequestBody AccountType accountType){
        return ResponseEntity.ok(accountTypeService.save(accountType));
    }

    @GetMapping("/getAllAccountsType")
    public ResponseEntity<List<AccountType>> getAllAccountsType(){
        return ResponseEntity.ok(accountTypeService.getAllAccountsType());
    }
}
