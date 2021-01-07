package br.com.ufsm.professions.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Profession {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProfession;
	private String name;
	private String area;
	@Enumerated(EnumType.STRING)
	private SectorProfession status = SectorProfession.PRIVADO;
	@OneToMany(mappedBy = "profession") // 1 topico -> n respostas
	// na classe resposta ta mapeado o relacionamento com o 'topico' (atributo da classe Resposta)
	private List<Title> titles = new ArrayList<>();

	
	public Profession() {
		super();
	}

	public Profession(String name, String area) {
		super();
		this.name = name;
		this.area = area;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProfession == null) ? 0 : idProfession.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profession other = (Profession) obj;
		if (idProfession == null) {
			if (other.idProfession != null)
				return false;
		} else if (!idProfession.equals(other.idProfession))
			return false;
		return true;
	}

	public Integer getIdProfession() {
		return idProfession;
	}

	public void setIdProfession(Integer idProfession) {
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

	public SectorProfession getStatus() {
		return status;
	}

	public void setStatus(SectorProfession status) {
		this.status = status;
	}

	public List<Title> getTitles() {
		return titles;
	}

	public void setTitles(List<Title> titles) {
		this.titles = titles;
	}	
}
