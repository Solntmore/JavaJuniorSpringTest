package ru.easyum.javajuniorspringtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.easyum.javajuniorspringtest.model.dto.CarCreateDto;
import ru.easyum.javajuniorspringtest.model.dto.CarGetDto;
import ru.easyum.javajuniorspringtest.model.dto.CarUpdateDto;
import ru.easyum.javajuniorspringtest.model.entity.Client;
import ru.easyum.javajuniorspringtest.model.mappers.CarMapper;
import ru.easyum.javajuniorspringtest.repository.CarRepository;
import ru.easyum.javajuniorspringtest.repository.ClientsRepository;

import java.util.List;

@Service
public class CarsServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ClientsRepository clientsRepository;
    @Autowired
    private CarMapper carMapper;

    @Override
    public List<CarGetDto> getCarsByClientId(int clientId) {
        return carRepository.findAllByClientId(clientId)
                .stream()
                .map(carMapper::fromEntityToCarGetDto)
                .toList();
    }

    @Override
    public boolean existsById(int carId) {
        return carRepository.existsById(carId);
    }

    @Override
    public CarGetDto getCarById(int carId) {
        return carMapper.fromEntityToCarGetDto(
                carRepository.findById(carId).get()
        );
    }

    @Override
    public List<CarGetDto> getAllCars() {
        return carRepository.findAll()
                .stream()
                .map(carMapper::fromEntityToCarGetDto)
                .toList();
    }

    @Override
    public void createCar(CarCreateDto carDto) {
        Client client = clientsRepository.findById(carDto.getClientId()).get();
        carRepository.save(carMapper.fromCreateDtoToEntity(carDto, client));
    }

    @Override
    public void updateCar(CarUpdateDto carDto) {
        Client client = clientsRepository.findById(carDto.getClientId()).get();
        carRepository.save(carMapper.fromUpdateDtoToEntity(carDto, client));
    }

    @Override
    public void deleteCar(int carId) {
        carRepository.deleteById(carId);
    }
}
