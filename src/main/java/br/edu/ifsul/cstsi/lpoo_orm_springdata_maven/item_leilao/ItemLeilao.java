package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.item_leilao;

import br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.lance.Lance;
import br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.leilao.Leilao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="itens_leilao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemLeilao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo_item;
    private String descricao_item;
    private double lance_minimo;
    private String caminho_foto;
    private int arrematado; //BOOL???

    @OneToMany(mappedBy = "itemLance")
    private List<Lance> lances;

    @ManyToOne
    @JoinColumn(name="leilao_id", referencedColumnName = "id")
    private Leilao leilao;


    //TO STRING???
}
