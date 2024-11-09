package ru.easyum.javajuniorspringtest.model.dto;

import java.util.Objects;

public class CarUpdateDto {
    private Integer id;
    private String brand;
    private String model;
    private String number;
    private Integer price;
    private Integer clientId;

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getId() {
        return id;
    }

    public Integer getPrice() {
        return price;
    }

    public String getNumber() {
        return number;
    }

    public Integer getClientId() {
        return clientId;
    }

    @Override
    public String toString() {
        return "CarUpdateDto{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
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
        CarUpdateDto that = (CarUpdateDto) o;
        return Objects.equals(id, that.id) && Objects.equals(brand, that.brand) && Objects.equals(model, that.model) && Objects.equals(number, that.number) && Objects.equals(price, that.price) && Objects.equals(clientId, that.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, number, price, clientId);
    }
}
