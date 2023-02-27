package api.cash_machine.controller;

import api.cash_machine.entity.TransferBalance;
import api.cash_machine.model.ClientModel;
import api.cash_machine.service.BalanceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/balance")
public class BalanceController {

    private final BalanceService balanceService;

    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping("/{id}")
    public ClientModel getBalance(@PathVariable Long id) {
        return balanceService.getBalance(id);
    }

    @PostMapping("/takeMoney")
    public ClientModel takeMoney(@RequestBody TransferBalance transferBalance) {
        return balanceService.takeMoney(transferBalance.getIdDonor(), transferBalance.getAmountTransfer());
    }

    @PostMapping("/putMoney")
    public ClientModel putMoney(@RequestBody TransferBalance transferBalance) {
        return balanceService.putMoney(transferBalance.getIdDonor(), transferBalance.getAmountTransfer());
    }

}