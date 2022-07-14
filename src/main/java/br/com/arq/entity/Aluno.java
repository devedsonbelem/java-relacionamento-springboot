package br.com.arq.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idAluno;

@JsonProperty(value = "nome-aluno")
@Column(name = "nomeAluno", length = 50)
private String nomeAluno;

@JsonProperty(value = "email-aluno")
@Column(name = "emailAluno", length = 50)
private String emailAluno;

@JsonProperty(value = "status")
@Column(name = "status", length = 50)
private String status;

// Relacionamento Bidirecional
@OneToMany(mappedBy = "aluno", cascade = { CascadeType.ALL })
private Set<Disciplina> disciplinas = new HashSet<>();

// Mais Importante (Tabela Agregadora)
// Não posso chamar contato pr objeto
// só posso chamar contato por chave...
private Long idContato;

public Aluno() {
	// TODO Auto-generated constructor stub
}

public Aluno(Long idAluno, String nomeAluno, String emailAluno, String status, Set<Disciplina> disciplinas,
		Long idContato) {
	super();
	this.idAluno = idAluno;
	this.nomeAluno = nomeAluno;
	this.emailAluno = emailAluno;
	this.status = status;
	this.disciplinas = disciplinas;
	this.idContato = idContato;
}

@Override
public String toString() {
	return "Aluno [idAluno=" + idAluno + ", nomeAluno=" + nomeAluno + ", emailAluno=" + emailAluno + ", status="
			+ status + ", disciplinas=" + disciplinas + ", idContato=" + idContato + "]";
}

public Long getIdAluno() {
	return idAluno;
}

public void setIdAluno(Long idAluno) {
	this.idAluno = idAluno;
}

public String getNomeAluno() {
	return nomeAluno;
}

public void setNomeAluno(String nomeAluno) {
	this.nomeAluno = nomeAluno;
}

public String getEmailAluno() {
	return emailAluno;
}

public void setEmailAluno(String emailAluno) {
	this.emailAluno = emailAluno;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public Set<Disciplina> getDisciplinas() {
	return disciplinas;
}

public void setDisciplinas(Set<Disciplina> disciplinas) {
	this.disciplinas = disciplinas;
}

public Long getIdContato() {
	return idContato;
}

public void setIdContato(Long idContato) {
	this.idContato = idContato;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

}
