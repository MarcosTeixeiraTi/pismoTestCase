package com.pismo.ptt.utils.enums;

import lombok.Getter;

@Getter
public enum OperationTypeEnum {

	COMPRA_VISTA(1L, "Compra a vista", 0),
	COMPRA_PARCELADA(2L, "Compra parcelada", 0),
	SAQUE(3L, "Saque", 0),
	PAGAMENTO(4L, "Pagamento", 1);
	
	OperationTypeEnum(Long operationId, String operationDescription, Integer operationRegister) {
		this.operationId = operationId;
		this.operationDescription = operationDescription;
		this.operationRegister = operationRegister;
	}

	private Long operationId;
	
	private String operationDescription;
	
	private Integer operationRegister;
	
}
