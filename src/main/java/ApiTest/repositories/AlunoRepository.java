package ApiTest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ApiTest.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
