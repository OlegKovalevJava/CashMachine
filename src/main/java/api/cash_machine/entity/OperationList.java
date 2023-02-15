package api.cash_machine.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "operation_list")
public class OperationList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "operation_date")
    public Date deadline;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;
}