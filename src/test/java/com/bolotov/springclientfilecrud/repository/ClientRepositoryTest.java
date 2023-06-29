package com.bolotov.springclientfilecrud.repository;

import com.bolotov.springclientfilecrud.entity.Client;
import com.bolotov.springclientfilecrud.entity.File;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientRepositoryTest {

   @Autowired
    ClientRepository clientRepository;

    @Test
    void save() {
        Client client = Client.builder()
                .email("alex@gmail.com")
                .build();

        clientRepository.save(client);
    }

    @Test
    void saveWithFile() {
        List<File> files = new ArrayList<>();
        files.add(File.builder().fileName("zxc").build());
        Client client = Client.builder()
                .email("boris@gmail.com")
                .files(files)
                .build();
        clientRepository.save(client);
    }
}