package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.lance;

import br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.item_leilao.ItemLeilao;
import br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.participante.Participante;
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

    @ManyToOne
    @JoinColumn(name = "itensLeilao_id", referencedColumnName = "id")
    private ItemLeilao itemLance;
}
