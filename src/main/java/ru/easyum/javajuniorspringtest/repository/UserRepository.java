package ru.easyum.javajuniorspringtest.repository;

import org.springframework.data.repository.CrudRepository;
import ru.easyum.javajuniorspringtest.model.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
