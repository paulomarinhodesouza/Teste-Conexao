package com.br.paulo.testeconexao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;

public class UsuarioDAO {
    public static void cadastrar(Usuario u){
        EntityManager em = CadastroJPA.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
            
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }
        finally{
            CadastroJPA.closeEtityManager();
        }
    }
    
    public static ArrayList<Usuario> listarProdutos(){
        EntityManager em = CadastroJPA.getEntityManager();
        try{
            em.getTransaction().begin();
            Query consulta = em.createQuery("SELECT usuario FROM Usuario usuario");
            ArrayList<Usuario> lista = (ArrayList<Usuario>) consulta.getResultList();
            em.getTransaction().commit();
            return lista;
        }catch(Exception e){
            return null;
        }finally{
            CadastroJPA.closeEtityManager();
        }
    }
}
