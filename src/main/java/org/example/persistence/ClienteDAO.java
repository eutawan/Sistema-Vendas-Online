package org.example.persistence;

import jakarta.persistence.EntityManager;
import org.example.entity.Cliente;

import java.util.List;

public class ClienteDAO {

    public void salvarCliente(Cliente cliente){
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public Cliente buscarClientePorId(Long id){
        EntityManager em = JPAUtil.getEntityManager();
        Cliente cliente = em.find(Cliente.class, id);
        em.close();
        return cliente;
    }

    public List<Cliente> listarClientes(){
        EntityManager em = JPAUtil.getEntityManager();
        List<Cliente> clientes = em.createQuery("SELECT a FROM Cliente a", Cliente.class).getResultList();
        em.close();
        return clientes;
    }

    public void atualizarCliente(Cliente cliente){
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
