package api.cash_machine.repository;

import api.cash_machine.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Optional;

public interface ClientRepo extends JpaRepository<ClientEntity, Long> {


}