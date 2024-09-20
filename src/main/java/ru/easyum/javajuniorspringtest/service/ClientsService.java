package ru.easyum.javajuniorspringtest.service;

import ru.easyum.javajuniorspringtest.model.dto.ClientCreateDto;
import ru.easyum.javajuniorspringtest.model.dto.ClientGetDto;
import ru.easyum.javajuniorspringtest.model.dto.ClientUpdateDto;

import java.util.List;

/**
 * Интерфейс для работы с клиентами
 */
public interface ClientsService {

    /**
     * Создание нового клиента
     * @param clientCreateDto - данные по клиенту, которого хотим создать
     */
    void create(ClientCreateDto clientCreateDto);

    /**
     * Обновление клиента
     * @param clientUpdateDto - данные по клиенту, которого хотим создать
     */
    void update(ClientUpdateDto clientUpdateDto);


    /**
     * Удаление клиента
     * @param id - данные по клиенту, которого хотим создать
     */
    void delete(Integer id);

    /**
     * Получение клиента
     * @param id - данные по клиенту, которого хотим создать
     */
    ClientGetDto get(Integer id);

    /**
     * Получение всех клиентов
     */
    List<ClientGetDto> getAll();

    /**
     * Проверка наличия клиента
     * @param id - идентификатор клиента
     */
    boolean existsById(Integer id);
}
