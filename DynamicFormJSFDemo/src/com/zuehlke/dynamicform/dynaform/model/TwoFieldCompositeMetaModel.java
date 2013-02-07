package com.zuehlke.dynamicform.dynaform.model;

public class TwoFieldCompositeMetaModel extends BaseFieldMetaModel {

	private static final long serialVersionUID = 6639414867908263382L;

	private OneFieldMetaModel leftField;
	private OneFieldMetaModel rightField;

	public OneFieldMetaModel getLeftField() {
		return leftField;
	}

	public void setLeftField(OneFieldMetaModel leftField) {
		this.leftField = leftField;
	}

	public OneFieldMetaModel getRightField() {
		return rightField;
	}

	public void setRightField(OneFieldMetaModel rightField) {
		this.rightField = rightField;
	}

}
