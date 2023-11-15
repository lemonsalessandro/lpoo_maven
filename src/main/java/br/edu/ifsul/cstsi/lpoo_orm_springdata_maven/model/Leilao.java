package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;


public class Leilao {
    private LocalDate dt_inicio;
    private LocalTime hor_inicio;
    private LocalDate dt_final;
    private LocalTime hor_final;
}
