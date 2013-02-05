package com.zuehlke.dynamicform.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.extensions.model.dynaform.DynaFormControl;
import org.primefaces.extensions.model.dynaform.DynaFormModel;

import com.zuehlke.dynamicform.model.BaseFieldMetaModel;
import com.zuehlke.dynamicform.model.OneFieldMetaModel;
import com.zuehlke.dynamicform.model.TwoFieldCompositeMetaModel;
import com.zuehlke.dynamicform.service.DummyMetaModelService;
import com.zuehlke.dynamicform.service.MetaModelService;

@ManagedBean(name = "DynaFormController")
@ViewScoped
public class DynaFormController implements Serializable {

	private static final String FORM_META_MODEL = "form_meta_model";

	public DynaFormController() {
		super();
	}

	private static final long serialVersionUID = -2754816242930758651L;

	// TODO Dependency Injection
	private transient MetaModelService metaModelService = new DummyMetaModelService();

	private DynaFormModel formMetaModel;

	public DynaFormModel getFormMetaModel() {
		if (!FacesContext.getCurrentInstance().isPostback()) {
			formMetaModel = new DynaFormModel();
			Collection<? extends BaseFieldMetaModel> fields = metaModelService
					.loadFieldsForContext();
			for (BaseFieldMetaModel fieldMetaModel : fields) {
				FieldGenerationStrategy<? extends BaseFieldMetaModel> stratety = createFieldGenerationStrategy(fieldMetaModel);
				stratety.generateFieldRow(formMetaModel);
			}
		}
		return formMetaModel;
	}

	public String submit() {
		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put(FORM_META_MODEL, formMetaModel);
		return "/result.xhtml?faces-redirect=true";
	}

	private FieldGenerationStrategy<? extends BaseFieldMetaModel> createFieldGenerationStrategy(
			BaseFieldMetaModel fieldMetaModel) {
		FieldGenerationStrategy<? extends BaseFieldMetaModel> fieldGenerationStrategy = null;
		if (fieldMetaModel instanceof OneFieldMetaModel) {
			fieldGenerationStrategy = new OneFieldGenerationStrategy(
					(OneFieldMetaModel) fieldMetaModel);
		} else if (fieldMetaModel instanceof TwoFieldCompositeMetaModel) {
			fieldGenerationStrategy = new TwoFieldCompositeGenerationStrategy(
					(TwoFieldCompositeMetaModel) fieldMetaModel);
		} else {
			throw new IllegalArgumentException("Strategy not implemented");
		}
		return fieldGenerationStrategy;

	}

	public Collection<OneFieldMetaModel> getDataFields() {
		formMetaModel = (DynaFormModel) FacesContext.getCurrentInstance()
				.getExternalContext().getFlash().get(FORM_META_MODEL);
		List<DynaFormControl> controls = formMetaModel.getControls();
		Collection<OneFieldMetaModel> dataFields = new ArrayList<OneFieldMetaModel>();
		for (DynaFormControl dynaFormControl : controls) {
			OneFieldMetaModel data = (OneFieldMetaModel) dynaFormControl
					.getData();
			dataFields.add(data);
		}
		return dataFields;

	}

}
