package api.cash_machine.controller;

import api.cash_machine.entity.ClientEntity;
import api.cash_machine.service.ClientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public void addClient(@RequestBody ClientEntity clientEntity) {
        this.clientService.addClient(clientEntity);
    }

    @DeleteMapping("{id}")
    public void deleteClient(@PathVariable Long id) {
        this.clientService.deleteClient(id);
    }

}