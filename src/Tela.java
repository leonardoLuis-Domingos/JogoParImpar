
import java.util.Random;
import java.util.Scanner;

public class Tela {

    public static int pontosJogador1;
    public static int pontosJogador2;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int entrarNoJogo;
        System.out.println("*** JOGO DE PAR OU IMPAR ***");

        do {
            System.out.println("Para jogar tecle (1)");
            System.out.println("Para sair tecle (0)");
            entrarNoJogo = sc.nextInt();

            if (entrarNoJogo == 1) {

                System.out.println("*** Bem vindo ao Jogo ***");
                System.out.println("*************************");
                dentroDoJogo(sc);
                break;
            }
        } while (entrarNoJogo != 0);

        System.out.println("Obrigado tchau babaca ");


        sc.close();
    }

    public static void dentroDoJogo(Scanner sc) {
        sc.nextLine();
        System.out.println("Informe seu nome ");
        String nomeDoJogador1 = sc.nextLine();
        System.out.println("*************************");
        int escolha = 0;
        String nomeDoJogador2 = "";
        int recebeSorteio = 0;
        char verifica = 's';
        int pontosPessoa = 0;
        int pontosPc = 0;
        do {
            System.out.println(nomeDoJogador1 + " - Você deseja jogar com uma pessoa ou contra o PC ?");
            System.out.println("Para jogar contra uma pessoa tecle (1) ");
            System.out.println("Para jogar contra o PC tecle (2) ");
            escolha = sc.nextInt();

            if (escolha == 1) {
                System.out.println("Informe o nome do segundo jogador ");
                sc.nextLine();
                nomeDoJogador2 = sc.nextLine();

                System.out.println("**********************************");
                System.out.println("AGORA VAMOS SORTEAR UM NÚMERO O TIPO DESSE NUMERO VAI DETERMINAR" +
                        " SE O " + nomeDoJogador1 + " SERA PAR OU IMPAR ");

                recebeSorteio = sorteioDeParOuImpar(nomeDoJogador1);
                jogando(recebeSorteio, nomeDoJogador1, nomeDoJogador2);
            } else if (escolha == 2) {
                do {
                    int numeroPC = sorteio();
                    int soma = 0;
                    System.out.println(nomeDoJogador1 + " Voce é par");
                    System.out.println(nomeDoJogador1 + " Informe seu numero");
                    int numero = sc.nextInt();

                    soma = numeroPC + numero;

                    if (soma % 2 == 0) {
                        pontosPessoa = pontosPessoa + 1;
                        System.out.println(nomeDoJogador1 + "Venceu");
                        System.out.println(nomeDoJogador1 + ": " + pontosPessoa + " x " + "Pc: " + pontosPc);
                        System.out.println(nomeDoJogador1 + "Deseja jogar novamente ?");
                        System.out.println("Tecle (s) - para sim ou Tecle (n) - Para não");
                        verifica = sc.next().charAt(0);
                    } else {

                        pontosPc = pontosPc + 1;
                        System.out.println("PC Venceu ");
                        System.out.println(nomeDoJogador1 + ": " + pontosPessoa + " x " + "Pc: " + pontosPc);
                        System.out.println(nomeDoJogador1 + "Deseja jogar novamente ?");
                        System.out.println("Tecle (s) - para sim ou Tecle (n) - Para não");
                        verifica = sc.next().charAt(0);
                    }
                } while (verifica != 'n');
            }
        } while (escolha != 1 && escolha != 2);


    }

    public static int sorteio() {

        Random random = new Random();

        int x = random.nextInt(11);

        return x;
    }

    public static int sorteioDeParOuImpar(String nome1) {

        int recebeNumeroSorteio = sorteio();
        int tipo = 0;
        if (recebeNumeroSorteio % 2 == 0) {

            System.out.println(nome1 + " SERA " + recebeNumeroSorteio + " PAR");
            tipo = 0;
        } else {
            System.out.println(nome1 + " SERA " + recebeNumeroSorteio + " IMPAR");
            tipo = 1;
        }

        return tipo;
    }

    public static void verificaQuemGanhou(int soma, String nome1, String nome2, int recebeSorteio) {

        System.out.println("SOMA = " + soma);
        Scanner sc = new Scanner(System.in);
        char jogarNovamente = 's';

        do {
            if ((soma % 2 == 0 && recebeSorteio == 0) || (soma % 2 != 0 && recebeSorteio == 1)) {
                pontosJogador1 = pontosJogador1 + 1;
                System.out.println(nome1 + "Venceu");
                System.out.println("**************");
                System.out.println(nome1 + ": " + pontosJogador1 + " X " + nome2 + ": " + pontosJogador2);
                System.out.println("**************");
                System.out.println("Deseja jogar novamente ?");
                System.out.println("Tecle (S) - Para Sim ou Tecle (N) - Para não ");
                jogarNovamente = sc.next().charAt(0);

                if (jogarNovamente == 's') {
                    recebeSorteio = sorteioDeParOuImpar(nome1);
                    jogando(recebeSorteio, nome1, nome2);
                }

            } else {

                pontosJogador2 = pontosJogador2 + 1;
                System.out.println(nome2 + "Venceu");
                System.out.println("**************");
                sc.nextLine();
                System.out.println(nome1 + ": " + pontosJogador1 + " X " + nome2 + ": " + pontosJogador2);
                System.out.println("**************");
                System.out.println("Deseja jogar novamente ?");
                System.out.println("Tecle (S) - Para Sim ou Tecle (N) - Para não ");
                jogarNovamente = sc.next().charAt(0);

                if (jogarNovamente == 's') {
                    recebeSorteio = sorteioDeParOuImpar(nome1);
                    jogando(recebeSorteio, nome1, nome2);
                }
            }

        } while (jogarNovamente != 'n');

    }

    public static void jogando(int recebeSorteio, String nomeDoJogador1, String nomeDoJogador2) {

        Scanner sc = new Scanner(System.in);

        int numeroDoJogador1 = 0;
        int numeroDoJogador2 = 0;
        int soma = 0;

        System.out.println(nomeDoJogador1 + " Digite seu numero ");
        numeroDoJogador1 = sc.nextInt();
        System.out.println(nomeDoJogador2 + " Digite seu numero ");
        numeroDoJogador2 = sc.nextInt();

        soma = numeroDoJogador1 + numeroDoJogador2;

        verificaQuemGanhou(soma, nomeDoJogador1, nomeDoJogador2, recebeSorteio);
    }
}
