package br.com.fiap.fiapmotors.adapters.out.persistence.orm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "veiculo")
@Data
public class VeiculoEntity {

    @Id
    private String id;

    private String tipo;

    private String marca;

    private String ano;

    private String cor;

    private BigDecimal preco;

    private String cliente;

    @PrePersist
    private void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
