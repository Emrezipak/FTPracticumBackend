package com.java.practicumfinalcase.service;

import com.java.practicumfinalcase.config.HttpEntityConfig;
import com.java.practicumfinalcase.entity.*;
import com.java.practicumfinalcase.payload.request.AccountRequest;
import com.java.practicumfinalcase.payload.response.ResponseMessage;
import com.java.practicumfinalcase.payload.response.AccountTypeResponse;
import com.java.practicumfinalcase.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final RestTemplate restTemplate;
    private final UserService userService;

    private final AccountTypeService accountTypeService;

    private final HttpEntityConfig httpEntityConfig;
    @Value("${service.api.url}")
    private String exchangeUrl;


    public ResponseMessage<?> callService(Long id, String currencyType) {
        BigDecimal totalAssets = getTotalAssetsFromUser(id);
        if (totalAssets != null) {
            String url = exchangeUrl + "?int=" + totalAssets + "&to=" + currencyType + "&base=" + CurrencyType.TRY;
            System.out.println(url);
            ResponseEntity<String> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    httpEntityConfig.createHttpEntity(),
                    String.class);
            return ResponseMessage.builder()
                    .message("service connected successfully")
                    .httpStatus(HttpStatus.OK)
                    .data(response.getBody())
                    .build();
        }
        return ResponseMessage.builder().message("not found user").httpStatus(HttpStatus.NOT_FOUND).build();

    }

    private BigDecimal getTotalAssetsFromUser(Long id) {
        return userService.getUserByUserId(id).getAccount().getTotalAssets();
    }

    public ResponseMessage<?> save(AccountRequest accountRequest) {
        AccountTypeResponse accountTypeResponse = checkAccountType(accountRequest.getAccountTypeName());
        Admin admin = getAdminFromUserService(accountRequest.getUserId());
        if(!accountTypeResponse.isAccount()){
            return ResponseMessage.builder().message(accountTypeResponse.getMessage())
                    .httpStatus(HttpStatus.NOT_FOUND).build();
        }

        if(admin == null){
            return ResponseMessage.builder().message("user not found")
                    .httpStatus(HttpStatus.NOT_FOUND).build();
        }
        Set<AccountType> accountTypes = addAccountType(accountTypeResponse.getAccountType());

        Account account = Account.builder()
                .admin(admin)
                .accountType(accountTypes)
                .build();
         accountRepository.save(account);
         return ResponseMessage.builder().message("created Account")
                 .httpStatus(HttpStatus.OK)
                 .type(account).build();
    }

    private AccountTypeResponse checkAccountType(AccountTypeName accountTypeName){
        return accountTypeService.getAccountTypeByName(accountTypeName);
    }

    private Admin getAdminFromUserService(Long userId){
        return userService.getUserByUserId(userId);
    }

    private Set<AccountType> addAccountType(AccountType accountType){
        Set<AccountType> accountTypes = new HashSet<>();
        accountTypes.add(accountType);
        return accountTypes;
    }

}