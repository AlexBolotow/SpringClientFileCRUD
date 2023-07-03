package com.bolotov.springclientfilecrud.controller;

import com.bolotov.springclientfilecrud.dto.ClientDTO;
import com.bolotov.springclientfilecrud.entity.Client;
import com.bolotov.springclientfilecrud.entity.File;
import com.bolotov.springclientfilecrud.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {

    private ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody ClientDTO dto) {
        return new ResponseEntity<>(clientService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Client>> readAll() {
        return new ResponseEntity<>(clientService.findAllClients(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> read(@PathVariable Long id) {
        return new ResponseEntity<>(clientService.findClient(id), HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Client> read(@PathVariable String email) {
        return new ResponseEntity<>(clientService.findClient(email), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Client> update(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.updateClient(client), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        clientService.deleteClient(id);
        return HttpStatus.OK;
    }

    @GetMapping("/{id}/{date}/findClientFilesStartingFromDate")
    public ResponseEntity<List<File>> findClientFilesStartingFromDate(@PathVariable Long id, @PathVariable String date) {
        return new ResponseEntity<>(clientService.findClientFilesStartingFromDate(id, LocalDate.parse(date)), HttpStatus.OK);
    }

    @GetMapping("/{fileName}/findClientsWithFile")
    public ResponseEntity<List<Client>> findClientsWithFile(@PathVariable String fileName) {
        return new ResponseEntity<>(clientService.findClientsWithFile(fileName), HttpStatus.OK);
    }

}
