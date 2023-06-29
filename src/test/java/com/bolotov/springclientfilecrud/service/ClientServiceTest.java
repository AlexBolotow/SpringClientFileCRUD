package com.bolotov.springclientfilecrud.service;

import com.bolotov.springclientfilecrud.dto.ClientDTO;
import com.bolotov.springclientfilecrud.dto.FileDTO;
import com.bolotov.springclientfilecrud.entity.Client;
import com.bolotov.springclientfilecrud.entity.File;
import com.bolotov.springclientfilecrud.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientServiceTest {

    @Autowired
    ClientService clientService;
    @Autowired
    FileService fileService;

    @Test
    void create() {
        FileDTO fileDTO1 = new FileDTO("ssad.txt", Paths.get("files/sun.txt"));
        FileDTO fileDTO2 = new FileDTO("doas.txt", Paths.get("files/dog.txt"));
        FileDTO fileDTO3 = new FileDTO("catd.txt", Paths.get("files/cat.txt"));

        List<File> files = new ArrayList<>();
        Collections.addAll(files, fileService.init(fileDTO1), fileService.init(fileDTO2), fileService.init(fileDTO3));

        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setEmail("igor3@gmail.com");
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
    void deleteClient() {
        FileDTO fileDTO1 = new FileDTO("sun.txt", Paths.get("files/sun.txt"));
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setEmail("tom.gmail.com");
        clientDTO.setFiles(null);
        Client client = clientService.create(clientDTO);

        clientService.deleteClient(client);
    }
/*
    @Test
    void testFindClientsWithFile() {
        //File file = File.builder().fileName("cat").build();
        clientService.findClientsWithFile("cat").forEach(System.out::println);
    }

    @Test
    void updateClient() {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setUsername("c");
        clientDTO.setEmail("g.gmail.com");
        clientDTO.setFiles(null);
        Client client = clientService.create(clientDTO);

        client.setEmail("c.gmail.com");

        client = clientService.updateClient(client);
    }

    @Test
    void addFileToClient() {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setUsername("f");
        clientDTO.setEmail("f.gmail.com");
        clientDTO.setFiles(new ArrayList<File>());
        Client client = clientService.create(clientDTO);

        File file = File.builder().fileName("addedFile").build();
        List<File> files = new ArrayList<>();
        files.add(file);
        System.out.println(files);
        clientService.addFilesToClient(client, files);
    }

    @Test
    void deleteClient() {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setUsername("f");
        clientDTO.setEmail("f.gmail.com");
        clientDTO.setFiles(null);
        Client client = clientService.create(clientDTO);

        clientService.deleteClient(client);
    }*/
}
