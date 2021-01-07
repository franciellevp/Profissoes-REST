package br.com.ufsm.professions.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.ufsm.professions.controller.dto.ProfessionDetailDto;
import br.com.ufsm.professions.controller.dto.ProfessionDto;
import br.com.ufsm.professions.controller.dto.TitleDto;
import br.com.ufsm.professions.controller.form.ProfessionForm;
import br.com.ufsm.professions.model.Profession;
import br.com.ufsm.professions.model.Title;
import br.com.ufsm.professions.repository.TitleRepository;
import br.com.ufsm.professions.repository.ProfessionRepository;

@RestController
@RequestMapping("/profissoes")
public class ProfessionsController {
	
	@Autowired
	private ProfessionRepository profRepo;
	@Autowired
	private TitleRepository titleRepo;
	
	@GetMapping
	public List<ProfessionDto> list (String name) {
		List<Profession> professions = (name != null && !name.isEmpty()) ? profRepo.findByName(name) : profRepo.findAll();
		return ProfessionDto.convert(professions);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProfessionDetailDto> detail (@PathVariable Long id) {
		Optional<Profession> top = profRepo.findById(id);
		if (top.isPresent()) {
			return ResponseEntity.ok(new ProfessionDetailDto(top.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ProfessionDto> cadastrar (@RequestBody @Valid ProfessionForm profForm, UriComponentsBuilder uriBuilder) {
		Profession prof = profForm.convert(titleRepo, profForm.getIdTitle());
		profRepo.save(prof);
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(prof.getIdProfession()).toUri();
		return ResponseEntity.created(uri).body(new ProfessionDto(prof));
	}
}
