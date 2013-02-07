package com.zuehlke.dynamicform.dynaform.controller;

import org.primefaces.extensions.model.dynaform.DynaFormModel;

import com.zuehlke.dynamicform.dynaform.model.BaseFieldMetaModel;

public abstract class FieldGenerationStrategy<T extends BaseFieldMetaModel> {

	private T baseMetaModel;

	protected FieldGenerationStrategy(T baseMetaModel) {
		this.baseMetaModel = baseMetaModel;
	}

	public abstract void generateFieldRow(DynaFormModel dynaFormModel);

	protected T getBaseMetaModel() {
		return baseMetaModel;
	}

}
