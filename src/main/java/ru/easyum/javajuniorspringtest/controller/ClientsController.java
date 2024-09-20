package ru.easyum.javajuniorspringtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.easyum.javajuniorspringtest.model.dto.ClientCreateDto;
import ru.easyum.javajuniorspringtest.model.dto.ClientGetDto;
import ru.easyum.javajuniorspringtest.model.dto.ClientUpdateDto;
import ru.easyum.javajuniorspringtest.service.ClientsService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/clients")
public class ClientsController {

    @Autowired
    private ClientsService clientsService;

    /**
     *  Создание клиента
     * @param clientDto - данные по клиенту, которого хотим создать
     */
    @PostMapping(value = "/create")
    public ResponseEntity<Void> create(@RequestBody ClientCreateDto clientDto) {
        clientsService.create(clientDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Изменение клиента
     * @param clientDto - данные по клиенту, которого хотим обновить
     */
    @PutMapping(value = "/update")
    public ResponseEntity<Void> update(@RequestBody ClientUpdateDto clientDto) {
        boolean isExist = clientsService.existsById(clientDto.getId());
        if (isExist) {
            clientsService.update(clientDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление клиента
     * @param id идентификатор клиента, который нужно удалить
     */

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") int id) {
        boolean isExist = clientsService.existsById(id);
        if (isExist) {
            clientsService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Получение клиента
     * @param id идентификатор клиента, которого нужно получить
     */
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<ClientGetDto> get(@PathVariable(name = "id") int id) {
        boolean isExist = clientsService.existsById(id);
        if (isExist) {
            return new ResponseEntity<>(clientsService.get(id), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Получение списка клиентов
     */
    @GetMapping(value = "/getAll")
    public ResponseEntity<List<ClientGetDto>> getAll() {
        return new ResponseEntity<>(clientsService.getAll(), HttpStatus.OK);
    }

}
