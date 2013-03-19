package br.edu.utfpr.md.teste;

import br.edu.utfpr.md.dao.ContactDAO;
import br.edu.utfpr.md.pojo.Contact;

/**
 * Created with IntelliJ IDEA.
 * UserList: gu
 * Date: 3/15/13
 * Time: 9:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class Create {
    public static void main(String[] args) {
        Contact contact = new Contact();
        contact.setName("Gustavo Henrique");
        contact.setEmail("gustavo@gmail.com");
        contact.setPhone("003939303");
        contact.setEndereco("Rua de Tal");
        ContactDAO dao = new ContactDAO();
        dao.save(contact);
        for(Contact c : dao.findAll()){
            System.out.println(c.getName()+" "+c.getEmail()+" "+c.getPhone()+" "+c.getEndereco());
        }
    }
}
