package ru.easyum.javajuniorspringtest.model.mappers;

import org.springframework.stereotype.Component;
import ru.easyum.javajuniorspringtest.model.dto.CarCreateDto;
import ru.easyum.javajuniorspringtest.model.dto.CarGetDto;
import ru.easyum.javajuniorspringtest.model.dto.CarUpdateDto;
import ru.easyum.javajuniorspringtest.model.dto.ClientCreateDto;
import ru.easyum.javajuniorspringtest.model.entity.Car;
import ru.easyum.javajuniorspringtest.model.entity.Client;

@Component
public class CarMapper {

    /**
     * Маппер из Car в CarGetDto
     * @param dto объект, который пришел в маппер из репозитория Car
     * @return объект машины типа CarGetDto
     */
    public CarGetDto fromEntityToCarGetDto(Car dto) {
        if (dto == null) {
            return null;
        }

        CarGetDto car = new CarGetDto();
        car.setBrand(dto.getBrand());
        car.setModel(dto.getModel());
        car.setNumber(dto.getNumber());

        return car;
    }

    /**
     * Маппер из ClientCreateDto в Client
     * @param dto объект, который пришел в контроллер для создания клиента
     * @return объект клиента типа entity
     */
    public Car fromUpdateDtoToEntity(CarUpdateDto dto, Client client) {
        if (dto == null) {
            return null;
        }

        Car car = new Car();
        car.setBrand(dto.getBrand());
        car.setModel(dto.getModel());
        car.setNumber(dto.getNumber());
        car.setPrice(dto.getPrice());
        car.setId(dto.getId());
        car.setClient(client);

        return car;
    }

    /**
     * Маппер из ClientCreateDto в Client
     * @param dto объект, который пришел в контроллер для создания клиента
     * @return объект клиента типа entity
     */
    public Car fromCreateDtoToEntity(CarCreateDto dto, Client client) {
        if (dto == null) {
            return null;
        }

        Car car = new Car();
        car.setBrand(dto.getBrand());
        car.setModel(dto.getModel());
        car.setNumber(dto.getNumber());
        car.setPrice(dto.getPrice());
        car.setClient(client);

        return car;
    }
}
