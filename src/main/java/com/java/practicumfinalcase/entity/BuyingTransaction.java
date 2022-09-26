package com.java.practicumfinalcase.entity;

import com.java.practicumfinalcase.entity.abstracts.AccountTransaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Builder
public class BuyingTransaction extends AccountTransaction {

}
