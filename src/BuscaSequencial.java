public class BuscaSequencial{

    public static int buscaSequencialInt(Integer[] vetor, Integer valorBusca) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].equals(valorBusca)) {
                return i;
            }
        }
        return -1;
    }
    public static int buscaSequencialString(String[] vetor, String valorBusca) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].equals(valorBusca)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Integer[] numeros = {5, 7, 9, 8, 1, 3, 44, 66, 12};

        String[] frutas = {"laranja", "maça", "pera", "uva", "limão", "mamão", "tangerina"};

        System.out.println("Posição do número 44: " + buscaSequencialInt(numeros, 44));
        System.out.println("Posição do número 100: " + buscaSequencialInt(numeros, 100));

        System.out.println("Posição de uva: " + buscaSequencialString(frutas, "uva"));
        System.out.println("Posição de morango: " + buscaSequencialString(frutas, "morango"));
    }

}
