package com.bolotov.springclientfilecrud.dto;

import com.bolotov.springclientfilecrud.entity.File;
import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Data
public class FileDTO {
    private String fileName;
    private byte[] fileBytes;

    public FileDTO(String fileName, Path path) {
        setFileName(fileName);
        try {
            setFileBytes(Files.readAllBytes(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
