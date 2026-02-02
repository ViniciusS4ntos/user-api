package com.vinicius.user_api.insfrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_endereco")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @Column(name = "rua")
    private String rua;

    @Column(name = "numero")
    private Long numero;

    @Column(name = "complemento", length = 25)
    private String complemento;

    @Column(name = "cidade", length = 120)
    private String cidade;

    @Column(name = "estado",length = 2)
    private String estado;

    @Column(name = "cep", length = 9)
    private String cep;

}
