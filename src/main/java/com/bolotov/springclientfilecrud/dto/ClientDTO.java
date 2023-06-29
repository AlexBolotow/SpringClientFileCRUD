package com.bolotov.springclientfilecrud.dto;

import com.bolotov.springclientfilecrud.entity.File;
import lombok.Data;

import java.util.List;

@Data
public class ClientDTO {
    private String email;
    private List<File> files;
}
