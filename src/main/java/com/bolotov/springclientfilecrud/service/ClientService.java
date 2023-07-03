package com.bolotov.springclientfilecrud.service;

import com.bolotov.springclientfilecrud.dto.ClientDTO;
import com.bolotov.springclientfilecrud.entity.Client;
import com.bolotov.springclientfilecrud.entity.File;
import com.bolotov.springclientfilecrud.mapper.ClientMapper;
import com.bolotov.springclientfilecrud.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private FileService fileService;

    @Transactional
    public Client create(ClientDTO dto) {
        if (dto.getRegistrationDate() == null) {
            dto.setRegistrationDate(LocalDate.now());
        }

        Client client = ClientMapper.INSTANCE.clientDTOtoClient(dto);
        return clientRepository.save(client);
    }

    @Transactional
    public Client findClient(Long id) {
        return clientRepository.findById(id).get();
    }

    @Transactional
    public Client findClient(String email) {
        return clientRepository.findByEmail(email);
    }

    @Transactional
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    @Transactional
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    @Transactional
    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

    @Transactional
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Transactional
    public void addFilesToClient(Client client, Set<File> files) {
        if (client.getFiles() == null) {
            client.setFiles(new HashSet<>());
        }

        client.getFiles().addAll(files);
        updateClient(client);
    }

    @Transactional
    public List<Client> findClientsWithFile(String fileName) {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().
                filter(c -> c.getFiles()
                        .stream()
                        .map(f -> f.getFileName())
                        .anyMatch(f -> f.equals(fileName)))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<Client> findClientsByDateRegistration(LocalDate localDate) {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().
                filter(c -> c.getRegistrationDate()
                        .equals(localDate))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<File> findClientFilesStartingFromDate(Long id, LocalDate localDate) {
        Client client = findClient(id);
        return client.getFiles()
                .stream()
                .filter(f ->f.getCreateDate()
                        .isAfter(localDate))
                .collect(Collectors.toList());
    }
}
