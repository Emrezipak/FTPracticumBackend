package com.java.practicumfinalcase.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.java.practicumfinalcase.entity.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountTypeResponse {

    private String message;
    private AccountType accountType;
    private boolean account;
}
