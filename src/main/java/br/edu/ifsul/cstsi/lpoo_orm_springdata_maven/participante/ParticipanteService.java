package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.participante;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository rep;

    public List<Participante> getParticipantes(){
        return rep.findAll();
    }

    public Participante insert(Participante participante) {
        Assert.isNull(participante.getId(),"Não foi possível inserir o registro");
        return rep.save(participante);
    }

    public Participante getParticipanteByID(Long id) {
        Optional<Participante> optional = rep.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public List<Participante> getParticipanteByNome(String nome) {
        return new ArrayList<>(rep.findByNome(nome + "%"));
    }

    public List<Participante> getParticipanteByEmail(String email){
        return new ArrayList<>(rep.findByEmail(email + "%"));
    }

}
