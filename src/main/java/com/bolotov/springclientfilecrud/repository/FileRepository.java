package com.bolotov.springclientfilecrud.repository;

import com.bolotov.springclientfilecrud.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
}
