package ApiTest.entities.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AlunoDTO {
	
	private Long id;
	private String nome;
	private String email;
	
	
	
	public AlunoDTO(Long id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
	
	}

}
