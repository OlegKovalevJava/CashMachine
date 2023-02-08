package api.cash_machine.service;

import api.cash_machine.entity.ClientEntity;
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

    public BigDecimal getBalance(Long id) {
        return clientRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("user with this id was not found"))
                .getBalance();
    }

    public BigDecimal takeMoney(Long idDonor, BigDecimal amount) {
        BigDecimal currentBalance = clientRepo.findById(idDonor).get().getBalance();
        BigDecimal updatedBalance = currentBalance.subtract(amount);
        return updatedBalance;
    }

    public BigDecimal putMoney(Long idDonor, BigDecimal amount) {
        BigDecimal currentBalance = clientRepo.findById(idDonor).get().getBalance();
        BigDecimal updatedBalance = currentBalance.add(amount);
        return updatedBalance;
    }

}
