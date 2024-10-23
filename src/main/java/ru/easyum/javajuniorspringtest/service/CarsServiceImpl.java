package ru.easyum.javajuniorspringtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.easyum.javajuniorspringtest.model.dto.CarGetDto;
import ru.easyum.javajuniorspringtest.model.mappers.CarMapper;
import ru.easyum.javajuniorspringtest.repository.CarRepository;

import java.util.List;

@Service
public class CarsServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarMapper carMapper;

    @Override
    public List<CarGetDto> getCarsByClientId(int clientId) {
        return carRepository.findAllByClientId(clientId)
                .stream()
                .map(carMapper::fromEntityToCarGetDto)
                .toList();
    }
}
