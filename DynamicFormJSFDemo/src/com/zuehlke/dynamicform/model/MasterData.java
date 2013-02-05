package com.zuehlke.dynamicform.model;

import java.io.Serializable;

public class MasterData implements Serializable {
	private static final long serialVersionUID = 7543865461630834205L;
	private String code;
	private String name;

	public MasterData(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
