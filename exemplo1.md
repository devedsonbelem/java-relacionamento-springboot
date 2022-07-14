## bdAluno _ 

mysql ...

use bdaluno;

show tables;
desc aluno;

##Visualizacao

ysql> desc aluno;
+-------------+-------------+------+-----+---------+----------------+
| Field       | Type        | Null | Key | Default | Extra          |
+-------------+-------------+------+-----+---------+----------------+
| id_aluno    | bigint      | NO   | PRI | NULL    | auto_increment |
| email_aluno | varchar(50) | YES  |     | NULL    |                |
| id_contato  | bigint      | YES  |     | NULL    |                |
| nome_aluno  | varchar(50) | YES  |     | NULL    |                |
| status      | varchar(50) | YES  |     | NULL    |                |
+-------------+-------------+------+-----+---------+----------------+
5 rows in set (0,00 sec)


desc disciplina;

mysql> desc disciplina;
+-----------------+-------------+------+-----+---------+----------------+
| Field           | Type        | Null | Key | Default | Extra          |
+-----------------+-------------+------+-----+---------+----------------+
| id_disciplina   | bigint      | NO   | PRI | NULL    | auto_increment |
| media           | double      | YES  |     | NULL    |                |
| nome_disciplina | varchar(50) | YES  |     | NULL    |                |
| nota1           | double      | YES  |     | NULL    |                |
| nota2           | double      | YES  |     | NULL    |                |
| situacao        | double      | YES  |     | NULL    |                |
| aluno_id        | bigint      | YES  | MUL | NULL    |                |
+-----------------+-------------+------+-----+---------+----------------+
7 rows in set (0,02 sec)


desc Contato

mysql> desc contato;
+--------------+-------------+------+-----+---------+----------------+
| Field        | Type        | Null | Key | Default | Extra          |
+--------------+-------------+------+-----+---------+----------------+
| id_contato   | bigint      | NO   | PRI | NULL    | auto_increment |
| bairro       | varchar(50) | YES  |     | NULL    |                |
| caixa_postal | varchar(50) | YES  |     | NULL    |                |
| cidade       | varchar(50) | YES  |     | NULL    |                |
| telefone     | varchar(50) | YES  |     | NULL    |                |
| aluno_id     | bigint      | YES  | MUL | NULL    |                |
+--------------+-------------+------+-----+---------+----------------+
6 rows in set (0,00 sec)

## Observacao resposta do Mysql ...


## Java

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
##public class Aluno implements Serializable {

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
 
#Disciplina

package br.com.arq.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
##private Long idDisciplina;

@JsonProperty(value = "nome-disciplina")
@Column(name = "nomeDisciplina", length = 50)
private String nomeDisciplina;

private Double nota1;

private Double nota2;

private Double situacao;

@JsonProperty(value = "media")
@Column(name = "media", length = 50)
private Double media;

@JsonBackReference(value = "disciplinas")
@ManyToOne()
@JoinColumn(name = "alunoId", referencedColumnName = "idAluno")
private Aluno aluno;

public Disciplina() {

}

@Override
public String toString() {
	return "Disciplina [idDisciplina=" + idDisciplina + ", nomeDisciplina=" + nomeDisciplina + ", media=" + media + "]";
}

public Long getIdDisciplina() {
	return idDisciplina;
}

public void setIdDisciplina(Long idDisciplina) {
	this.idDisciplina = idDisciplina;
}

public String getNomeDisciplina() {
	return nomeDisciplina;
}

public void setNomeDisciplina(String nomeDisciplina) {
	this.nomeDisciplina = nomeDisciplina;
}

public Double getMedia() {
	return media;
}

public void setMedia(Double media) {
	this.media = media;
}

public Aluno getAluno() {
	return aluno;
}

public void setAluno(Aluno aluno) {
	this.aluno = aluno;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

}

 
 
 
## Contato

package br.com.arq.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "contato")
##public class Contato implements Serializable {

private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idContato;
@JsonProperty(value = "caixa-postal")
@Column(name = "caixaPostal", length = 50)
private String caixaPostal;
@Column(length = 50)
private String cidade;
@Column(length = 50)
private String bairro;
@Column(length = 50)
private String telefone;
@OneToOne(cascade = CascadeType.ALL)

// id na frente e Classe (primária) idAluno
// Tabela na frente e Id depois chave estangeira ...

@JoinColumn(name = "alunoId", referencedColumnName = "idAluno")
private Aluno aluno;

public Contato() {
	// TODO Auto-generated constructor stub
}

public Contato(Long idContato, String caixaPostal, String cidade, String bairro, String telefone) {
	super();
	this.idContato = idContato;
	this.caixaPostal = caixaPostal;
	this.cidade = cidade;
	this.bairro = bairro;
	this.telefone = telefone;
}

public Contato(Long idContato, String caixaPostal, String cidade, String bairro, String telefone, Aluno aluno) {
	super();
	this.idContato = idContato;
	this.caixaPostal = caixaPostal;
	this.cidade = cidade;
	this.bairro = bairro;
	this.telefone = telefone;
	this.aluno = aluno;
}

@Override
public String toString() {
	return "Contato [idContato=" + idContato + ", caixaPostal=" + caixaPostal + ", cidade=" + cidade + ", bairro="
			+ bairro + ", telefone=" + telefone + ", aluno=" + aluno + "]";
}

public Long getIdContato() {
	return idContato;
}

public void setIdContato(Long idContato) {
	this.idContato = idContato;
}

public String getCaixaPostal() {
	return caixaPostal;
}

public void setCaixaPostal(String caixaPostal) {
	this.caixaPostal = caixaPostal;
}

public String getCidade() {
	return cidade;
}

public void setCidade(String cidade) {
	this.cidade = cidade;
}

public String getBairro() {
	return bairro;
}

public void setBairro(String bairro) {
	this.bairro = bairro;
}

public String getTelefone() {
	return telefone;
}

public void setTelefone(String telefone) {
	this.telefone = telefone;
}

public Aluno getAluno() {
	return aluno;
}

public void setAluno(Aluno aluno) {
	this.aluno = aluno;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}
	


}

 *************************

# PASSO A PASSO PARA SUBIR O PROJETO NO GIT:
echo "# java-relacionamento-springboot" >> README.md

## Inicia o git no projeto
git init

## Adiciona arquivos ao github
git add .

## Adiciona um come a atualização do projeto
git commit -m "first commit"

## Cria a branch
git branch -M main

## Adiciona o caminho do projeto
git remote add origin git@github.com:devedsonbelem/java-relacionamento-springboot.git

## Remove o caminho origin se já houver um anterior
git remote remove origin

## Sobe os arquivos para a branch main
git push -u origin main


# PARA CRIAR A CHAVE SSH:
ssh-keygen -t rsa -b 4096 -C "devedsonbelem@outlook.com"

## Comando para clonar o projeto 
git clone git@github.com:devedsonbelem/java-relacionamento-springboot.git




