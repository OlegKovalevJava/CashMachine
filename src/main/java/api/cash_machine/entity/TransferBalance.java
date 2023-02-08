package api.cash_machine.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransferBalance {

    private Long idDonor;
    private Long idRecipient;
    private BigDecimal amountTransfer;

}
