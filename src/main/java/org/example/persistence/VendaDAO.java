package org.example.persistence;

import jakarta.persistence.EntityManager;
import org.example.entity.Venda;

import java.util.List;

public class VendaDAO {
    public void salvarVenda(Venda venda){
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(venda);
        em.getTransaction().commit();
        em.close();
    }

    public Venda buscarVendaPorId(Long id){
        EntityManager em = JPAUtil.getEntityManager();
        Venda venda = em.find(Venda.class, id);
        em.close();
        return venda;
    }

}
