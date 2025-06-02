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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_vitima;

    @Column(name = "nome", length = 255)
    private String nome;

    @Column(name = "idade", columnDefinition = "INT")
    private int idade;

    @Column(name = "sexo", columnDefinition = "SMALLINT")
    @Enumerated(EnumType.ORDINAL)
    private GeneroEnum sexo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_triagem")
    private Triagem triagem;

}
