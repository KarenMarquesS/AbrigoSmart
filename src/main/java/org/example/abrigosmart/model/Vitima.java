package org.example.abrigosmart.model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;


@Schema(description = "Essa classe representa a entidade nomeada Vítima, está diretamente" +
        "associada a classe/entidade Triagem")

@Data
@Entity
@Table
public class Vitima {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_vitima", sequenceName = "sequencia_vitima", allocationSize = 1)
    private int id_vitima;

    private String nome;

    private int idade;

    private GeneroEnum sexo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_triagem")
    private Triagem triagem;




}
