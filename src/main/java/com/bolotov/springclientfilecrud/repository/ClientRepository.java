package com.bolotov.springclientfilecrud.repository;

import com.bolotov.springclientfilecrud.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmail(String email);
    Client deleteByEmail(String email);
}
