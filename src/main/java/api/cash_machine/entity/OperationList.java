package api.cash_machine.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class OperationList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOperation;
    private int typeOfOperation;
    private BigDecimal amount;


    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity clientOperation;



}