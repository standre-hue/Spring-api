package frey.house.ega.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private Long fieldLongValue;
    private String fieldStringValue;
    private Integer fieldIntegerValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue){
        super(String.format("%s not found with %s : %x", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldLongValue = fieldValue;
    }

    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue){
        super(String.format("%s not found with %s : %x", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldStringValue = fieldValue;
    }

    public ResourceNotFoundException(String resourceName, String fieldName, Integer fieldValue){
        super(String.format("%s not found with %s : %x", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldIntegerValue = fieldValue;
    }
}
