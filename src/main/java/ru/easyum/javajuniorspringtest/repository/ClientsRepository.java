package ru.easyum.javajuniorspringtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.easyum.javajuniorspringtest.model.entity.Client;

@Repository
public interface ClientsRepository extends JpaRepository<Client, Integer> {

}
