package ru.easyum.javajuniorspringtest.model.dto;

import java.util.Objects;

public class CarCreateDto {
    private String brand;
    private String model;
    private String number;
    private Integer price;
    private Integer clientId;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getNumber() {
        return number;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getClientId() {
        return clientId;
    }

    @Override
    public String toString() {
        return "CarCreateDto{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", number='" + number + '\'' +
                ", price=" + price +
                ", clientId=" + clientId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarCreateDto that = (CarCreateDto) o;
        return Objects.equals(brand, that.brand) && Objects.equals(model, that.model) && Objects.equals(number, that.number) && Objects.equals(price, that.price) && Objects.equals(clientId, that.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, number, price, clientId);
    }
}
