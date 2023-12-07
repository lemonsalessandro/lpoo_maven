package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.participante;

import br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.endereco.Endereco;
import br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.lance.Lance;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="participantes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Participante {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String login;
    private String senha;
    private String email;
    private String telefone;

    @Embedded
    private Endereco endereco;

    @OneToMany(mappedBy = "participante")
    private List<Lance> lances;

    @Override
    public String toString() {
        return "Participante{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco=" + endereco +
                '}' + "\n";
    }
}
