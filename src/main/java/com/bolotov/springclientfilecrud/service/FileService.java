package com.bolotov.springclientfilecrud.service;

import com.bolotov.springclientfilecrud.dto.FileDTO;
import com.bolotov.springclientfilecrud.entity.File;
import com.bolotov.springclientfilecrud.mapper.FileMapper;
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

    @Transactional
    public File create(FileDTO dto) {
        if (dto.getCreateDate() == null) {
            dto.setCreateDate(LocalDate.now());
        }

        File file = FileMapper.INSTANCE.fileDTOtoFile(dto);
        System.out.println(file);
        return fileRepository.save(file);
    }

    @Transactional
    public File findFile(Long id) {
        return fileRepository.findById(id).get();
    }

    @Transactional
    public List<File> findAllFiles() {
        return fileRepository.findAll();
    }

    @Transactional
    public void deleteFile(Long id) {
        fileRepository.deleteById(id);
    }

    @Transactional
    public List<File> findFileByClientId(Long id) {
        return fileRepository.findFileByClientId(id);
    }
}
