package br.com.arq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlunoApplication{
 //implements CommandLineRunner {
	
 //   @Autowired
///	private AlunoRepository repository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(AlunoApplication.class, args);
	}
 	/*
	@Override
	public void run(String... args) throws Exception {
		try {
			  Aluno aluno = new Aluno(null,"porfirio","porfirio@gmail.com","ativo");
			  Set<Disciplina> disciplinas = new HashSet<>();
			  disciplinas.add(new Disciplina(null,"java",9.8));
			  disciplinas.add(new Disciplina(null,"oracle",10.));
			  
			  for (Disciplina item : disciplinas) {
				  item.setAluno(aluno);
			  } ///  AS duas disciplinas irão setar o Aluno
			  
			  aluno.setDisciplinas(disciplinas);
			  
			  repository.save(aluno);
			  System.out.println("Aluno Gravado");
			  
		  }catch(Exception ex) {
			  System.out.println("Error :" + ex.getMessage());
		  }
	}
*/
}
