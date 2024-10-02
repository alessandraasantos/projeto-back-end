package com.universidade.gerenciador_pessoas.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pessoa", schema = "gerenciador_pessoas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String cpf;

    @Column(nullable = false)
    private int idade;
}

