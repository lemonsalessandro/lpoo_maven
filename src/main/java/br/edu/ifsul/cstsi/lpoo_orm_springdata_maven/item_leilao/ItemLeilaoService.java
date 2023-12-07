package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.item_leilao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemLeilaoService {

    @Autowired
    private ItemLeilaoRepository rep;

    public List<ItemLeilao> getItensLeilao() {
        return rep.findAll();
    }

}
