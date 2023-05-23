package com.pacote.hibernatetest.model;

import javax.persistence.*;

@Entity

public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }


    private String Nome;
    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }


    private String Email;
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    private Integer contato;

    public Integer getContato() {
        return contato;
    }

    public void setContato(Integer contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "Id=" + Id +
                ", Nome='" + Nome + '\'' +
                ", Email='" + Email + '\'' +
                ", contato=" + contato +
                '}';
    }
}
