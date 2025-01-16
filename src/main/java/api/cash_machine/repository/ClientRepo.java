package api.cash_machine.repository;

import api.cash_machine.entity.ClientEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepo extends CrudRepository<ClientEntity, Long> {

}
