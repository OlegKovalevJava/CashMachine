package api.cash_machine.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "clients")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "clientName")
    private String clientName;

    @Column(name="balance")
    private BigDecimal balance;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<OperationList> operation;

}