package com.bolotov.springclientfilecrud.service;

import com.bolotov.springclientfilecrud.dto.FileDTO;
import com.bolotov.springclientfilecrud.entity.File;
import com.bolotov.springclientfilecrud.repository.FileRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class FileService {
    @Autowired
    private FileRepository fileRepository;

    public File init(FileDTO dto) {
        if (dto.getDateDownload() == null) {
            dto.setDateDownload(LocalDate.now());
        }
        return File.builder()
                .fileName(dto.getFileName())
                .fileBytes(dto.getFileBytes())
                .dateDownload(dto.getDateDownload())
                .build();
    }

    public File create(FileDTO dto) {
        return fileRepository.save(init(dto));
    }

    public File findFile(Long id) {
        return fileRepository.findById(id).get();
    }

    public List<File> findAllFiles() {
        return fileRepository.findAll();
    }

    @Transactional
    public void deleteFile(Long id) {
        fileRepository.deleteById(id);
    }
}
