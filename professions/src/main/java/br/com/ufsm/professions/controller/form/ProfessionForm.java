package br.com.ufsm.professions.controller.form;

import java.util.Optional;

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
	private SectorProfession sector;

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
	
	public SectorProfession getSector() {
		return sector;
	}

	public void setSector(SectorProfession sector) {
		this.sector = sector;
	}

	public Profession convert(TitleRepository titleRepo, Long id) {
		Optional<Title> title = titleRepo.findById(id);
		if (title.isPresent()) {
			return new Profession(name, area, title.get(), sector.toString());
		}
		return null;
	}
	
	public Profession update(Long id, ProfessionRepository profRepo, TitleRepository titleRepo) {
		Profession prof = profRepo.getOne(id);
		Optional<Title> title = titleRepo.findById(this.idTitle);
		if (title.isPresent()) {
			prof.setName(this.name);
			prof.setArea(this.area);
			prof.setSector(this.sector.toString());
			prof.setTitle(title.get());
			return prof;
		}
		return null;
	}
}
