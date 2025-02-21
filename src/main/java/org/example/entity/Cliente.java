package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Cliente {
    @Id
    private Long id;
    private String nome;
    private String email;
    private String endereco;
}
