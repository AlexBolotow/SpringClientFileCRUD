package com.bolotov.springclientfilecrud.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FileDTO {
    private String fileName;
    private byte[] fileBytes;
    private LocalDate dateDownload;
}
