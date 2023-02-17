package api.cash_machine.repository;

import api.cash_machine.entity.OperationList;
import org.springframework.data.repository.CrudRepository;

public interface OperationRepo extends CrudRepository<OperationList, Long> {
}
