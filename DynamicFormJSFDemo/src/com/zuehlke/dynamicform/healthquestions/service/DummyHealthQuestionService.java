package com.zuehlke.dynamicform.healthquestions.service;

import java.util.ArrayList;
import java.util.Collection;

import com.zuehlke.dynamicform.healthquestions.model.HealthQuestion;

public class DummyHealthQuestionService implements HealthQuestionService {

	private static final boolean NOT_BASE_QUESTION = false;
	private static final boolean TEXT_QUESTION = false;
	private static final boolean YES_NO_QUESTION = true;

	@Override
	public Collection<HealthQuestion> loadHealthQuestions() {
		Collection<HealthQuestion> healthQuestions = new ArrayList<HealthQuestion>();
		healthQuestions.add(new HealthQuestion("smoke", "Rauchen Sie?",
				NOT_BASE_QUESTION, null, YES_NO_QUESTION));
		healthQuestions.add(new HealthQuestion("medicalTreatment",
				"Sind Sie zur Zeit in ärztlicher Behandlung?",
				NOT_BASE_QUESTION, null, YES_NO_QUESTION));
		healthQuestions.add(new HealthQuestion("kids",
				"Wie viele Kinder haben Sie?", NOT_BASE_QUESTION, null,
				TEXT_QUESTION));
		healthQuestions.add(new HealthQuestion("wife",
				"Wie viele Frauen haben Sie?", NOT_BASE_QUESTION, null,
				TEXT_QUESTION));
		healthQuestions.add(new HealthQuestion("sick", "Sind Sie krank?",
				NOT_BASE_QUESTION, null, YES_NO_QUESTION));
		return healthQuestions;
	}

}
