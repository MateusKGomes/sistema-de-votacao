package com.betrybe.sistemadevotacao;

import java.util.ArrayList;


public abstract class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfsComputados = new ArrayList<String>();
  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();

  /**
   * cadastrarPessoaCandidata.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {

    if (pessoasCandidatas.contains(numero)) {
      System.out.println("Número da pessoa candidata já utilizado!");
    } else {
      PessoaCandidata pessoaCandidata = new PessoaCandidata(nome, numero);
      pessoasCandidatas.add(pessoaCandidata);
    }
  }

  /**
   * cadastrarPessoaEleitora.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    if (pessoasEleitoras.contains(cpf)) {
      System.out.println("Pessoa eleitora já cadastrada!");
    } else {
      PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
      pessoasEleitoras.add(pessoaEleitora);
    }
  }
}
