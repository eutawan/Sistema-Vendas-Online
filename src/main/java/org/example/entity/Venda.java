package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataVenda;

    @ManyToOne
    private Cliente cliente;

    @ManyToMany
     private List<Produto> produtos;


}
