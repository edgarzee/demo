package com.example.demo.user.entity;

import com.example.demo.group.entity.Group;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;
import java.util.HashSet;

@Data
@Entity
@Table(name = "USER_ENTITY")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String firstName;
    private String lastName;
    private String email;

    @JsonIgnore
    @ManyToMany(mappedBy = "assignedUsers")
    private Set<Group> groups = new HashSet<>();
}
