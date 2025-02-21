package org.example.persistence;

import jakarta.persistence.EntityManager;
import org.example.entity.Pagamento;

import java.util.List;

public class PagamentoDAO {
    public void salvarPagamento(Pagamento pagamento){
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(pagamento);
        em.getTransaction().commit();
        em.close();
    }

    public List<Pagamento> listarPagamentos(){
        EntityManager em = JPAUtil.getEntityManager();
        List<Pagamento> pagamentos = em.createQuery("SELECT a FROM Pagamento a", Pagamento.class).getResultList();
        em.close();
        return pagamentos;
    }


}
