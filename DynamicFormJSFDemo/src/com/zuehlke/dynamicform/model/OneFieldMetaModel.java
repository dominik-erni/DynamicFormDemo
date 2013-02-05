package com.zuehlke.dynamicform.model;

import static com.zuehlke.dynamicform.model.FieldStyle.NORMAL;


public class OneFieldMetaModel extends BaseFieldMetaModel {

	private static final long serialVersionUID = 2976838744802743111L;
	
	private FieldDataType dataType;
	private String label;
	private boolean required;
	private FieldStyle fieldStyle = NORMAL;
	private Object value;

	public FieldDataType getDataType() {
		return dataType;
	}

	public void setDataType(FieldDataType dataType) {
		this.dataType = dataType;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public FieldStyle getFieldStyle() {
		return fieldStyle;
	}

	public void setFieldStyle(FieldStyle style) {
		this.fieldStyle = style;
	}

}
