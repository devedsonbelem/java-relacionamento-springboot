package br.com.arq.interfaces;

import java.util.Collection;

import br.com.arq.entity.Aluno;

public interface IAlunoService {

	
	public Object saveAluno(Aluno a);
	
	public Collection<Aluno> findAll();
	
	
}
