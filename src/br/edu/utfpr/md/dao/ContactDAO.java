package br.edu.utfpr.md.dao;

import br.edu.utfpr.md.emf.EMF;
import br.edu.utfpr.md.pojo.Contact;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gu
 * Date: 3/11/13
 * Time: 4:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class ContactDAO extends EMF{

    private EntityManager manager;

    public ContactDAO() {
        manager = getManager();
    }

    public void save(Contact contact){
        if(contact==null)
            System.out.println("Contact is null!");
        else{
            manager.getTransaction().begin();
            manager.persist(contact);
            manager.getTransaction().commit();
        }
    }

    private void update(Contact contact){
        manager.getTransaction().begin();
        manager.merge(contact);
        manager.getTransaction().commit();
    }

    public Contact getContact(long index){
        Query query = manager.createQuery("select c from Contact c where c.id = :id");
        query.setParameter("id", index);
        return (Contact) query.getSingleResult();
    }

    public Contact findByName(String contact){
        Query query = manager.createQuery("SELECT c FROM Contact c WHERE c.name LIkE :name");
        query.setParameter("name", contact);
        return (Contact) query.getSingleResult();
    }

    public List<Contact> findAll(){
        Query query = manager.createQuery("select c from Contact c");
        return query.getResultList();
    }
}
