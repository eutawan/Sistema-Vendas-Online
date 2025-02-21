package org.example;

import org.example.entity.Cliente;
import org.example.entity.Produto;
import org.example.persistence.ClienteDAO;
import org.example.persistence.ProdutoDAO;

public class Main {
    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto1 = new Produto();
        produto1.setNome("Notebook");
        produtoDAO.salvarProduto(produto1);

    }
}