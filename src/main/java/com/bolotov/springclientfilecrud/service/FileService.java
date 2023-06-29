package com.bolotov.springclientfilecrud.service;

import com.bolotov.springclientfilecrud.dto.FileDTO;
import com.bolotov.springclientfilecrud.entity.File;
import com.bolotov.springclientfilecrud.repository.FileRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FileService {
    @Autowired
    private FileRepository fileRepository;

    public File init(FileDTO dto) {
        return File.builder()
                .fileName(dto.getFileName())
                .fileBytes(dto.getFileBytes())
                .build();
    }

    public File create(FileDTO dto) {
        return fileRepository.save(init(dto));
    }


    public File findFile(Long id) {
        return fileRepository.findById(id).get();
    }

    public File findFile(String fileName) {
        return fileRepository.findByFileName(fileName);
    }

    public List<File> findAllFiles() {
        return fileRepository.findAll();
    }

    public void deleteFile(Long id) {
        fileRepository.deleteById(id);
    }

    public void deleteFile(String fileName) {
        fileRepository.deleteByFileName(fileName);
    }
}
