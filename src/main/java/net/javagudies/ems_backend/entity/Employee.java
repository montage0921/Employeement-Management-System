package net.javagudies.ems_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// use these lombok annotations to automatically generate these methods
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity // write this to make Employee class an entity
@Table(name="employees") // create a table in MySQL database called "employees"
public class Employee {
    @Id // Marks the id field as the primary key of the entity.
    // Specifies that the primary key is generated automatically by the database,
    // typically using an auto-incremented value.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name") // create a column called "first_name" to map the below attribute
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email_id",nullable = false,unique = true) // make this data non-nullable and has to be unique
    private String email;
}
