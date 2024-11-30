package br.edu.umfg.teste.spring.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NOME", nullable = false)
    private double nome;

    @Column(name = "SALARIO", nullable = false)
    private double salario;

    @Column(name = "DATA_NASC", nullable = true)
    private Date data_nasc;
    
}
