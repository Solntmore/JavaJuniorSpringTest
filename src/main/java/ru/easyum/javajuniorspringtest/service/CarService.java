package ru.easyum.javajuniorspringtest.service;

import ru.easyum.javajuniorspringtest.model.dto.CarCreateDto;
import ru.easyum.javajuniorspringtest.model.dto.CarGetDto;
import ru.easyum.javajuniorspringtest.model.dto.CarUpdateDto;

import java.util.List;

/**
 * Интерфейс для работы с машинами
 */
public interface CarService {

    /**
     * Получение автомобилей клиента
     *
     * @param clientId - идентификатор клиента
     * @return список автомобилей клиента
     */
    List<CarGetDto> getCarsByClientId(int clientId);

    /**
     * Проверка, что автомобиль существует
     * @param carId идентификатор авто
     * @return true - существует, false - нет
     */
    boolean existsById(int carId);

    /**
     * Получение автомобиля по идентификатору
     *
     * @param carId идентификатор автомобиля
     * @return информацию по автомобилю
     */
    CarGetDto getCarById(int carId);

    /**
     * Получение списка всех автомобилей
     *
     * @return список автомобилей
     */
    List<CarGetDto> getAllCars();

    /**
     * Создание автомобиля
     * @param carDto данные об автомобиле, который нужно создать
     */
    void createCar(CarCreateDto carDto);

    /**
     * Обновление автомобиля
     * @param carDto данные об автомобиле, которые нужно обновить
     */
    void updateCar(CarUpdateDto carDto);

    /**
     * Удаление автомобиля
     * @param carId идентификатор автомобиля, который нужно удалить
     */
    void deleteCar(int carId);
}
