package ru.easyum.javajuniorspringtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.easyum.javajuniorspringtest.exceptions.ClientNotFoundException;
import ru.easyum.javajuniorspringtest.model.dto.ClientCreateDto;
import ru.easyum.javajuniorspringtest.model.dto.ClientGetDto;
import ru.easyum.javajuniorspringtest.model.dto.ClientUpdateDto;
import ru.easyum.javajuniorspringtest.model.entity.Client;
import ru.easyum.javajuniorspringtest.model.mappers.ClientsMapper;
import ru.easyum.javajuniorspringtest.repository.ClientsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientsServiceImpl implements ClientsService {

    @Autowired
    private ClientsRepository clientsRepository;
    @Autowired
    private ClientsMapper clientsMapper;

    @Override
    public void create(ClientCreateDto dto) {
        Client client = clientsMapper.fromCreateDtoToEntity(dto);
        clientsRepository.save(client);

    }

    @Override
    public void update(ClientUpdateDto dto) {
        Client client = clientsMapper.fromClientUpdateDtoToEntity(dto);
        clientsRepository.save(client);

    }

    @Override
    public void delete(Integer id) {
        clientsRepository.deleteById(id);
    }

    @Override
    public ClientGetDto get(Integer id) {
        Client client = clientsRepository.findById(id).orElseThrow(()
                -> new ClientNotFoundException("Clint with id " + id + " not found"));
        return clientsMapper.fromEntityToGetDto(client);
    }

    @Override
    public List<ClientGetDto> getAll() {
        return clientsRepository
                .findAll()
                .stream()
                .map(clientsMapper::fromEntityToGetDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsById(Integer id) {
        return clientsRepository.existsById(id);
    }
}
