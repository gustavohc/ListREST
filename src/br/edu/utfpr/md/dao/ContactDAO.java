package br.edu.utfpr.md.dao;

import br.edu.utfpr.md.pojo.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gu
 * Date: 3/11/13
 * Time: 4:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class ContactDAO {

    private final List<Contact> contacts = new ArrayList<>();

    public void save(Contact contact){
        if(contact==null)
            System.out.println("Contact is null!");
        else{
            if(findByName(contact.getName()).equals(contact))
                System.out.println("This object already exist!");
            else{
                contacts.add(contact);
            }
        }
    }

    private void update(String nomeChange, Contact contact){
        Contact c = findByName(nomeChange);
        contacts.remove(c);
        c.setEndereco(contact.getEndereco());
        c.setEmail(contact.getEmail());
        c.setPhone(contact.getPhone());
        contacts.add(c);
    }

    public Contact getContact(int index){
        return contacts.get(index);
    }

    public Contact findByName(String contact){
        for(Contact c : contacts){
            if(c.getName().equals(contact))
                return c;
        }
        return null;
    }

    public List<Contact> findAll(){
        return contacts;
    }
}
