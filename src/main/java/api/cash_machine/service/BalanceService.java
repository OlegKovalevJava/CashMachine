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
public class BalanceService {

    private final ClientRepo clientRepo;
    private final OperationRepo operationRepo;

    public BalanceService(ClientRepo clientRepo, OperationRepo operationRepo) {
        this.clientRepo = clientRepo;
        this.operationRepo = operationRepo;
    }

    public ClientModel getBalance(Long idDonor) {
        ClientEntity clientEntity = clientRepo.findById(idDonor).get();
        return ClientModel.toModel(clientEntity);
    }

    public ClientModel putMoney(Long idDonor, BigDecimal amount) {
        ClientEntity clientEntity = clientRepo.findById(idDonor)
                .orElseThrow(() -> new IllegalArgumentException("user with this id was not found"));
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
        ClientEntity clientEntity = clientRepo.findById(idDonor)
                .orElseThrow(() -> new IllegalArgumentException("user with this id was not found"));
        BigDecimal updatedBalance = clientEntity.getBalance().subtract(amount);
        clientEntity.setBalance(updatedBalance);
        OperationList operationList = new OperationList();
        operationList.setOperationAmount(amount);
        operationList.setOperationDate(new Date());
        operationList.setOperationType("withdrawal from the balance");
        operationList.setClient(clientEntity);
        operationRepo.save(operationList);

        return ClientModel.toModel(clientRepo.save(clientEntity));
    }

}
