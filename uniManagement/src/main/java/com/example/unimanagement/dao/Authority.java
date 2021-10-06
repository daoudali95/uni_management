package com.example.unimanagement.dao;

import com.sun.istack.NotNull;
import org.hibernate.annotations.NotFound;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authority")
public class Authority {

    @Id
    @Column(length = 50)
    private String name;

  // @ManyToMany(mappedBy = "authorized_User")
 //  private Set<User> Users = new HashSet<>();
//   private Collection<Authority> Users;

    public Authority() {
    }

    public String getName() {
        return name;
    }

    public void setName(String authority) {
        this.name = authority;
    }
}
