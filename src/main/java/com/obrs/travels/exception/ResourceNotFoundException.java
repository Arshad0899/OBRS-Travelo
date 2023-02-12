package com.obrs.travels.exception;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException {

	private String resourcename;
	private String fieldName;
	private long feildValue;

	public ResourceNotFoundException(String resourcename, String firldName, long feildValue) {
		super(String.format("%s not found with %s : %l", resourcename, firldName, feildValue));
		this.resourcename = resourcename;
		this.fieldName = firldName;
		this.feildValue = feildValue;
	}

	public String getResourcename() {
		return resourcename;
	}

	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}

	public String getFirldName() {
		return fieldName;
	}

	public void setFirldName(String firldName) {
		this.fieldName = firldName;
	}

	public long getFeildValue() {
		return feildValue;
	}

	public void setFeildValue(long feildValue) {
		this.feildValue = feildValue;
	}

}
