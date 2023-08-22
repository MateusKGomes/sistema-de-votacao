package com.betrybe.sistemadevotacao;

public abstract class PessoaCandidata extends Pessoa {

  int numero;
  int votos;

  PessoaCandidata(String nome, int numero) {
    this.votos = 0;
    this.numero = numero;
    super.nome = nome;
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
