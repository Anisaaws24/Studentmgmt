package com.example.Studentnew.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFoundException extends RuntimeException{
	
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String FieldName;
	private Object FieldValue;
 

 public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with: '%s'",resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		FieldName = fieldName;
		FieldValue = fieldValue;
	}
public String getresourceName()
 {
	 return resourceName;
 }
 public String getfieldName()
 {
	 return FieldName;
 }
 public Object getfieldValue()
 {
	 return FieldValue;
 }

}
