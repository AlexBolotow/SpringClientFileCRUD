package com.bolotov.springclientfilecrud.repository;

import com.bolotov.springclientfilecrud.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
    @Transactional
    File findByFileName(String fileName);
    @Transactional
    void deleteByFileName(String fileName);
}
