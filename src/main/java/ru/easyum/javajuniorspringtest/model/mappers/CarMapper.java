package ru.easyum.javajuniorspringtest.model.mappers;

import org.springframework.stereotype.Component;
import ru.easyum.javajuniorspringtest.model.dto.CarGetDto;
import ru.easyum.javajuniorspringtest.model.entity.Car;

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
}
