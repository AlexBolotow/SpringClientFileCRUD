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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientRepositoryTest {

   @Autowired
    ClientRepository clientRepository;

    @Test
    void save() {
        Client client = Client.builder()
                .email("alex@gmail.com")
                .dateRegistration(LocalDate.now())
                .build();

        clientRepository.save(client);
    }

    @Test
    void saveWithFile() {
        Set<File> files = new HashSet<>();
        files.add(File.builder().fileName("zxc").build());
        Client client = Client.builder()
                .email("boris@gmail.com")
                .dateRegistration(LocalDate.now())
                .files(files)
                .build();
        clientRepository.save(client);
    }
}