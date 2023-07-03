package com.bolotov.springclientfilecrud.controller;

import com.bolotov.springclientfilecrud.dto.ClientDTO;
import com.bolotov.springclientfilecrud.dto.FileDTO;
import com.bolotov.springclientfilecrud.entity.Client;
import com.bolotov.springclientfilecrud.mapper.ClientMapper;
import com.bolotov.springclientfilecrud.mapper.FileMapper;
import com.bolotov.springclientfilecrud.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {

    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDTO> create(@RequestBody ClientDTO dto) {
        return new ResponseEntity<>(ClientMapper.INSTANCE.clientToClientDTO(clientService.create(dto)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> readAll() {
        return new ResponseEntity<>(clientService.findAllClients().stream()
                .map(ClientMapper.INSTANCE::clientToClientDTO)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> read(@PathVariable Long id) {
        return new ResponseEntity<>(ClientMapper.INSTANCE.clientToClientDTO(clientService.findClient(id)), HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<ClientDTO> read(@PathVariable String email) {
        return new ResponseEntity<>(ClientMapper.INSTANCE.clientToClientDTO(clientService.findClient(email)), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<ClientDTO> update(@RequestBody Client client) {
        return new ResponseEntity<>(ClientMapper.INSTANCE.clientToClientDTO(clientService.updateClient(client)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        clientService.deleteClient(id);
        return HttpStatus.OK;
    }

    @GetMapping("{id}/files")
    public ResponseEntity<List<FileDTO>> findClientFiles(@PathVariable Long id,
                                                         @RequestParam(value = "startDate", required = false) String startDate) {
        Client client = clientService.findClient(id);
        if (startDate == null) {
            return new ResponseEntity<>(client.getFiles()
                    .stream()
                    .map(FileMapper.INSTANCE::fileToFileDTO)
                    .collect(Collectors.toList()), HttpStatus.OK);
        }

        return new ResponseEntity<>(
                clientService.findClientFilesStartingFromDate(id, LocalDate.parse(startDate))
                        .stream()
                .map(FileMapper.INSTANCE::fileToFileDTO)
                .collect(Collectors.toList()), HttpStatus.OK);
    }
}
