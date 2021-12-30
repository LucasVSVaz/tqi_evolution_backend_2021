package br.com.tqi.challenge.controllers;

import br.com.tqi.challenge.dto.response.MessageResponseDTO;
import br.com.tqi.challenge.dto.resquest.ClientDTO;
import br.com.tqi.challenge.entities.Client;
import br.com.tqi.challenge.exceptions.PersonNotFoundException;
import br.com.tqi.challenge.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
@AllArgsConstructor
public class ClientController {

    private ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid ClientDTO clientDTO) {
        return clientService.create(clientDTO);
    }

    @PostMapping("/{id}")
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid ClientDTO clientDTO)
            throws PersonNotFoundException {
        return clientService.update(id, clientDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws PersonNotFoundException {
        clientService.delete(id);
    }

    @GetMapping
    public List<Client> getAll() {
        return clientService.getAll();
    }

    public Client getById(@PathVariable Long id) throws PersonNotFoundException {
        return clientService.getById(id);
    }
}
