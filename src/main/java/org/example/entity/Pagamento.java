package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double valorPago;

    private String formaPagamento, status;

    @ManyToOne
    private Venda venda;

}
