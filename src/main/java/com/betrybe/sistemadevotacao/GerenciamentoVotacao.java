package com.betrybe.sistemadevotacao;

import java.util.ArrayList;
import java.util.Objects;


public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<>();
  private ArrayList<String> cpfsComputados = new ArrayList<String>();
  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<>();

  /**
   * cadastrarPessoaCandidata.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    for (PessoaCandidata pessoa : pessoasCandidatas) {
      if (pessoa.getNumero() == numero) {
        System.out.println("Número da pessoa candidata já utilizado!");
        break;
      }
    }
    PessoaCandidata pessoaCandidata = new PessoaCandidata(nome, numero);
    pessoasCandidatas.add(pessoaCandidata);
  }

  /**
   * cadastrarPessoaEleitora.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    for (PessoaEleitora pessoa : pessoasEleitoras) {
      if (Objects.equals(pessoa.getCpf(), cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
        break;
      }
    }
    PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
    pessoasEleitoras.add(pessoaEleitora);
  }

  /**
   * votar.
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (cpfsComputados.stream().anyMatch(n -> n.equals(cpfPessoaEleitora))) {
      System.out.println("Pessoa eleitora já votou!");
    }
    for (PessoaCandidata pessoa : pessoasCandidatas) {
      if (pessoa.getNumero() == numeroPessoaCandidata) {
        pessoa.receberVoto();
        cpfsComputados.add(cpfPessoaEleitora);
        return;
      }
    }
  }

  /**
   * mostrarResultado.
   */
  public void mostrarResultado() {
    if (cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado");
    }
    for (PessoaCandidata pessoa : pessoasCandidatas) {
      int porcentagemVotos =  pessoa.getVotos() * 100 / cpfsComputados.size();
      System.out.println(
          "Nome: " + pessoa.getNome() + " - " + pessoa.getVotos() + " votos ( " + porcentagemVotos
              + "% )"
              + "Total de votos: " + cpfsComputados.size());
    }
  }
}
