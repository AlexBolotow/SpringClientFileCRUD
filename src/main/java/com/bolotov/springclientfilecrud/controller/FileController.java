package com.bolotov.springclientfilecrud.controller;

import com.bolotov.springclientfilecrud.dto.FileDTO;
import com.bolotov.springclientfilecrud.mapper.FileMapper;
import com.bolotov.springclientfilecrud.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/file")
@AllArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping
    public ResponseEntity<FileDTO> create(@RequestBody FileDTO dto) {
        return new ResponseEntity<>(FileMapper.INSTANCE.fileToFileDTO(fileService.create(dto)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FileDTO>> readAll() {
        return new ResponseEntity<>(fileService.findAllFiles().stream()
                .map(FileMapper.INSTANCE::fileToFileDTO)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FileDTO> read(@PathVariable Long id) {
        return new ResponseEntity<>(FileMapper.INSTANCE.fileToFileDTO(fileService.findFile(id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        fileService.deleteFile(id);
        return HttpStatus.OK;
    }
}
