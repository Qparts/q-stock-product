package q.stock.product.dto;

import java.util.HashMap;
import java.util.Map;

public class SearchDto {

	private String fieldName;
	private String value;
	private String operation;

	public SearchDto() {
	}

	public SearchDto(String fieldName, String value, String operation) {
		this.fieldName = fieldName;
		this.value = value;
		this.operation = operation;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return "SearchDto [fieldName=" + fieldName + ", value=" + value + ", operation=" + operation + "]";
	}

}