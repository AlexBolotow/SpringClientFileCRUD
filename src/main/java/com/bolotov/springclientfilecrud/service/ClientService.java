package com.bolotov.springclientfilecrud.service;

import com.bolotov.springclientfilecrud.dto.ClientDTO;
import com.bolotov.springclientfilecrud.entity.Client;
import com.bolotov.springclientfilecrud.entity.File;
import com.bolotov.springclientfilecrud.repository.ClientRepository;
import com.bolotov.springclientfilecrud.repository.FileRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private FileService fileService;

    public Client create(ClientDTO dto) {
        return clientRepository.save(Client.builder()
                .email(dto.getEmail())
                .files(dto.getFiles())
                .build());
    }

    public Client findClient(Long id) {
        return clientRepository.findById(id).get();
    }

    public Client findClient(String email) {
        return clientRepository.findByEmail(email);
    }

    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

    public List<Client> findClientsWithFile(String fileName) {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().
                filter(c -> c.getFiles()
                        .stream()
                        .map(f -> f.getFileName())
                        .anyMatch(f -> f.equals(fileName)))
                .collect(Collectors.toList());
    }

    public void addFilesToClient(Client client, List<File> files) {
        if (client.getFiles() == null) {
            client.setFiles(new ArrayList<>());
        }

        client.getFiles().addAll(files);
        updateClient(client);
    }
}
