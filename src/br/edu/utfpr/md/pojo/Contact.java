package br.edu.utfpr.md.pojo;

/**
 * Created with IntelliJ IDEA.
 * User: gu
 * Date: 3/11/13
 * Time: 4:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class Contact {

    private long id;
    private String name;
    private String phone;
    private String email;
    private String endereco;

    public Contact() {}

    public Contact(long id, String name, String phone, String email, String endereco) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.endereco = endereco;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (id != contact.id) return false;
        if (!email.equals(contact.email)) return false;
        if (!endereco.equals(contact.endereco)) return false;
        if (!name.equals(contact.name)) return false;
        if (!phone.equals(contact.phone)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + endereco.hashCode();
        return result;
    }
}
