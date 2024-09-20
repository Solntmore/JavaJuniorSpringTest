package ru.easyum.javajuniorspringtest.model.mappers;

import org.springframework.stereotype.Component;
import ru.easyum.javajuniorspringtest.model.dto.ClientCreateDto;
import ru.easyum.javajuniorspringtest.model.dto.ClientGetDto;
import ru.easyum.javajuniorspringtest.model.dto.ClientUpdateDto;
import ru.easyum.javajuniorspringtest.model.entity.Client;

@Component
public class ClientsMapper {

    /**
     * Маппер из ClientCreateDto в Client
     * @param dto объект, который пришел в контроллер для создания клиента
     * @return объект клиента типа entity
     */
    public Client fromCreateDtoToEntity(ClientCreateDto dto) {
        if (dto == null) {
            return null;
        }

        Client client = new Client();
        client.setName(dto.getName());
        client.setEmail(dto.getEmail());
        client.setPhone(dto.getPhone());

        return client;
    }

    /**
     * Маппер из ClientUpdateDto в Client
     * @param dto объект, который пришел в контроллер для обновления клиента
     * @return объект клиента типа entity
     */
    public Client fromClientUpdateDtoToEntity(ClientUpdateDto dto) {
        if (dto == null) {
            return null;
        }
        Client client = new Client();
        client.setId(dto.getId());
        client.setName(dto.getName());
        client.setEmail(dto.getEmail());
        client.setPhone(dto.getPhone());

        return client;
    }

    public ClientGetDto fromEntityToGetDto(Client client) {
        if (client == null) {
            return null;
        }
        ClientGetDto dto = new ClientGetDto();
        dto.setId(client.getId());
        dto.setName(client.getName());
        dto.setEmail(client.getEmail());
        dto.setPhone(client.getPhone());

        return dto;
    }
}
