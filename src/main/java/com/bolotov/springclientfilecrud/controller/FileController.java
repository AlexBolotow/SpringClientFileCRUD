package com.bolotov.springclientfilecrud.controller;

import com.bolotov.springclientfilecrud.dto.FileDTO;
import com.bolotov.springclientfilecrud.entity.File;
import com.bolotov.springclientfilecrud.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/file")
@AllArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping
    public ResponseEntity<File> create(@RequestBody FileDTO dto) {
        return new ResponseEntity<>(fileService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<File>> readAll() {
        return new ResponseEntity<>(fileService.findAllFiles(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<File> read(@PathVariable Long id) {
        return new ResponseEntity<>(fileService.findFile(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        fileService.deleteFile(id);
        return HttpStatus.OK;
    }


}
