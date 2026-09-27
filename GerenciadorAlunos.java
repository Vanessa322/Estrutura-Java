import java.util.Arrays;
import java.util.Scanner;

public class GerenciadorAlunos {

    private static Aluno[] alunos = new Aluno[5];
    private static int quantidade = 0;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> cadastrarAluno();
                case 2 -> relatorioPorNome();
                case 3 -> relatorioPorRA();
                case 4 -> relatorioAprovados();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("===== MENU =====");
        System.out.println("1 - Cadastrar aluno");
        System.out.println("2 - Relatório por Nome (crescente)");
        System.out.println("3 - Relatório por RA (decrescente)");
        System.out.println("4 - Relatório de Aprovados (crescente por Nome)");
        System.out.println("0 - Sair");
    }

    private static void cadastrarAluno() {
        garantirCapacidade();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        int ra = lerInt("RA: ");
        int idade = lerInt("Idade: ");

        System.out.print("Sexo (M/F): ");
        char sexo = scanner.nextLine().trim().toUpperCase().charAt(0);

        double media = lerDouble("Média: ");

        alunos[quantidade] = new Aluno(nome, ra, idade, sexo, media);
        quantidade++;

        System.out.println("Aluno cadastrado com sucesso!");
    }

    private static void garantirCapacidade() {
        if (quantidade == alunos.length) {
            alunos = Arrays.copyOf(alunos, alunos.length * 2);
        }
    }

    private static void relatorioPorNome() {
        if (!existemAlunos()) return;

        Aluno[] copia = Arrays.copyOf(alunos, quantidade);
        SelectionSort.selectionSort(copia); // compareTo do Aluno = por nome (A-Z)

        imprimirRelatorio("RELATÓRIO POR NOME (CRESCENTE)", copia);
    }

    private static void relatorioPorRA() {
        if (!existemAlunos()) return;

        Aluno[] copia = Arrays.copyOf(alunos, quantidade);

        boolean trocou;

        do {
            trocou = false;

            for (int i = 0; i < copia.length - 1; i++) {
                if (copia[i].getRa() < copia[i + 1].getRa()) {

                    Aluno temp = copia[i];
                    copia[i] = copia[i + 1];
                    copia[i + 1] = temp;

                    trocou = true;
                }
            }
        } while (trocou);

        imprimirRelatorio("RELATÓRIO POR RA (DECRESCENTE)", copia);
    }

    private static void relatorioAprovados() {
        if (!existemAlunos()) return;

        int total = 0;
        for (int i = 0; i < quantidade; i++) {
            if (alunos[i].getResultado().equals("Aprovado")) {
                total++;
            }
        }

        if (total == 0) {
            System.out.println("Nenhum aluno aprovado no momento.");
            return;
        }

        Aluno[] aprovados = new Aluno[total];
        int idx = 0;
        for (int i = 0; i < quantidade; i++) {
            if (alunos[i].getResultado().equals("Aprovado")) {
                aprovados[idx++] = alunos[i];
            }
        }

        SelectionSort.selectionSort(aprovados); // por nome (A-Z)

        imprimirRelatorio("RELATÓRIO DE APROVADOS (CRESCENTE POR NOME)", aprovados);
    }

    private static void imprimirRelatorio(String titulo, Aluno[] lista) {
        System.out.println("----- " + titulo + " -----");
        for (Aluno aluno : lista) {
            System.out.println(aluno);
        }
    }

    private static boolean existemAlunos() {
        if (quantidade == 0) {
            System.out.println("Nenhum aluno cadastrado ainda.");
            return false;
        }
        return true;
    }

    private static int lerInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número inteiro.");
            }
        }
    }

    private static double lerDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número (ex.: 7.5).");
            }
        }
    }
}