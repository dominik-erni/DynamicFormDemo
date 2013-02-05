package com.zuehlke.dynamicform.service;

import java.util.Collection;

import com.zuehlke.dynamicform.model.BaseFieldMetaModel;

public interface MetaModelService {

	Collection<? extends BaseFieldMetaModel>  loadFieldsForContext();

}
