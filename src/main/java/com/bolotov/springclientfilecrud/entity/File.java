package com.bolotov.springclientfilecrud.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "file", schema = "public")
public class File {
    @Id
    @GeneratedValue
    @Column(unique = true)
    private long id;
    @Column(name = "file_name", unique = true)
    private String fileName;
    @Column(name = "file_bytes")
    private byte[] fileBytes;
}
