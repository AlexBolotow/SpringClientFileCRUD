package com.bolotov.springclientfilecrud.repository;

import com.bolotov.springclientfilecrud.entity.File;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FileRepositoryTest {

/*    @Autowired
    FileRepository fileRepository;

    @Test
    void save() {
        Path path = Paths.get("files/dog.txt");
        try {
            byte[] fileBytes = Files.readAllBytes(path);

            File file = File.builder()
                    .fileName("dog.txt")
                    .fileBytes(fileBytes)
                    .build();

            fileRepository.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
