package com.zuehlke.dynamicform.healthquestions.service;

import java.util.Collection;

import com.zuehlke.dynamicform.healthquestions.model.HealthQuestion;

public interface HealthQuestionService {
	
	Collection<HealthQuestion> loadHealthQuestions();

}
