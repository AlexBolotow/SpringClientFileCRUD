package com.bolotov.springclientfilecrud.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "client", schema = "public")
public class Client {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false, unique = true)
    private String email;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    @JoinColumn(name = "client_id")
    private Set<File> files;
    @Column(name = "date_registration", nullable = false)
    private LocalDate dateRegistration;
}
