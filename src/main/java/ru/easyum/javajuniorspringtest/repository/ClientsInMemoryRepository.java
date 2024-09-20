package ru.easyum.javajuniorspringtest.repository;

import org.springframework.stereotype.Repository;
import ru.easyum.javajuniorspringtest.model.entity.Client;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ClientsInMemoryRepository {
    private final Map<Integer, Client> clients = new HashMap<>();
    private AtomicInteger clientIdCounter = new AtomicInteger();

    public void save(Client client) {
        clients.put(client.getId(), client);
    }

    public boolean existsById(Integer id) {
        return clients.containsKey(id);
    }

    public void deleteById(Integer id) {
        clients.remove(id);
    }

    public Client getById(Integer id) {
        return clients.get(id);
    }

    public List<Client> findAll() {
        return new ArrayList<>(clients.values());
    }
}
