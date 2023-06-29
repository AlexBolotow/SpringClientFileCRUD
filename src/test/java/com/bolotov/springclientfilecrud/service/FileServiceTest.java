package com.bolotov.springclientfilecrud.service;

import com.bolotov.springclientfilecrud.dto.FileDTO;
import com.bolotov.springclientfilecrud.entity.File;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FileServiceTest {
   @Autowired
   FileService fileService;

   @Test
    void findFile() {
       FileDTO fileDTO = new FileDTO("sun.txt", Paths.get("files/sun.txt"));
       File file = fileService.create(fileDTO);
       System.out.println(fileService.findFile(file.getFileName()));
   }

   @Test
    void deleteFile() {
       FileDTO fileDTO = new FileDTO("grass.txt", Paths.get("files/grass.txt"));
       File file = fileService.create(fileDTO);
       fileService.deleteFile(file.getFileName());
   }

}