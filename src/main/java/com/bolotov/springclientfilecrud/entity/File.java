package com.bolotov.springclientfilecrud.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

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
    @Column(name = "file_name", nullable = false)
    private String fileName;
    @Column(name = "file_bytes")
    private byte[] fileBytes;
    @Column(name = "date_download", nullable = false)
    private LocalDate dateDownload;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return id == file.id && Objects.equals(fileName, file.fileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fileName);
    }
}


