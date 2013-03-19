package br.edu.utfpr.md.resources;

import br.edu.utfpr.md.dao.ContactDAO;
import br.edu.utfpr.md.pojo.Contact;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBElement;


/**
 * Created with IntelliJ IDEA.
 * UserList: gu
 * Date: 3/13/13
 * Time: 9:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class ContactResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    private long id;

    public ContactResource(UriInfo uriInfo, Request request, long id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Contact getContact(){
        Contact contact = new ContactDAO().getContact(id);
        if(contact==null)
            throw new RuntimeException("Get: the contact with id: "+id+" wasn't found");
        return contact;
    }
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response saveContact(JAXBElement<Contact> contactJAXBElement){
        Contact c = contactJAXBElement.getValue();
        return getResponse(c);
    }

    public Response getResponse(Contact contact){
        Response response = null;
        ContactDAO dao = new ContactDAO();
        Contact c = dao.getContact(contact.getId());
        if(c==null)
            response = Response.noContent().build();
        else
            response =  Response.created(uriInfo.getAbsolutePath()).build();
        return response;
    }
}
