package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="participantes")
public class Participante {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String login;
    private String senha;
    private String email;
    private String telefone;

    //IMPORTAÇÃO DOS ATRIBUTOS DA CLASSE ENDEREÇO PARA A CLASSE PARTICIPANTE.
    @Embedded
    private Endereco endereco;


    //LIGAÇÃO DE UM PARTICIPANTE PARA NENHUM OU MUITOS LANCES
    @OneToMany(mappedBy = "participante")
    private List<Lance> lances;
}
