package com.pacote.hibernatetest.teste;

import com.pacote.hibernatetest.DAO.PessoaDAO;
import com.pacote.hibernatetest.model.Pessoa;

public class pessoaTeste {

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        PessoaDAO pessoadao = new PessoaDAO();
        pessoa.setNome("Peter");
        pessoa.setContato(439999999);
        pessoa.setEmail("Peter@gmail.com");
        pessoadao.salvar(pessoa);

        //pesquisando pelo id
//        pessoa = pessoadao.findById(6);
//        System.out.println(pessoa);


        // listar toda tabela
//        for(Pessoa pessoa2 : pessoadao.findAll()){
//         System.out.println(pessoa2);}

        //deletar produto
        // pessoadao.remove(1);}

}}
