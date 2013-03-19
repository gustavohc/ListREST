package br.edu.utfpr.md.emf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created with IntelliJ IDEA.
 * UserList: gu
 * Date: 3/13/13
 * Time: 11:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class EMF {

    private EntityManagerFactory factory = builtEntityManagerFactory();
    private EntityManager manager = null;
    private EntityManagerFactory builtEntityManagerFactory(){
        if(factory==null){
            return Persistence.createEntityManagerFactory("ListREST");
        }else{
            return factory;
        }
    }

    public EntityManager getManager(){
        manager = factory.createEntityManager();
        return manager;
    }
}
