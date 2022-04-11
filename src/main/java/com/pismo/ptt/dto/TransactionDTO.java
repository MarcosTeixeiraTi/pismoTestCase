package com.pismo.ptt.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
	
	private Long accountId;
	
	private Long operationTypeId;
	
	private BigDecimal amount;

}
