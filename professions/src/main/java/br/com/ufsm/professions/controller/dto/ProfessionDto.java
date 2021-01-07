package br.com.ufsm.professions.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.ufsm.professions.model.Profession;

public class ProfessionDto {
	private Long idProfession;
	private String name;
	private String area;
	
	public ProfessionDto (Profession profession) {
		this.idProfession = profession.getIdProfession();
		this.name = profession.getName();
		this.area = profession.getArea();
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

	public static List<ProfessionDto> convert(List<Profession> profession) {
		return profession.stream().map(ProfessionDto::new).collect(Collectors.toList());
	}	
}
