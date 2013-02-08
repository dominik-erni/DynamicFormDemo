package com.zuehlke.dynamicform.healthquestions.controller;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.zuehlke.dynamicform.healthquestions.model.HealthQuestion;
import com.zuehlke.dynamicform.healthquestions.service.DummyHealthQuestionService;
import com.zuehlke.dynamicform.healthquestions.service.HealthQuestionService;

@ManagedBean(name = "HealthQuestionController")
public class HealthQuestionController implements Serializable {

	private static final long serialVersionUID = -231616539676828488L;

	private HealthQuestionService healthQuestionService = new DummyHealthQuestionService();

	private Collection<HealthQuestion> healthQuestions;

	public HealthQuestionController() {
		super();
	}

	public Collection<HealthQuestion> getHealthQuestions() {
		healthQuestions = healthQuestionService.loadHealthQuestions();
		return healthQuestions;
	}

	public void submit() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		for (HealthQuestion healthQuestion : healthQuestions) {
			facesContext.addMessage(null, new FacesMessage(healthQuestion.getQuestionText(), healthQuestion.getAnswerAsString()));
		}
	}

}
