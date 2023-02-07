package api.cash_machine.repository;

import api.cash_machine.entity.OperationList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationListRepo extends JpaRepository<OperationList, Long> {
}