import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static <MS extends Comparable<MS>> void mergeSort(MS[] vetor) {
        if (vetor.length < 2){
            return;
        }

        int meio = vetor.length / 2;

        MS[] vetEsq = Arrays.copyOfRange(vetor, 0, meio);
        MS[] vetDir = Arrays.copyOfRange(vetor, meio, vetor.length);

        mergeSort(vetEsq);
        mergeSort(vetDir);

        int posEsq = 0, posDir = 0, posRes = 0;

        while (posEsq < vetEsq.length && posDir < vetDir.length){
            if (vetEsq[posEsq].compareTo(vetDir[posDir]) < 0) {
                vetor[posRes] = vetEsq[posEsq];
                posEsq++;
            } else {
                vetor[posRes] = vetDir[posDir];
                posDir++;
            }
            posRes++;
        }

        while (posEsq < vetEsq.length) {
            vetor[posRes] = vetEsq[posEsq];
            posEsq++;
            posRes++;
        }

        while (posDir < vetDir.length) {
            vetor[posRes] = vetDir[posDir];
            posDir++;
            posRes++;
        }
    }

    public static void main(String[] args) throws IOException {
        Integer[] nums = {77, 44, 22, 33, 99, 55, 88, 0, 66, 11};

        String[] nomesDesordenados = {"Maria", "João", "Ana", "Carlos", "Beatriz"};

        mergeSort(nums);
        System.out.println(Arrays.toString(nums));

        mergeSort(nomesDesordenados);
        System.out.println(Arrays.toString(nomesDesordenados));

        Path caminho = Path.of("data/nomes-desord.txt");

        List<String> lista = Files.readAllLines(caminho);

        String[] nomes = lista.toArray(new String[0]);

        mergeSort(nomes);

        for (String nome : nomes) {
            System.out.println(nome);

        }
    }}
