package com.betrybe.sistemadevotacao;

public class PessoaEleitora extends Pessoa {

  private String cpf;

  public PessoaEleitora(String nome, String cpf) {
    super();
    this.nome = nome;
    this.cpf = cpf;
  }

  @Override
  public String getNome() {
    return super.getNome();
  }

  @Override
  public void setNome(String nome) {
    super.setNome(nome);
  }


  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }



}
