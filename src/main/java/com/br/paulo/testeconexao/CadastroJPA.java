package com.br.paulo.testeconexao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class CadastroJPA {
    private static final String PERSISTENCE_UNIT = "Cadastro-PU";
    
    private static EntityManager em;
    private static EntityManagerFactory fabrica;
    
    
    public static EntityManager getEntityManager(){
        if(fabrica == null || !fabrica.isOpen())
            fabrica = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        
        if(em == null || !em.isOpen())
            em = fabrica.createEntityManager();

        return em;
    }
        
    public static void closeEtityManager(){
        if(em.isOpen() && em != null){
            em.close();
            fabrica.close();
        }
    }
}
