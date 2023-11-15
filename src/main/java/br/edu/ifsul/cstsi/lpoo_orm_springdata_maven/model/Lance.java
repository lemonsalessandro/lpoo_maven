package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.model;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name="lances")
public class Lance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double val_lance;
    private LocalTime hora_lance;

    //LIGAÇÃO DE NENHUM OU MUITOS LANCES PARA UM PARTICIPANTE
    @ManyToOne
    @JoinColumn(name = "participante_id", referencedColumnName = "id")
    private Participante participante;
}
