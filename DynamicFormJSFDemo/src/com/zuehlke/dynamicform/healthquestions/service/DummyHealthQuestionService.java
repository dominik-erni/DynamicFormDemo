package com.zuehlke.dynamicform.healthquestions.service;

import java.util.ArrayList;
import java.util.Collection;

import com.zuehlke.dynamicform.healthquestions.model.HealthQuestion;

public class DummyHealthQuestionService implements HealthQuestionService {

	@Override
	public Collection<HealthQuestion> loadHealthQuestions() {
		Collection<HealthQuestion> healthQuestions = new ArrayList<HealthQuestion>();
		healthQuestions.add(new HealthQuestion("smoke", "Rauchen Sie?", false,
				null, true));
		healthQuestions.add(new HealthQuestion("medicalTreatment",
				"Sind Sie zur Zeit in ärztlicher Behandlung?", false, null,
				true));
		return healthQuestions;
	}

}
