package com.betrybe.sistemadevotacao;

import java.util.Scanner;

public class Principal {

  /**
   * main.
   */
  public static void main(String[] args) {

    String opcaoCandidato;
    Scanner scanner = new Scanner(System.in);

    GerenciamentoVotacao gerenciaVoto = new GerenciamentoVotacao();


    do {

      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      opcaoCandidato = scanner.nextLine();

      if (opcaoCandidato.equals("1")) {
        cadastroPessoaCandidata(scanner, gerenciaVoto);
      }

    } while (!opcaoCandidato.equalsIgnoreCase("2"));

    String opcaoEleitora;
    do {

      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      opcaoEleitora = scanner.nextLine();

      if (opcaoEleitora.equals("1")) {
        cadastroPessoaEleitora(scanner, gerenciaVoto);
      }

    } while (!opcaoEleitora.equalsIgnoreCase("2"));

    String opcaoVoto;

    do {

      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");

      opcaoVoto = scanner.nextLine();

      if (opcaoVoto.equals("1")) {
        votacao(scanner, gerenciaVoto);
      } else if (opcaoVoto.equals("2")) {
        gerenciaVoto.mostrarResultado();
      }

    } while (!opcaoVoto.equalsIgnoreCase("3"));

    gerenciaVoto.mostrarResultado();

    scanner.close();
  }


  /**
   * cadastroPessoaCandidata.
   */

  public static void cadastroPessoaCandidata(Scanner scanner, GerenciamentoVotacao voto) {
    System.out.print("Entre com o nome da pessoa candidata:");
    String nome = scanner.nextLine();
    System.out.print("Entre com o número da pessoa candidata:");
    int numero = Integer.parseInt(scanner.nextLine());
    voto.cadastrarPessoaCandidata(nome, numero);

  }

  /**
   * cadastroPessoaEleitora.
   */
  public static void cadastroPessoaEleitora(Scanner scanner, GerenciamentoVotacao voto) {
    System.out.print("Entre com o nome da pessoa eleitora:");
    String nome = scanner.nextLine();
    System.out.print("Entre com o cpf da pessoa eleitora:");
    String cpf = scanner.nextLine();
    voto.cadastrarPessoaEleitora(nome, cpf);
  }

  /**
   * votacao.
   */

  public static void votacao(Scanner scanner, GerenciamentoVotacao voto) {
    System.out.print("Entre com o cpf da pessoa eleitora:");
    String cpf = scanner.nextLine();
    System.out.print("Entre com o número da pessoa candidata:");
    int numero = Integer.parseInt(scanner.nextLine());
    voto.votar(cpf, numero);
  }
}
