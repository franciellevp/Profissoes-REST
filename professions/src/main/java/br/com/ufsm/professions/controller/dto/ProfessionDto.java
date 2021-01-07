package br.com.ufsm.professions.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.ufsm.professions.model.Profession;
import br.com.ufsm.professions.model.SectorProfession;

public class ProfessionDto {
	private Long idProfession;
	private String name;
	private String area;
	private String title;

	public ProfessionDto (Profession profession) {
		this.idProfession = profession.getIdProfession();
		this.name = profession.getName();
		this.area = profession.getArea();
		this.title = new TitleDto(profession.getTitle()).getName();
	}
	
	public Long getIdProfession() {
		return idProfession;
	}

	public void setIdProfession(Long idProfession) {
		this.idProfession = idProfession;
	}


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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public static List<ProfessionDto> convert(List<Profession> profession) {
		return profession.stream().map(ProfessionDto::new).collect(Collectors.toList());
	}	
}
