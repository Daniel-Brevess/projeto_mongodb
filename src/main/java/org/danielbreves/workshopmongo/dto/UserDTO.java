package org.danielbreves.workshopmongo.dto;

import org.danielbreves.workshopmongo.domain.User;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Objects;


public class UserDTO implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    public String id;
    public String name;
    public String email;

    public UserDTO(){}

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


}
