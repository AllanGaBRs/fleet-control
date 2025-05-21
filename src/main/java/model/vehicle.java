package model;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Entity
public class vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String placa;
    private String marca;
    private String modelo;
    private String tipo;
    private String ano;
    private String status;

}
