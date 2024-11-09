package ru.easyum.javajuniorspringtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.easyum.javajuniorspringtest.model.dto.*;
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
     *
     * @param id идентификатор клиента, которого нужно получить
     */
    @GetMapping(value = "/getCarsByClientId/{id}")
    public ResponseEntity<List<CarGetDto>> getCarsByClientId(@PathVariable(name = "id") int id) {
        boolean isExist = clientsService.existsById(id);
        if (isExist) {
            return new ResponseEntity<>(carService.getCarsByClientId(id), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Получение автомобиля по идентификатору
     *
     * @param id идентификатор автомобиля
     * @return информацию по автомобилю
     */
    @GetMapping(value = "/getCarById/{id}")
    public ResponseEntity<CarGetDto> getCarById(@PathVariable(name = "id") int id) {
        boolean isExist = carService.existsById(id);
        if (isExist) {
            return new ResponseEntity<>(carService.getCarById(id), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Получение списка всех автомобилей
     *
     * @return список автомобилей
     */
    @GetMapping(value = "/getAllCars")
    public ResponseEntity<List<CarGetDto>> getAllCars() {
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

    /**
     * Создание автомобиля
     * @param carDto данные об автомобиле, который нужно создать
     */
    @PostMapping(value = "/createCar")
    public ResponseEntity<Void> createCar(@RequestBody CarCreateDto carDto) {
        boolean isExist = clientsService.existsById(carDto.getClientId());
        if (isExist) {
            carService.createCar(carDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Обновление автомобиля
     * @param carDto данные об автомобиле, которые нужно обновить
     */
    @PutMapping(value = "/updateCar")
    public ResponseEntity<Void> updateCar(@RequestBody CarUpdateDto carDto) {
        boolean isCarExist = carService.existsById(carDto.getId());
        if (!isCarExist) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

        boolean isClientExist = clientsService.existsById(carDto.getClientId());
        if (!isClientExist) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        carService.updateCar(carDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Удаление автомобиля
     * @param id идентификатор автомобиля, который нужно удалить
     */
    @DeleteMapping(value = "/deleteCar/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable(name = "id") int id) {
        boolean isExist = carService.existsById(id);
        if (isExist) {
            carService.deleteCar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}

