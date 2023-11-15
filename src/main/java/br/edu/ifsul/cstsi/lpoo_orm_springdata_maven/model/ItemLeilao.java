package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="itensLeilao")
public class ItemLeilao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo_item;
    private String descricao_item;
    private double lance_minimo;
    private String caminho_foto;
    //verificar possibilidade de bool
    private int arrematado;

    @OneToMany(mappedBy = "itemLance")
    List<Lance> lances;
}
