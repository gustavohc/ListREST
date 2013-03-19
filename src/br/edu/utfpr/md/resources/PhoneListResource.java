package br.edu.utfpr.md.resources;

import br.edu.utfpr.md.dao.ContactDAO;
import br.edu.utfpr.md.pojo.Contact;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * UserList: gu
 * Date: 3/13/13
 * Time: 10:49 AM
 * To change this template use File | Settings | File Templates.
 */

//My default class, is the class that have access in the URL
//the class contatcResource don't have access by the Path
@Path("/agenda")
public class PhoneListResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    private ContactDAO dao = new ContactDAO();

    @GET
    @Produces({MediaType.APPLICATION_XML})
    public List<Contact> getContacts(){
        return new ArrayList<Contact>(dao.findAll());
    }
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newContact(@FormParam("name") String name, @FormParam("phone") String phone, @FormParam("email") String email,
            @FormParam("endereco") String endereco){
        Contact contact = new Contact(name,phone,email,endereco);
        ContactDAO dao = new ContactDAO();
        dao.save(contact);
    }
    @Path("{contact}")
    public ContactResource getContact(@PathParam("contact") long id){
        return new ContactResource(uriInfo, request,id);
    }
}
