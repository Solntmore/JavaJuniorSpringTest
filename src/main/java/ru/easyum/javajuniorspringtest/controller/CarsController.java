package ru.easyum.javajuniorspringtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.easyum.javajuniorspringtest.model.dto.CarGetDto;
import ru.easyum.javajuniorspringtest.model.dto.ClientCreateDto;
import ru.easyum.javajuniorspringtest.model.dto.ClientGetDto;
import ru.easyum.javajuniorspringtest.model.dto.ClientUpdateDto;
import ru.easyum.javajuniorspringtest.service.CarService;
import ru.easyum.javajuniorspringtest.service.ClientsService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/cars")
public class CarsController {
    @Autowired
    private ClientsService clientsService;
    @Autowired
    private CarService carService;

    /**
     * Получение клиента
     * @param id идентификатор клиента, которого нужно получить
     */
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<List<CarGetDto>> get(@PathVariable(name = "id") int id) {
        boolean isExist = clientsService.existsById(id);
        if (isExist) {
            return new ResponseEntity<>(carService.getCarsByClientId(id), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
