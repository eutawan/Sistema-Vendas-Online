package org.example.persistence;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.example.entity.Produto;
import org.example.entity.Venda;

import java.util.List;


public class ProdutoDAO {
    public void salvarProduto(Produto produto){
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
        em.close();
    }

    public Produto buscarProdutoPorId(Long id){
        EntityManager em = JPAUtil.getEntityManager();
        Produto produto = em.find(Produto.class, id);
        em.close();
        return produto;
    }

    public List<Produto> listarProdutos(){
        EntityManager em = JPAUtil.getEntityManager();
        List<Produto> produtos = em.createQuery("SELECT a FROM Produto a", Produto.class).getResultList();
        em.close();
        return produtos;
    }

    public void atualizarProduto(Produto produto){
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(produto);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
