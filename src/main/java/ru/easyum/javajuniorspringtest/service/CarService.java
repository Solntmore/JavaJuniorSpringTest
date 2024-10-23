package ru.easyum.javajuniorspringtest.service;

import ru.easyum.javajuniorspringtest.model.dto.CarGetDto;

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
}
