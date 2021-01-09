package br.com.ufsm.professions.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Profession {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProfession;
	private String name;
	private String area;
	@Enumerated(EnumType.STRING)
	private SectorProfession sector;
	@ManyToOne
	private Title title;
	
	
	public Profession() {
		super();
	}

	public Profession(String name, String area, Title title, String sector) {
		super();
		this.name = name;
		this.area = area;
		this.title = title;
		this.sector = SectorProfession.valueOf(sector);
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

	public SectorProfession getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = SectorProfession.valueOf(sector);
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}	
}
