package ApiTest.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ApiTest.entities.Aluno;
import ApiTest.entities.DTO.AlunoDTO;
import ApiTest.factory.DTOFactory;
import ApiTest.repositories.AlunoRepository;
import jakarta.transaction.Transactional;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;
	
	
	@Transactional
	public Aluno create(AlunoDTO alunoDTO) {
		
		Aluno aluno = new Aluno(alunoDTO.getId(), alunoDTO.getNome(), alunoDTO.getEmail());
		
		repository.save(aluno);
		
		return aluno;
	}

	public List<AlunoDTO> findAll() {
		List<Aluno> result = repository.findAll();
		List<AlunoDTO> dto = result.stream().map((x) -> DTOFactory.createDTO(x)).collect(Collectors.toList());
		return dto;
	}

	public AlunoDTO findById(Long id) {
		try {
			Aluno result = repository.findById(id).get();
			AlunoDTO dto = DTOFactory.createDTO(result);
			return dto;
		} catch (Error e) {
			throw new RuntimeErrorException(e);
		}
		
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (Error e) {
			throw new RuntimeErrorException(e);
		}
	}
	
	
	public Aluno update(Long id, Aluno obj) {
		
		try {
			Aluno entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (Error e) {
			throw new RuntimeErrorException(e);
			
		}
		
	}
	
	private void updateData(Aluno entity, Aluno obj) {
		entity.setId(obj.getId());
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
	
	}

}
