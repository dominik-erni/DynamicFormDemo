package com.zuehlke.dynamicform.xvalidation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "crossValidator")
public class CrossValidator implements Validator {

	@Override
	public void validate(FacesContext facesContext, UIComponent component,
			Object value) throws ValidatorException {
		UIInput input1 = (UIInput) component.getAttributes().get("name");
		UIInput input2 = (UIInput) component.getAttributes().get("birthdate");

		String name = (String) input1.getSubmittedValue();
		String birthdate = (String) input2.getSubmittedValue();
		if (birthdate != null && name.length() > 5) {
			throw new ValidatorException(
					new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Fehler",
							"Wenn das Geburtsdatum nicht leer ist, darf der Namen nicht mehr als 5 Buchstaben haben"));
		}

	}
}
