package com.example.demo.domain.user;

import com.example.demo.core.generic.AbstractEntity;
import com.example.demo.domain.blogpost.Blogpost;
import com.example.demo.domain.role.Role;

import java.util.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class User extends AbstractEntity {
  @Column(name = "first_name")
  @Size(min = 2, max = 20)
  @NotNull
  private String firstName;

  @Column(name = "last_name")
  @Size(min = 2, max = 20)
  @NotNull
  private String lastName;

  @Column(name = "email", unique = true, nullable = false)
  @Size(min = 1, max = 200)
  @NotNull
  private String email;

  @Column(name = "password")
  @Size(min = 4, max = 200)
  @NotNull
  private String password;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "users_role", joinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id"),
             inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
  private Set<Role> roles = new HashSet<>();

  @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Blogpost> blogposts = new ArrayList<>();

  public User(UUID id, String firstName, String lastName, String email, String password, Set<Role> roles, ArrayList<Blogpost> blogposts) {
    super(id);
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.roles = roles;
    this.blogposts = blogposts;
  }
}
