package api.cash_machine.model;

import api.cash_machine.entity.OperationList;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OperationListModel {

    private BigDecimal amount;

    public static OperationListModel toModel(OperationList operationList) {
        OperationListModel model = new OperationListModel();
        model.setAmount(operationList.getOperationAmount());

        return model;
    }

}
