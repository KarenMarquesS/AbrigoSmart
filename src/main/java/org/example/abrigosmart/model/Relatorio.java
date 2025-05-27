package org.example.abrigosmart.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table
public class Relatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_report", sequenceName = "sequencia_report", allocationSize = 1)
    private int id_report;

    @Enumerated(EnumType.STRING)
    @Column(length = 5, nullable = false)
    private EtapaEnum etapa;

    @PastOrPresent(message = "A data não pode ser futura")
    private LocalDate data_relatorio;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Usuario gerado_pelo_usuario;

}
