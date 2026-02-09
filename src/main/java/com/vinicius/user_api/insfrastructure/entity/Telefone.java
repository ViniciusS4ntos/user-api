package com.vinicius.user_api.insfrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_telefones")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero")
    private String numero;

    @Column(name = "ddd", length = 3)
    private String ddd;

    @Column(name = "usuario_id")
    private Long usuario_id;

}
