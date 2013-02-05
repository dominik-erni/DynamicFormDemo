package com.zuehlke.dynamicform.controller;

import org.primefaces.extensions.model.dynaform.DynaFormControl;
import org.primefaces.extensions.model.dynaform.DynaFormLabel;
import org.primefaces.extensions.model.dynaform.DynaFormRow;

import com.zuehlke.dynamicform.model.OneFieldMetaModel;

public class FieldGenerator {

	public void generateFieldWithLabelForRow(DynaFormRow dynaFormRow,
			OneFieldMetaModel oneFieldMetaModel) {
		DynaFormLabel label = dynaFormRow.addLabel(
				oneFieldMetaModel.getLabel(), 1, 1);
		DynaFormControl control = dynaFormRow.addControl(oneFieldMetaModel,
				oneFieldMetaModel.getDataType().name(), 1, 1);
		label.setForControl(control);
	}

}
