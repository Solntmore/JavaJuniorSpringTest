package ru.easyum.javajuniorspringtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.easyum.javajuniorspringtest.model.entity.Client;

import java.util.List;

@Repository
public interface ClientsRepository extends JpaRepository<Client, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM Client WHERE NAME LIKE '%:name%'")
    List<Client> findAllWhereNameContain(@Param("name") String name);

    @Query("SELECT c FROM Client c WHERE c.name LIKE '%:name%'")
    List<Client> findAllWhereNameContainSymbol(@Param("name") String name);

    List<Client> findAllByNameContains(String name);
}


