package br.com.ufsm.professions.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.ufsm.professions.model.Profession;
import br.com.ufsm.professions.model.SectorProfession;
import br.com.ufsm.professions.model.Title;
import br.com.ufsm.professions.repository.ProfessionRepository;
import br.com.ufsm.professions.repository.TitleRepository;

public class ProfessionForm {

	@NotNull @NotEmpty @Length(min = 5)
	private String name;
	@NotNull @NotEmpty @Length(min = 5)
	private String area;
	@NotNull
	private Long idTitle;
	@NotNull
	private SectorProfession sector = SectorProfession.PRIVADO;

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

	public Long getIdTitle() {
		return idTitle;
	}

	public void setIdTitle(Long idTitle) {
		this.idTitle = idTitle;
	}

	public Profession convert(TitleRepository titleRepo, Long id) {
		Title title = titleRepo.getOne(id);
		return new Profession(name, area, title);
	}
	
	public Profession update(Long id, ProfessionRepository profRepo, TitleRepository titleRepo) {
		Profession prof = profRepo.getOne(id);
		prof.setName(this.name);
		prof.setArea(this.area);
		prof.setSector(this.sector);
		prof.setTitle(titleRepo.getOne(id));
		return prof;
	}
}
