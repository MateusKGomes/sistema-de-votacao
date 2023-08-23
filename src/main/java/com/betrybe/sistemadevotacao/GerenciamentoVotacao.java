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
    for (PessoaCandidata pessoa : pessoasCandidatas) {
      if (pessoa.getNumero() == numero) {
        System.out.println("Número da pessoa candidata já utilizado!");
      } else {
        PessoaCandidata pessoaCandidata = new PessoaCandidata(nome, numero);
        pessoasCandidatas.add(pessoaCandidata);
      }
    }

  }

  /**
   * cadastrarPessoaEleitora.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    for (PessoaEleitora pessoa : pessoasEleitoras) {
      if (pessoa.getCpf().equals(cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
      } else {
        PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
        pessoasEleitoras.add(pessoaEleitora);
      }
    }
  }

  /**
   * votar.
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    for (PessoaCandidata pessoa : pessoasCandidatas) {
      if (cpfsComputados.contains(cpfPessoaEleitora)) {
        System.out.println("Pessoa eleitora já votou!");
      } else if (pessoa.getNumero() == numeroPessoaCandidata) {
        pessoa.receberVoto();
        cpfsComputados.add(cpfPessoaEleitora);
      }
    }
  }

  /**
   * mostrarResultado.
   */
  public void mostrarResultado() {
    if (cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado");
    } else {
      int totalVotos = 0;
      for (PessoaCandidata pessoa : pessoasCandidatas) {
        totalVotos += pessoa.votos;
        int porcentagemVotos = Math.round((float) (pessoa.getVotos() * 100) / totalVotos);
        System.out.println(
            "Nome:" + pessoa.getNome() + "-" + pessoa.getVotos() + "votos" + "(" + porcentagemVotos
                + "%)"
                + "Total de votos: " + totalVotos);
      }
    }
  }
}
