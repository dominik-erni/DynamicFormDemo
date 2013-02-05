package com.zuehlke.dynamicform.controller;

import org.primefaces.extensions.model.dynaform.DynaFormModel;
import org.primefaces.extensions.model.dynaform.DynaFormRow;

import com.zuehlke.dynamicform.model.OneFieldMetaModel;

public class OneFieldGenerationStrategy extends
		FieldGenerationStrategy<OneFieldMetaModel> {

	private FieldGenerator fieldGenerator = new FieldGenerator();

	protected OneFieldGenerationStrategy(OneFieldMetaModel baseMetaModel) {
		super(baseMetaModel);
	}

	@Override
	public void generateFieldRow(DynaFormModel dynaFormModel) {
		DynaFormRow row = dynaFormModel.createRegularRow();
		fieldGenerator.generateFieldWithLabelForRow(row, getBaseMetaModel());

	}

}
