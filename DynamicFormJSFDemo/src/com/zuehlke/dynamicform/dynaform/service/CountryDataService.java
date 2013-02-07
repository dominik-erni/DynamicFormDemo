package com.zuehlke.dynamicform.dynaform.service;

import java.util.ArrayList;
import java.util.Collection;

import com.zuehlke.dynamicform.dynaform.model.MasterData;

public class CountryDataService {

	private Collection<MasterData> countries;

	public Collection<MasterData> loadCountries() {
		if (countries == null) {
			countries = new ArrayList<MasterData>();
			countries.add(new MasterData(null, "---"));
			countries.add(new MasterData("DE", "Deutschland"));
			countries.add(new MasterData("IT", "Italien"));
			countries.add(new MasterData("CH", "Schweiz"));
		}
		return countries;
	}

}
