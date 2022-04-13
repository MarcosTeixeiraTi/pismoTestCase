package com.pismo.ptt.utils.enums;

import lombok.Getter;

@Getter
public enum OperationTypeEnum {

	COMPRA_VISTA(1L, "Compra a vista", true),
	COMPRA_PARCELADA(2L, "Compra parcelada", true),
	SAQUE(3L, "Saque", true),
	PAGAMENTO(4L, "Pagamento", false);
	
	OperationTypeEnum(Long operationId, String operationDescription, Boolean operationPositive) {
		this.operationId = operationId;
		this.operationDescription = operationDescription;
		this.operationPositive = operationPositive;
	}

	private Long operationId;
	
	private String operationDescription;
	
	private Boolean operationPositive;
	
}
