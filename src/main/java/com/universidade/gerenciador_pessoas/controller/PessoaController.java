package com.universidade.gerenciador_pessoas.controller;

import com.universidade.gerenciador_pessoas.dto.PessoaDTO;
import com.universidade.gerenciador_pessoas.entity.Pessoa;
import com.universidade.gerenciador_pessoas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setCpf(pessoaDTO.getCpf());
        pessoa.setIdade(pessoaDTO.getIdade());
        return ResponseEntity.ok(pessoaRepository.save(pessoa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> obterPessoaPorId(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
