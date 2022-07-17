package com.example.swcoaching.config.auth.dto;

import com.example.swcoaching.user.jpa.User;
import lombok.Getter;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Table(name = "SPRING_SESSION")
public class SessionUser implements Serializable {
    private String name;
    @Id
    private String email;
    private String picture;

    public SessionUser(User user) {
        if(user != null)
        {
            this.name = user.getName();
            this.email = user.getEmail();
            this.picture = user.getPicture();
        }
        else
        {
            this.name = null;
            this.email = null;
            this.picture = null;
        }
//        this.name = user.getName();
//        this.email = user.getEmail();
//        this.picture = user.getPicture();
    }
}
