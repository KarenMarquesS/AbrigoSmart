package org.example.abrigosmart.model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Schema(description = "Essa classe representa a entidade Tiragem, está diretametne relacionada com as" +
        "classes/entidades de Usuário e Vítmas ")

@Data
@Table
@Entity
public class Triagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_triagem;

    @Column(name = "prioridade", columnDefinition = "SMALLINT")
    @Enumerated(EnumType.ORDINAL)
    private PrioriEnum prioridade;

    @Column(name = "estado_saude", length = 255)
    private String estado_saude;

    @Column(name = "classificacao", columnDefinition = "INT", nullable = false)
    private int classificacao;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_triagem", columnDefinition = "DATE")
    private LocalDate data_triagem;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToOne(mappedBy = "triagem")
    private Vitima vitima;

}
