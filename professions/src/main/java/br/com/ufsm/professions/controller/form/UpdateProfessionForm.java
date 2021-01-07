package br.com.ufsm.professions.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.ufsm.professions.model.Profession;
import br.com.ufsm.professions.repository.ProfessionRepository;

public class UpdateProfessionForm {
	
	@NotNull @NotEmpty @Length(min = 5)
	private String name;
	@NotNull @NotEmpty @Length(min = 10)
	private String area;

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

	public Profession update (Long id, ProfessionRepository proRepo) {
		Profession prof = proRepo.getOne(id);
		prof.setName(this.name);
		prof.setArea(this.area);
		return prof;
	}
}
