package ApiTest.factory;

import ApiTest.entities.Aluno;
import ApiTest.entities.DTO.AlunoDTO;

public class DTOFactory {

	
	public static AlunoDTO createDTO(Aluno aluno) {
		AlunoDTO dto = new AlunoDTO();
		dto.setId(aluno.getId());
		dto.setNome(aluno.getNome());
		dto.setEmail(aluno.getEmail());
		return dto;
	}

}
