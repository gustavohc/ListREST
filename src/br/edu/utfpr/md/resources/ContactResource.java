package br.edu.utfpr.md.resources;

import br.edu.utfpr.md.dao.ContactDAO;
import br.edu.utfpr.md.pojo.Contact;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import javax.xml.ws.Response;

/**
 * Created with IntelliJ IDEA.
 * User: gu
 * Date: 3/13/13
 * Time: 9:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class ContactResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    String id;

    public ContactResource(UriInfo uriInfo, Request request, String id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Contact getContact(){
        Contact contact = new ContactDAO().getContact(Integer.parseInt(id));
        if(contact==null)
            throw new RuntimeException("Get: the contact with id: "+id+" wasn't found");
        return contact;
    }

    public Response saveContact(){
        return null;
    }
}
