package br.com.fiap.fiapmotors.adapters.out.persistence.orm;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cliente")
@Data
public class ClienteEntity {

    @Id
    private String id;

    private String nome;

    private Integer idade;

    private String sexo;

    private String cpf;

    private String email;
}
