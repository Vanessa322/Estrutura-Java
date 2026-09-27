import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class SelectionSort {

    public static <SS extends Comparable<SS>> void selectionSort(SS[] vetor){
        for (int posSel = 0; posSel < vetor.length - 1; posSel++){

            int posMenor = posSel;

            for (int i = posMenor + 1; i < vetor.length; i++) {
                if (vetor[i].compareTo(vetor[posMenor]) < 0) {
                    posMenor = i;
                }
            }
            if (vetor[posSel].compareTo(vetor[posMenor]) > 0){
                SS temp = vetor[posSel];
                vetor[posSel] = vetor[posMenor];
                vetor[posMenor] = temp;
            }
        }
    }

    public static void main (String[] args) throws IOException {
        Integer[] nums = {77, 44, 22, 33, 99, 55, 88, 0, 66, 11};

        String[] nomesDesordenados = {"Maria", "João", "Ana", "Carlos", "Beatriz"};

        selectionSort(nums);
        System.out.println(Arrays.toString(nums));

        selectionSort(nomesDesordenados);
        System.out.println(Arrays.toString(nomesDesordenados));

        Path caminho = Path.of("data/nomes-desord.txt");

        List<String> lista = Files.readAllLines(caminho);

        String[] nomes = lista.toArray(new String[0]);

        selectionSort(nomes);

        for (String nome : nomes) {
            System.out.println(nome);
        }

    }
}
