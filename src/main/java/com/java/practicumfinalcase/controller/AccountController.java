package com.java.practicumfinalcase.controller;

import com.java.practicumfinalcase.payload.request.AccountRequest;
import com.java.practicumfinalcase.payload.response.ResponseMessage;
import com.java.practicumfinalcase.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;


    @PostMapping("/save")
    public ResponseEntity<ResponseMessage<?>> save(@RequestBody @Valid AccountRequest accountRequest){
       return ResponseEntity.ok(accountService.save(accountRequest));
    }

    @GetMapping("/exchangeCurrency")
    public ResponseEntity<ResponseMessage<?>> exchangeCurrency(@RequestParam(value = "userId")Long id,
                                                   @RequestParam(value = "currencyType")String currencyType){
        return ResponseEntity.ok(accountService.callService(id,currencyType));
    }
}
