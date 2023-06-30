package com.bolotov.springclientfilecrud.controller;

import com.bolotov.springclientfilecrud.dto.ClientDTO;
import com.bolotov.springclientfilecrud.entity.Client;
import com.bolotov.springclientfilecrud.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PutMapping
    public ResponseEntity<Client> update(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.updateClient(client), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        clientService.deleteClient(id);
        return HttpStatus.OK;
    }
}
