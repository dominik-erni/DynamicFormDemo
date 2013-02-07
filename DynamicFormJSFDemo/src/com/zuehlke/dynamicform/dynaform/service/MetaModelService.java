package com.zuehlke.dynamicform.dynaform.service;

import java.util.Collection;

import com.zuehlke.dynamicform.dynaform.model.BaseFieldMetaModel;

public interface MetaModelService {

	Collection<? extends BaseFieldMetaModel>  loadFieldsForContext();

}
