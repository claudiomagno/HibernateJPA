package com.algaworks.comercial.controller;

import java.io.Serializable;
import java.lang.Boolean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;


@ManagedBean
@ApplicationScoped
public class ExporterController implements Serializable {

	private static final long serialVersionUID = 20120316L;

	private Boolean customExporter;


	public ExporterController() {
             customExporter=false;
	}

    public Boolean getCustomExporter() {
        return customExporter;
    }

    public void setCustomExporter(Boolean customExporter) {
        this.customExporter = customExporter;
    }
}