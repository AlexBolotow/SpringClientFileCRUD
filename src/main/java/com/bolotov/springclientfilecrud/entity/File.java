package com.bolotov.springclientfilecrud.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "file", schema = "public")
public class File {
    @Id
    @GeneratedValue
    @Column(unique = true)
    private long id;
    @Column(name = "file_name", nullable = false)
    private String fileName;
    @Column(name = "file_bytes")
    private byte[] fileBytes;
    @Column(name = "create_date", nullable = false)
    private LocalDate createDate;
    @Column(name = "client_id")
    private long clientId;

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return id == file.id && Objects.equals(fileName, file.fileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fileName);
    }*/
}


