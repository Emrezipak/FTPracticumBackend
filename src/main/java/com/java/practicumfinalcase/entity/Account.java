package com.java.practicumfinalcase.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Admin admin;

    private BigDecimal totalAssets = BigDecimal.ZERO;


    @ManyToMany
    @JoinTable(
            name = "account_account_type",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "account_type_id"))
    private Set<AccountType> accountType;

}
