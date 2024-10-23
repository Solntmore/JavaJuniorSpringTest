package ru.easyum.javajuniorspringtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.easyum.javajuniorspringtest.model.entity.Car;
import ru.easyum.javajuniorspringtest.model.entity.Client;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findAllByClientId(int clientId);
}


