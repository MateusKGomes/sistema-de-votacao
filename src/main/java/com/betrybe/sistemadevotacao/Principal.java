package com.betrybe.sistemadevotacao;

import java.util.Scanner;

public class Principal {

  /**
   * main.
   */
  public static void main(String[] args) {

    String opcaoCandidato;
    Scanner scanner = new Scanner(System.in);

    do {

      System.out.println("Cadastrar pessoa candidata?\n");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:\n");
      opcaoCandidato = scanner.nextLine();
      System.out.println();

      if (opcaoCandidato.equals("1")) {
        cadastroPessoaCandidata(scanner);
      }

    } while (!opcaoCandidato.equalsIgnoreCase("2"));

    String opcaoEleitora;
    do {

      System.out.println("Cadastrar pessoa eleitora?\n\n");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:\n");
      opcaoEleitora = scanner.nextLine();
      System.out.println();

      if (opcaoEleitora.equals("1")) {
        cadastroPessoaEleitora(scanner);
      }

    } while (!opcaoEleitora.equalsIgnoreCase("2"));

    String opcaoVoto;

    do {

      System.out.println("Entre com o número correspondente à opção desejada:\n");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");

      opcaoVoto = scanner.nextLine();
      System.out.println();

      if (opcaoVoto.equals("1")) {
        votacao(scanner);
      } else if (opcaoVoto.equals("2")) {
        resultadoParcial();
      }

    } while (!opcaoVoto.equalsIgnoreCase("3"));


  }


  /**
   * cadastroPessoaCandidata.
   */

  public static void cadastroPessoaCandidata(Scanner scanner) {
    System.out.print("Entre com o nome da pessoa candidata: ");
    String nome = scanner.nextLine();
    System.out.print("Entre com o número da pessoa candidata: ");
    int numero = Integer.parseInt(scanner.nextLine());
    GerenciamentoVotacao pessoaCandidata = new GerenciamentoVotacao();
    pessoaCandidata.cadastrarPessoaCandidata(nome, numero);

  }

  /**
   * cadastroPessoaEleitora.
   */
  public static void cadastroPessoaEleitora(Scanner scanner) {
    System.out.print("Entre com o nome da pessoa eleitora: ");
    String nome = scanner.nextLine();
    System.out.print("Entre com o cpf da pessoa eleitora: ");
    String cpf = scanner.nextLine();
    GerenciamentoVotacao pessoaEleitora = new GerenciamentoVotacao();
    pessoaEleitora.cadastrarPessoaEleitora(nome, cpf);

  }

  /**
   * votacao.
   */

  public static void votacao(Scanner scanner) {
    System.out.print("Entre com o cpf da pessoa eleitora: ");
    String cpf = scanner.nextLine();
    System.out.print("Entre com o número da pessoa candidata: ");
    int numero = Integer.parseInt(scanner.nextLine());
    GerenciamentoVotacao voto = new GerenciamentoVotacao();
    voto.votar(cpf, numero);
  }

  /**
   * resultadoParcial.
   */
  public static void resultadoParcial() {
    GerenciamentoVotacao resultado = new GerenciamentoVotacao();
    resultado.mostrarResultado();
  }
}
