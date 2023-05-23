package com.pacote.hibernatetest.DAO;

import com.pacote.hibernatetest.connection.connect;
import com.pacote.hibernatetest.model.Pessoa;

import javax.persistence.EntityManager;
import java.util.List;

public class PessoaDAO {
    public Pessoa salvar (Pessoa pessoa) {
        EntityManager entidade = new connect().getEntidade();
        try {
            entidade.getTransaction().begin();
            if (pessoa.getId() == null) {
                entidade.persist(pessoa);
            } else {
                entidade.merge(pessoa);
            }
            entidade.getTransaction().commit();
        } catch (Exception erro) {
            entidade.getTransaction().rollback();
            System.out.println(erro);
        } finally {
            entidade.close();
        }
        return pessoa;
    }
    public Pessoa findById(Integer id){
        EntityManager em = new connect().getEntidade();
        Pessoa pessoa = null;
        try{
            pessoa = em.find(Pessoa.class, id);
        } catch (Exception e){
            System.out.println(e);
        } finally {
            em.close();
        }
        return pessoa;
    }

    public List<Pessoa> findAll(){
        EntityManager em = new connect().getEntidade();
        List<Pessoa> pessoa = null;
        try {
//usando jpql
            String query = "from Pessoa ";
            pessoa = em.createQuery(query).getResultList();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            em.close();
        }
        return pessoa;
    }

    public Pessoa remove(Integer id){
        EntityManager em = new connect().getEntidade();
        Pessoa pessoa = null;
        try {
            pessoa = em.find(Pessoa.class, id);
            em.getTransaction().begin();
            em.remove(pessoa);
            em.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return pessoa;
    }
}
