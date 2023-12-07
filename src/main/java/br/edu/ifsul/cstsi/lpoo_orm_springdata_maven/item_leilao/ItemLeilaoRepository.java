package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.item_leilao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface ItemLeilaoRepository extends JpaRepository<ItemLeilao, Long> {

    @Query(value = "SELECT i FROM ItemLeilao i where i.titulo_item like ?1")
    List<ItemLeilao> findByNome(String nome);



}
