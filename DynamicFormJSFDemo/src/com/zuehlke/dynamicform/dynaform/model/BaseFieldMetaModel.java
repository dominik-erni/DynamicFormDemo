package com.zuehlke.dynamicform.dynaform.model;

import java.io.Serializable;

public class BaseFieldMetaModel implements Serializable {

	private static final long serialVersionUID = 4963617272368288781L;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
