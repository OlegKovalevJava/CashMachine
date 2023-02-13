package api.cash_machine.service;

import api.cash_machine.entity.ClientEntity;
import api.cash_machine.model.ClientModel;
import api.cash_machine.repository.ClientRepo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ClientService {

    private final ClientRepo clientRepo;

    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public void addClient(ClientEntity clientEntity) {
        this.clientRepo.save(clientEntity);
    }

    public Long deleteClient(Long id) {
        clientRepo.deleteById(id);
        return id;
    }

    public ClientModel getBalance(Long idDonor) {
        ClientEntity clientEntity = clientRepo.findById(idDonor).get();
        return ClientModel.toModel(clientEntity);
    }

    public ClientModel putMoney(Long idDonor, BigDecimal amount) {
        ClientEntity clientEntity = clientRepo.findById(idDonor).get();
        BigDecimal updatedBalance = clientEntity.getBalance().add(amount);
        clientEntity.setBalance(updatedBalance);
        return ClientModel.toModel(clientRepo.save(clientEntity));
    }

    public ClientModel takeMoney(Long idDonor, BigDecimal amount) {
        ClientEntity clientEntity = clientRepo.findById(idDonor).get();
        BigDecimal updatedBalance = clientEntity.getBalance().subtract(amount);
        clientEntity.setBalance(updatedBalance);
        return ClientModel.toModel(clientRepo.save(clientEntity));
    }

}