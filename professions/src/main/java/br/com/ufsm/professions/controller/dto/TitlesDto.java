package br.com.ufsm.professions.controller.dto;

import br.com.ufsm.professions.model.Title;

public class TitlesDto {
	private Long idTitle;
	private String name;
	
	public TitlesDto(Title title) {
		this.idTitle = title.getIdTitle();
		this.name = title.getName();
	}

	public Long getIdTitle() {
		return idTitle;
	}

	public void setIdTitle(Long idTitle) {
		this.idTitle = idTitle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
