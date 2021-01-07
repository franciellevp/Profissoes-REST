package br.com.ufsm.professions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ufsm.professions.model.Profession;

public interface ProfessionRepository extends JpaRepository<Profession, Long> {

	List<Profession> findByName(String name);
}
