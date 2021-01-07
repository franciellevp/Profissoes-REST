package br.com.ufsm.professions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ufsm.professions.model.Title;

public interface TitleRepository extends JpaRepository<Title, Long> {
	
	Title findByName (String name);
}

