package com.zuehlke.dynamicform.dynaform.service;

import java.util.ArrayList;
import java.util.Collection;

import com.zuehlke.dynamicform.dynaform.model.BaseFieldMetaModel;
import com.zuehlke.dynamicform.dynaform.model.FieldDataType;
import com.zuehlke.dynamicform.dynaform.model.FieldStyle;
import com.zuehlke.dynamicform.dynaform.model.MasterData;
import com.zuehlke.dynamicform.dynaform.model.OneFieldMetaModel;
import com.zuehlke.dynamicform.dynaform.model.OneFieldSelectionMetaModel;
import com.zuehlke.dynamicform.dynaform.model.TwoFieldCompositeMetaModel;

public class DummyMetaModelService implements MetaModelService {

	private static final boolean REQUIRED = true;
	private static final boolean NOT_REQUIRED = false;

	private CountryDataService countryDataService = new CountryDataService();

	public Collection<? extends BaseFieldMetaModel> loadFieldsForContext() {
		Collection<BaseFieldMetaModel> fields = new ArrayList<BaseFieldMetaModel>();
		fields.add(createInputField("lastName", "Ihr Name", REQUIRED));
		fields.add(createInputField("firstName", "Ihr Vorname", REQUIRED));
		fields.add(createTwoFieldComposite(
				"streetComposite",
				createInputField("street", "Ihre Adresse", REQUIRED),
				createInputField("streetNo", "Nr.", NOT_REQUIRED,
						FieldStyle.MINI)));
		fields.add(createTwoFieldComposite("cityComposite",
				createInputField("city", "Ort", REQUIRED),
				createInputField("zip", "PLZ", REQUIRED, FieldStyle.MINI)));
		fields.add(createSelectInputField("country", "Land", REQUIRED));
		return fields;
	}

	private BaseFieldMetaModel createSelectInputField(String id, String label,
			boolean required) {
		return createSelectInputField(id, label, required, FieldStyle.NORMAL,
				countryDataService.loadCountries());
	}

	private OneFieldSelectionMetaModel createSelectInputField(String id,
			String label, boolean required, FieldStyle fieldStyle,
			Collection<MasterData> masterDataList) {
		OneFieldSelectionMetaModel field = new OneFieldSelectionMetaModel();
		field.setDataType(FieldDataType.SELECT);
		field.setId(id);
		field.setLabel(label);
		field.setRequired(required);
		field.setFieldStyle(fieldStyle);
		field.setMasterDataList(masterDataList);
		return field;
	}

	private TwoFieldCompositeMetaModel createTwoFieldComposite(String id,
			OneFieldMetaModel leftField, OneFieldMetaModel rightField) {
		TwoFieldCompositeMetaModel twoFieldComposite = new TwoFieldCompositeMetaModel();
		twoFieldComposite.setId(id);
		twoFieldComposite.setLeftField(leftField);
		twoFieldComposite.setRightField(rightField);
		return twoFieldComposite;
	}

	private OneFieldMetaModel createInputField(String id, String label,
			boolean required) {
		return createInputField(id, label, required, FieldStyle.NORMAL);
	}

	private OneFieldMetaModel createInputField(String id, String label,
			boolean required, FieldStyle fieldStyle) {
		OneFieldMetaModel field = new OneFieldMetaModel();
		field.setDataType(FieldDataType.INPUT);
		field.setId(id);
		field.setLabel(label);
		field.setRequired(required);
		field.setFieldStyle(fieldStyle);
		return field;
	}

}
