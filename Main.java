package cinema;

import java.util.Scanner;
import java.util.Locale;
import java.time.LocalTime;

public class Main {

    static void gerenciarFilmes(Scanner teclado, Filme[] filmes) {

        int selecionar;

        do {
            System.out.println("===== FILMES =====");

            for (int i = 0; i < filmes.length; i++) {
                System.out.println(
                    (i + 1) + " - " + filmes[i].getTitulo()
                    + " | Categoria: " + filmes[i].getCategoria()
                );
            }

            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha um filme: ");

            selecionar = teclado.nextInt();
            teclado.nextLine();

            if (selecionar >= 1 && selecionar <= filmes.length) {

                Filme filmeSelecionado = filmes[selecionar - 1];

                int opcao;

                do {
                    System.out.println("===== GERENCIAR FILME =====");
                    System.out.println("1 - Consultar os dados do filme");
                    System.out.println("2 - Alterar a categoria");
                    System.out.println("3 - Alterar a sinopse");
                    System.out.println("0 - Voltar ao menu principal");
                    System.out.print("Escolha: ");

                    opcao = teclado.nextInt();
                    teclado.nextLine();

                    switch (opcao) {

                        case 1:
                            System.out.println("Título: "
                                + filmeSelecionado.getTitulo());

                            System.out.println("Duração: "
                                + filmeSelecionado.getDuracao() + " minutos");

                            System.out.println("Classificação etária: "
                                + filmeSelecionado.getClassificacao());

                            System.out.println("Categoria: "
                                + filmeSelecionado.getCategoria());

                            System.out.println("Sinopse: "
                                + filmeSelecionado.getSinopse());
                            break;

                        case 2:
                            System.out.println("Categorias permitidas:");
                            System.out.println("Ação, Aventura, Comédia, Drama e Terror");

                            System.out.print("Nova categoria: ");
                            String categoria = teclado.nextLine();

                            if (filmeSelecionado.setCategoria(categoria)) {
                                System.out.println("Categoria alterada com sucesso!");
                            } else {
                                System.out.println("Categoria recusada!");
                            }
                            break;

                        case 3:
                            System.out.print("Digite a nova sinopse: ");
                            String sinopse = teclado.nextLine();

                            filmeSelecionado.setSinopse(sinopse);

                            System.out.println("Sinopse alterada com sucesso!");
                            break;

                        case 0:
                            break;

                        default:
                            System.out.println("Opção inválida!");
                    }

                } while (opcao != 0);

            } else if (selecionar != 0) {
                System.out.println("Filme inválido!");
            }

        } while (selecionar != 0);
    }

    static void gerenciarSessoes(Scanner teclado, Sessao[] sessoes) {

        int selecionar;

        do {
            System.out.println("===== SESSÕES =====");

            for (int i = 0; i < sessoes.length; i++) {
                System.out.println(
                    (i + 1) + " - Código: " + sessoes[i].getCodigo()
                    + " | Filme: " + sessoes[i].getFilme().getTitulo()
                    + " | Início: " + sessoes[i].getHorarioInicio()
                );
            }

            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma sessão: ");

            selecionar = teclado.nextInt();
            teclado.nextLine();

            if (selecionar >= 1 && selecionar <= sessoes.length) {

                Sessao sessaoSelecionada = sessoes[selecionar - 1];

                int opcao;

                do {
                    System.out.println("===== GERENCIAR SESSÃO =====");
                    System.out.println("1 - Consultar os detalhes da sessão");
                    System.out.println("2 - Vender ingresso");
                    System.out.println("3 - Consultar os lugares disponíveis");
                    System.out.println("4 - Consultar o horário de término");
                    System.out.println("0 - Voltar ao menu principal");
                    System.out.print("Escolha: ");

                    opcao = teclado.nextInt();
                    teclado.nextLine();

                    switch (opcao) {

                        case 1:
                            Filme filme = sessaoSelecionada.getFilme();

                            System.out.println("Código: "
                                + sessaoSelecionada.getCodigo());

                            System.out.println("Horário de início: "
                                + sessaoSelecionada.getHorarioInicio());

                            System.out.println("Horário de término: "
                                + sessaoSelecionada.getHorarioTermino());

                            System.out.println("Filme: "
                                + filme.getTitulo());

                            System.out.println("Duração: "
                                + filme.getDuracao() + " minutos");

                            System.out.println("Classificação: "
                                + filme.getClassificacao());

                            System.out.println("Categoria: "
                                + filme.getCategoria());

                            System.out.println("Sinopse: "
                                + filme.getSinopse());

                            System.out.println("Capacidade máxima: "
                                + sessaoSelecionada.getCapacidade());

                            System.out.println("Ingressos vendidos: "
                                + sessaoSelecionada.getIngressosVendidos());

                            System.out.println("Lugares disponíveis: "
                                + sessaoSelecionada.getLugaresDisponiveis());

                            System.out.printf("Arrecadação: R$ %.2f%n",
                                sessaoSelecionada.getValorArrecadado());
                            break;

                        case 2:
                            System.out.println("TIPO DE INGRESSO");
                            System.out.println("1 - Integral");
                            System.out.println("2 - Meia-entrada");
                            System.out.print("Escolha: ");

                            int tipo = teclado.nextInt();
                            teclado.nextLine();

                            if (tipo == 1 || tipo == 2) {

                                System.out.print("Idade do espectador: ");
                                int idade = teclado.nextInt();
                                teclado.nextLine();

                                double resultado;

                                if (tipo == 1) {

                                    resultado =
                                        sessaoSelecionada.venderIngresso(idade);

                                } else {

                                    System.out.print(
                                        "Número do documento comprobatório: "
                                    );

                                    String documento = teclado.nextLine();

                                    resultado =
                                        sessaoSelecionada.venderIngresso(
                                            idade, documento
                                        );
                                }

                                if (resultado >= 0) {
                                    System.out.printf(
                                        "Ingresso vendido! Valor: R$ %.2f%n",
                                        resultado
                                    );
                                } else if (resultado == -1) {
                                    System.out.println(
                                        "Venda recusada: dados inválidos."
                                    );
                                } else if (resultado == -2) {
                                    System.out.println(
                                        "Venda recusada: idade incompatível "
                                        + "com a classificação do filme."
                                    );
                                } else if (resultado == -3) {
                                    System.out.println(
                                        "Venda recusada: não há lugares disponíveis."
                                    );
                                }

                            } else {
                                System.out.println("Tipo de ingresso inválido!");
                            }
                            break;

                        case 3:
                            System.out.println("Lugares disponíveis: "
                                + sessaoSelecionada.getLugaresDisponiveis());
                            break;

                        case 4:
                            System.out.println("Horário de término: "
                                + sessaoSelecionada.getHorarioTermino());
                            break;

                        case 0:
                            break;

                        default:
                            System.out.println("Opção inválida!");
                    }

                } while (opcao != 0);

            } else if (selecionar != 0) {
                System.out.println("Sessão inválida!");
            }

        } while (selecionar != 0);
    }

