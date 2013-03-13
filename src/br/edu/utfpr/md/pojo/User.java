package br.edu.utfpr.md.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: gu
 * Date: 3/13/13
 * Time: 11:18 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class User {

    @Id
    private Long id;
    private String login;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
