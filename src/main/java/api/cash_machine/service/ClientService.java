package api.cash_machine.service;

import api.cash_machine.entity.ClientEntity;
import api.cash_machine.entity.OperationList;
import api.cash_machine.model.ClientModel;
import api.cash_machine.repository.ClientRepo;
import api.cash_machine.repository.OperationRepo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class ClientService {

    private final ClientRepo clientRepo;
    private final OperationRepo operationRepo;
    public ClientService(ClientRepo clientRepo, OperationRepo operationRepo) {
        this.clientRepo = clientRepo;
        this.operationRepo = operationRepo;
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
        OperationList operationList = new OperationList();
        operationList.setOperationAmount(amount);
        operationList.setOperationDate(new Date());
        operationList.setOperationType("replenishment of the balance");
        operationList.setClient(clientEntity);
        operationRepo.save(operationList);
        return ClientModel.toModel(clientRepo.save(clientEntity));
    }

    public ClientModel takeMoney(Long idDonor, BigDecimal amount) {
        ClientEntity clientEntity = clientRepo.findById(idDonor).get();
        BigDecimal updatedBalance = clientEntity.getBalance().subtract(amount);
        clientEntity.setBalance(updatedBalance);
        return ClientModel.toModel(clientRepo.save(clientEntity));
    }

}