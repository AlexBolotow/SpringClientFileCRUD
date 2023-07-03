package com.bolotov.springclientfilecrud.service;

import com.bolotov.springclientfilecrud.dto.FileDTO;
import com.bolotov.springclientfilecrud.entity.File;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FileServiceTest {
/*    @Autowired
    FileService fileService;

    @Test
    void findFile() throws IOException {
        FileDTO fileDTO1 = new FileDTO();
        fileDTO1.setFileName("dog.txt");
        fileDTO1.setCreateDate(LocalDate.now());
        fileDTO1.setFileBytes(Files.readAllBytes(Paths.get("files/dog.txt")));

        File file = fileService.create(fileDTO1);
        System.out.println(fileService.findFile(file.getId()));
    }

    @Test
    void deleteFile() throws IOException {
        FileDTO fileDTO1 = new FileDTO();
        fileDTO1.setFileName("dog.txt");
        fileDTO1.setCreateDate(LocalDate.now());
        fileDTO1.setFileBytes(Files.readAllBytes(Paths.get("files/dog.txt")));

        File file = fileService.create(fileDTO1);
        fileService.deleteFile(file.getId());
    }*/

}