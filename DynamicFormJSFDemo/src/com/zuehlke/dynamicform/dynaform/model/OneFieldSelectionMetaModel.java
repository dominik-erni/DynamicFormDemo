package com.zuehlke.dynamicform.dynaform.model;

import java.util.Collection;

public class OneFieldSelectionMetaModel extends OneFieldMetaModel {

	private static final long serialVersionUID = 4918685387849401206L;

	private Collection<MasterData> masterDataList;

	public Collection<MasterData> getMasterDataList() {
		return masterDataList;
	}

	public void setMasterDataList(Collection<MasterData> masterDataList) {
		this.masterDataList = masterDataList;
	}

}
