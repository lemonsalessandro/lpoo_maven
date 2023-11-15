package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.model;

import jakarta.persistence.*;

@Entity
@Table(name="participantes")
public class Participante {

    //NESSA CLASSE UM PARTICIPANTE RECEBE TODOS ATRIBUTOS DE SUA CLASSE E TAMBÉM
    // OS DA CLASSE ENDEREÇO QUE FOI CRIADA E ESTÁ SENDO IMPORTADA PARA PARTICIPANTE.

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String login;
    private String senha;
    private String email;
    private String telefone;
    @Embedded
    private Endereco endereco;

}
