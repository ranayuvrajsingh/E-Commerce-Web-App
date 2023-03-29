package com.ProductCatelog.CustomException;

public class ResourceNotFoundException extends RuntimeException{
	String resourceName;
	String fieldName;
	Long FieldValue;
	
	
	public ResourceNotFoundException(String resourceName, String fieldName, long pid) {
		super(String.format("%s not found with %s : %l", resourceName,fieldName,pid));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		FieldValue = (long) pid;
	}


	public String getResourceName() {
		return resourceName;
	}


	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}


	public String getFieldName() {
		return fieldName;
	}


	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}


	public Long getFieldValue() {
		return FieldValue;
	}


	public void setFieldValue(Long fieldValue) {
		FieldValue = fieldValue;
	}
	
	
	

}
