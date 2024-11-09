package ru.easyum.javajuniorspringtest.exceptions;

/**
 * Исключение, возникающее когда клиент не найден
 */
public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(String message) {
        super(message);
    }
}
