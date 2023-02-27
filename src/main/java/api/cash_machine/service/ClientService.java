package api.cash_machine.service;

import api.cash_machine.entity.ClientEntity;
import api.cash_machine.repository.ClientRepo;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepo clientRepo;

    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public void addClient(ClientEntity clientEntity) {
        this.clientRepo.save(clientEntity);
    }

    public void deleteClient(Long id) {
        clientRepo.deleteById(id);
    }

}