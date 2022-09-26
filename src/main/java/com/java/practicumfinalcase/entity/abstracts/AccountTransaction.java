package com.java.practicumfinalcase.entity.abstracts;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.java.practicumfinalcase.entity.Account;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AccountTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    @NotEmpty
    private String explanation;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private LocalDateTime localDateTime;

    @NotNull
    private BigDecimal totalAssets = new BigDecimal(0);

    @NotNull
    @OneToOne
    private Account account;
}
