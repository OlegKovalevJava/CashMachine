package api.cash_machine.service;

import api.cash_machine.repository.ClientRepo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ClientService {

    private final ClientRepo clientRepo;

    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public BigDecimal getBalance(Long id) {
        BigDecimal balance = clientRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("user with this id was not found"))
                .getBalance();
        return balance;
    }

}
