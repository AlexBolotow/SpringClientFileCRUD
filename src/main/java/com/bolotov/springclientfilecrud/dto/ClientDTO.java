package com.bolotov.springclientfilecrud.dto;

import com.bolotov.springclientfilecrud.entity.File;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class ClientDTO {
    private String email;
    private Set<File> files;
    private LocalDate registrationDate;
}
