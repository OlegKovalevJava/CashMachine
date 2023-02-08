package api.cash_machine.controller;

import api.cash_machine.entity.TransferBalance;
import api.cash_machine.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/balance")
public class BalanceController {

    private final ClientService clientService;

    public BalanceController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal getBalance(@PathVariable Long id) {
        return clientService.getBalance(id);
    }

    @PostMapping("/takeMoney")
    public BigDecimal takeMoney(@RequestBody TransferBalance transferBalance) {
        return clientService.takeMoney(transferBalance.getIdDonor(), transferBalance.getAmountTransfer());
    }

    @PostMapping("/putMoney")
    public BigDecimal putMoney(@RequestBody TransferBalance transferBalance) {
        return clientService.putMoney(transferBalance.getIdDonor(), transferBalance.getAmountTransfer());
    }

}