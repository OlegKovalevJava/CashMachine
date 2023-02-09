package api.cash_machine.model;

import api.cash_machine.entity.ClientEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ClientModel {

    private BigDecimal balance;

    public static ClientModel toModel(ClientEntity clientEntity) {
        ClientModel model = new ClientModel();
        model.setBalance(clientEntity.getBalance());
        return model;
    }
}
