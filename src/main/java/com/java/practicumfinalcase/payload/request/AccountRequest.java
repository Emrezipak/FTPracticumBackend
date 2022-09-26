package com.java.practicumfinalcase.payload.request;

import com.java.practicumfinalcase.entity.AccountType;
import com.java.practicumfinalcase.entity.AccountTypeName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountRequest {

    @NotNull
    private Long userId;
    @NotNull
    private AccountTypeName accountTypeName;
}
