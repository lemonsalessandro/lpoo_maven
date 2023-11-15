package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name="leilao")
public class Leilao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dt_inicio;
    private LocalTime hor_inicio;
    private LocalDate dt_final;
    private LocalTime hor_final;

    @OneToMany(mappedBy = "leilao")
    private List<ItemLeilao>itensLeilao;
}
