package com.betrybe.sistemadevotacao;

import java.util.ArrayList;


public abstract class GerenciamentoVotacao implements  GerenciamentoVotacaoInterface {
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfsComputados = new ArrayList<String>();
  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();

}
