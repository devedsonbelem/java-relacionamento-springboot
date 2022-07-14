package br.com.arq.service;

import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.arq.entity.Aluno;
import br.com.arq.entity.Disciplina;
import br.com.arq.interfaces.IAlunoService;
import br.com.arq.repository.AlunoRepository;

@Service
public class AlunoService implements IAlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	// to cuidado do mundo ( resgatando Varias Disciplinas, Contacto) _ Aluno
	@Override
	public Object saveAluno(Aluno aluno) {
		try {
			// antes de gravar você distribui, bidirecional
			Set<Disciplina> disciplinas = aluno.getDisciplinas();
			for (Disciplina objDisciplina : disciplinas) {
				objDisciplina.setAluno(aluno); // chave estrangeira.
			}

			Aluno alunoResposta = alunoRepository.save(aluno); // resp é a chave primária do aluno
			if (alunoResposta == null) {
				throw new Exception("Error na Gravacao");
			}
			return alunoResposta;
		} catch (Exception ex) {
			return "error de gravacao:" + ex.getMessage();
		}

	}

	@Override
	public Collection<Aluno> findAll() {
		return alunoRepository.findAll();
	}

}
