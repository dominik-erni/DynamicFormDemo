package com.zuehlke.dynamicform.dynaform.controller;

import org.primefaces.extensions.model.dynaform.DynaFormModel;
import org.primefaces.extensions.model.dynaform.DynaFormRow;

import com.zuehlke.dynamicform.dynaform.model.TwoFieldCompositeMetaModel;

public class TwoFieldCompositeGenerationStrategy extends
		FieldGenerationStrategy<TwoFieldCompositeMetaModel> {
	
	private FieldGenerator fieldGenerator = new FieldGenerator();

	protected TwoFieldCompositeGenerationStrategy(
			TwoFieldCompositeMetaModel baseMetaModel) {
		super(baseMetaModel);
	}

	@Override
	public void generateFieldRow(DynaFormModel dynaFormModel) {
		DynaFormRow row = dynaFormModel.createRegularRow();
		TwoFieldCompositeMetaModel twoFieldCompositeMetaModel = getBaseMetaModel();
		
		fieldGenerator.generateFieldWithLabelForRow(row, twoFieldCompositeMetaModel.getLeftField());
		fieldGenerator.generateFieldWithLabelForRow(row,
				twoFieldCompositeMetaModel.getRightField());
		
	}

}
