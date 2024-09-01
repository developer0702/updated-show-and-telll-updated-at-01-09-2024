package com.medication.exception;


import lombok.Data;
@Data
public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String resourceField;
    private long fieldValue;

    public ResourceNotFoundException(String resourceName, String resourceField, long fieldValue) {
        super(String.format("%s not found %s: %s",resourceName,resourceField,fieldValue));
        this.resourceName = resourceName;
        this.resourceField = resourceField;
        this.fieldValue = fieldValue;
    }
}