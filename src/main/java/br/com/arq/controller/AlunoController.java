package br.com.arq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.arq.entity.Aluno;
import br.com.arq.service.AlunoService;

@RestController
@ResponseBody
@RequestMapping(value = "api")
public class AlunoController {

	@Autowired
	private AlunoService service;

	@PostMapping(value = "/save")
	public ResponseEntity<?> gravacao(@RequestBody Aluno aluno) {
		Object obj = service.saveAluno(aluno);
		if (obj instanceof String) {
			return ResponseEntity.status(500).body(obj.toString());
		} else {
			return ResponseEntity.status(200).body(obj.toString());
		}
	}

	@GetMapping(value = "/getAll")
	public ResponseEntity<?> findAll() {
		return ResponseEntity.status(200).body(service.findAll());
	}

}
