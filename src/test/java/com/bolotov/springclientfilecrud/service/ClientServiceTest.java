package com.bolotov.springclientfilecrud.service;

import com.bolotov.springclientfilecrud.dto.ClientDTO;
import com.bolotov.springclientfilecrud.dto.FileDTO;
import com.bolotov.springclientfilecrud.entity.Client;
import com.bolotov.springclientfilecrud.entity.File;
import com.bolotov.springclientfilecrud.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientServiceTest {

/*    @Autowired
    ClientService clientService;
    @Autowired
    FileService fileService;

    @Test
    void create() throws IOException {
        FileDTO fileDTO1 = new FileDTO();
        fileDTO1.setFileName("dog.txt");
        fileDTO1.setCreateDate(LocalDate.now());
        fileDTO1.setFileBytes(Files.readAllBytes(Paths.get("files/dog.txt")));

        FileDTO fileDTO2 = new FileDTO();
        fileDTO2.setFileName("cat.txt");
        fileDTO2.setCreateDate(LocalDate.now());
        fileDTO2.setFileBytes(Files.readAllBytes(Paths.get("files/cat.txt")));

        FileDTO fileDTO3 = new FileDTO();
        fileDTO3.setFileName("sky.txt");
        fileDTO3.setCreateDate(LocalDate.now());
        fileDTO3.setFileBytes(Files.readAllBytes(Paths.get("files/sky.txt")));

        Set<File> files = new HashSet<>();
        Collections.addAll(files, fileService.init(fileDTO1), fileService.init(fileDTO2), fileService.init(fileDTO3));

        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setEmail("tom@gmail.com");
        clientDTO.setRegistrationDate(LocalDate.of(2002, 1, 13));
        clientDTO.setFiles(files);
        clientService.create(clientDTO);
    }

    @Test
    void findClient() {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setEmail("oleg@gmail.com");
        clientService.create(clientDTO);

        System.out.println(clientService.findClient("oleg@gmail.com"));
    }

    @Test
    void updateClient() {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setEmail("anna.gmail.com");
        clientDTO.setFiles(null);
        Client client = clientService.create(clientDTO);

        client.setEmail("olga.gmail.com");

        client = clientService.updateClient(client);
    }

    @Test
    void deleteClient() throws IOException {
        FileDTO fileDTO1 = new FileDTO();
        fileDTO1.setFileName("dog.txt");
        fileDTO1.setCreateDate(LocalDate.now());
        fileDTO1.setFileBytes(Files.readAllBytes(Paths.get("files/dog.txt")));

        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setEmail("toxm.gmail.com");
        Client client = clientService.create(clientDTO);

        clientService.deleteClient(client);
    }

    @Test
    void addFilesToClient() {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setEmail("x.gmail.com");
        Client client = clientService.create(clientDTO);

        File file1 = File.builder().fileName("addedFile1").createDate(LocalDate.now()).build();
        File file2 = File.builder().fileName("addedFile2").createDate(LocalDate.now()).build();
        File file3 = File.builder().fileName("addedFile1").createDate(LocalDate.now()).build();
        Set<File> files = new HashSet<>();
        files.add(file1);
        files.add(file2);
        files.add(file3);
        clientService.addFilesToClient(client, files);
    }

    @Test
    void findClientsWithFile() {
        //File file = File.builder().fileName("cat").build();
        clientService.findClientsWithFile("ssad.txt").forEach(System.out::println);
    }

    @Test
    void findClientsByDateRegistration() {
        clientService.findClientsByDateRegistration(LocalDate.of(2002, 1, 13))
                .forEach(System.out::println);
    }

    @Test
    void findClientFilesStartingFromDate() {
        clientService.findClientFilesStartingFromDate(127L, LocalDate.of(2023, 6, 29))
                .forEach(System.out::println);
    }*/
}
