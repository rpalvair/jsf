package com.palvair.jsf.managedbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@ManagedBean
@RequestScoped
@Log4j
public class RequestBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private String name;

	public String welcome() {
		return "welcome";
	}

	public void load() {
		System.out.println("load");
		System.out.println("name = " + name);
		final String paramValue = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
				.get("name");
		if (null != paramValue && !paramValue.isEmpty()) {
			System.out.println("paramValue = " + paramValue);
			this.name = paramValue;
		}

	}

}