    static void gerenciarCinema(Scanner teclado, Sessao[] sessoes) {

        int opcao;

        do {
            System.out.println("===== INFORMAÇÕES DO CINEMA =====");
            System.out.println("1 - Consultar o preço integral do ingresso");
            System.out.println("2 - Alterar o preço integral do ingresso");
            System.out.println("3 - Consultar os totais de ingressos vendidos e de arrecadação");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha: ");

            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {

                case 1:
                    System.out.printf("Preço integral atual: R$ %.2f%n",
                        Sessao.getPrecoIngresso());
                    break;

                case 2:
                    System.out.print("Digite o novo preço: R$ ");
                    double novoPreco = teclado.nextDouble();
                    teclado.nextLine();

                    if (Sessao.setPrecoIngresso(novoPreco)) {
                        System.out.println("Preço atualizado com sucesso!");
                    } else {
                        System.out.println(
                            "Alteração recusada! O preço deve ser positivo."
                        );
                    }
                    break;

                case 3:
                    int totalIngressos = 0;
                    double totalArrecadado = 0.0;

                    for (int i = 0; i < sessoes.length; i++) {
                        totalIngressos = totalIngressos + sessoes[i].getIngressosVendidos();
                        totalArrecadado = totalArrecadado + sessoes[i].getValorArrecadado();
                    }

                    System.out.println("Total de ingressos vendidos: " + totalIngressos);
                    System.out.printf("Valor total arrecadado: R$ %.2f%n", totalArrecadado);
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        Filme filme1 = new Filme(
            "Interestelar", 169, "Drama", 10
        );

        Filme filme2 = new Filme(
            "Shrek", 90
        );

        Filme filme3 = new Filme(
            "Invocacao do Mal", 112, "Terror", 16
        );

        Sessao sessao1 = new Sessao(
            "S01", filme1, LocalTime.of(14, 0), 50
        );

        Sessao sessao2 = new Sessao(
            "S02", filme1, LocalTime.of(19, 0)
        );

        Sessao sessao3 = new Sessao(
            "S03", filme2, LocalTime.of(13, 30), 40
        );

        Sessao sessao4 = new Sessao(
            "S04", filme2, LocalTime.of(17, 0)
        );

        Sessao sessao5 = new Sessao(
            "S05", filme3, LocalTime.of(21, 0), 60
        );

        Filme[] filmes = {filme1, filme2, filme3};

        Sessao[] sessoes = {
            sessao1, sessao2, sessao3, sessao4, sessao5
        };

        int opcao;

        do {
            System.out.println("===== CINEMA =====");
            System.out.println("1 - Gerenciar filmes");
            System.out.println("2 - Gerenciar sessões e vender ingressos");
            System.out.println("3 - Consultar e atualizar informações do cinema");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1:
                    gerenciarFilmes(teclado, filmes);
                    break;

                case 2:
                    gerenciarSessoes(teclado, sessoes);
                    break;

                case 3:
                    gerenciarCinema(teclado, sessoes);
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        teclado.close();
    }
}