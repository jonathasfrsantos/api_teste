package ApiTest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ApiTest.entities.Aluno;
import ApiTest.entities.DTO.AlunoDTO;
import ApiTest.services.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
@CrossOrigin(origins = "http://localhost:3000")
public class AlunoController {
	
	@Autowired
	private AlunoService service;
	

	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Aluno> create(@RequestBody @Validated AlunoDTO dto){
		return ResponseEntity.ok().body(service.create(dto));		
	}
	
	@GetMapping
	public List<AlunoDTO> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AlunoDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody Aluno obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
}
