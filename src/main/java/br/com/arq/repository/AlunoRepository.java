package br.com.arq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.arq.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
