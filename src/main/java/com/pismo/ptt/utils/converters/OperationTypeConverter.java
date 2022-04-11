package com.pismo.ptt.utils.converters;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.pismo.ptt.utils.enums.OperationTypeEnum;

@Converter(autoApply = true)
public class OperationTypeConverter implements AttributeConverter<OperationTypeEnum, Long> {

	@Override
	public Long convertToDatabaseColumn(OperationTypeEnum operationType) {
		if(operationType == null) {
			return null;
		}
		return operationType.getOperationId();
	}

	@Override
	public OperationTypeEnum convertToEntityAttribute(Long operationId) {
		if(operationId == null) {
			return null;
		}
		
		return Stream.of(OperationTypeEnum.values())
				.filter(o -> o.getOperationId().equals(operationId))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
