package com.betrybe.sistemadevotacao;

public class PessoaCandidata extends Pessoa {
  int numero;
  int votos = 0;

  public PessoaCandidata(String nome, int numero) {
    this.nome = nome;
    this.numero = numero;
  }

  @Override
  public String getNome() {
    return super.getNome();
  }

  @Override
  public void setNome(String nome) {
    super.setNome(nome);
  }

  public int getVotos() {
    return votos;
  }

  public void setVotos(int votos) {
    this.votos = votos;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public void receberVoto() {
    this.votos += 1;
  }

}
