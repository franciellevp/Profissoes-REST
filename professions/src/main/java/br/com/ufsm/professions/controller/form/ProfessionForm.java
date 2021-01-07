package br.com.ufsm.professions.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.ufsm.professions.model.Profession;
import br.com.ufsm.professions.model.Title;
import br.com.ufsm.professions.repository.TitleRepository;

public class ProfessionForm {

	@NotNull @NotEmpty @Length(min = 5)
	private String name;
	@NotNull @NotEmpty @Length(min = 10)
	private String area;
	@NotNull @NotEmpty @Length(min = 10)
	private Title title;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}



	public void setArea(String area) {
		this.area = area;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Profession convert(TitleRepository cp) {
		return new Profession(name, area);
	}
}
