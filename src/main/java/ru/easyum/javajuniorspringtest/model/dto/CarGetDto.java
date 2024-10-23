package ru.easyum.javajuniorspringtest.model.dto;

import java.util.Objects;

public class CarGetDto {
    private String brand;
    private String model;
    private String number;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "CarGetDto{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarGetDto carGetDto = (CarGetDto) o;
        return Objects.equals(brand, carGetDto.brand) && Objects.equals(model, carGetDto.model) && Objects.equals(number, carGetDto.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, number);
    }
}
