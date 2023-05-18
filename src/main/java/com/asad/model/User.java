package com.asad.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usersDTO")
public class User {
    @Id
    @GeneratedValue(generator="user_id_sequence")
    @SequenceGenerator(name="user_id_sequence",
            sequenceName="user_id_sequence", allocationSize=1)
    private long id;
    public String email;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    private String password;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "location_id")
    private Location location;
}
