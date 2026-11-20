import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        // Exercício 1
        Queue<String> atendimento = new Queue<>();

        System.out.println(" Exercício 1: Fila de Atendimento");
        System.out.println("Operações iniciais: " + atendimento.getOperationCount());

        atendimento.enqueue("Ana");
        atendimento.enqueue("Bruno");
        atendimento.enqueue("Carla");
        atendimento.enqueue("Diego");
        atendimento.enqueue("Elisa");
        System.out.println("Fila após chegadas: " + atendimento.print());
        System.out.println("Operações: " + atendimento.getOperationCount()); // 5

        System.out.println("Atendido: " + atendimento.dequeue()); // Ana
        System.out.println("Atendido: " + atendimento.dequeue()); // Bruno
        System.out.println("Atendido: " + atendimento.dequeue()); // Carla
        System.out.println("Fila após atendimentos: " + atendimento.print());
        System.out.println("Próximo da fila: " + atendimento.peek());

        System.out.println("Total de operações: " + atendimento.getOperationCount()); // 8
        System.out.println("(5 enqueues + 3 dequeues)");

        // Exercício 2
        Stack<String> navegacao = new Stack<>();

        System.out.println("\n Exercício 2: Pilha de Navegação");
        navegacao.push("google.com");
        navegacao.push("github.com");
        navegacao.push("Siga.com");
        navegacao.push("Youtube.org");
        System.out.println("Páginas abertas: " + navegacao.print());
        System.out.println("Página atual: " + navegacao.peek());

        System.out.println("Voltar, saiu de: " + navegacao.pop());
        System.out.println("Voltar, saiu de: " + navegacao.pop());

        System.out.println("Página atual: " + navegacao.peek());
        System.out.println("Pilha: " + navegacao.print());
        System.out.println("Histórico de removidas: " + navegacao.getHistory());

        Stack<String> vazia = new Stack<>();
        vazia.pop();
        System.out.println("Histórico da pilha vazia: " + vazia.getHistory());

        // Exercício 3
        Deque<Integer> limitado = new Deque<>(5);

        System.out.println("\n Exercício 3: Deque com Capacidade Limitada");
        for (int i = 1; i <= 6; i++) {
            try {
                if (i % 2 == 0) {
                    limitado.insertFront(i);
                    System.out.println("insertFront(" + i + ") ok");
                } else {
                    limitado.insertBack(i);
                    System.out.println("insertBack(" + i + ") ok");
                }
            } catch (IllegalStateException e) {
                System.out.println("Erro ao inserir " + i + ": " + e.getMessage());
            }
        }

        System.out.println("Deque final: " + limitado.print());
        System.out.println("Está cheio? " + limitado.isFull());

        System.out.println("Removido do fundo: " + limitado.removeBack());
        limitado.insertBack(99);
        System.out.println("Após remover e inserir 99: " + limitado.print());

        Deque<String> padrao = new Deque<>();
        padrao.insertBack("teste");
        System.out.println("Deque padrão: " + padrao.print());

        // Exercício 4
        Stack<String> undo = new Stack<>(5);

        System.out.println("\n Exercício 4: Pilha de Desfazer (Undo)");
        String[] acoes = {
                "Digitar 'Olá'",
                "Digitar ' mundo'",
                "Aplicar negrito",
                "Colar texto",
                "Mudar fonte",
                "Apagar parágrafo"
        };

        for (String acao : acoes) {
            try {
                undo.push(acao);
                System.out.println("Ação registrada: " + acao);
            } catch (IllegalStateException e) {
                System.out.println("Erro ao registrar '" + acao + "': " + e.getMessage());
            }
        }

        System.out.println("Pilha de undo: " + undo.print());
        System.out.println("Está cheia? " + undo.isFull());

        System.out.println("Desfazendo: " + undo.pop());
        undo.push("Apagar parágrafo");
        System.out.println("Após desfazer e nova ação: " + undo.print());
        System.out.println("Histórico de desfeitas: " + undo.getHistory());

        Stack<Integer> pilhapadrao = new Stack<>();
        pilhapadrao.push(1);
        System.out.println("Pilha padrão: " + pilhapadrao.print());

        // Exercício 5
        Deque<String> carrinho = new Deque<>();

        System.out.println("\n Exercício 5: Carrinho de Compras (itens únicos) ");
        String[] itens = {"Notebook", "Mouse", "Teclado", "Mouse", "Placa", "Cabo"};

        for (int i = 0; i < itens.length; i++) {
            try {
                if (i % 2 == 0) {
                    carrinho.insertBack(itens[i]);
                    System.out.println("Adicionado ao final: " + itens[i]);
                } else {
                    carrinho.insertFront(itens[i]);
                    System.out.println("Adicionado ao início: " + itens[i]);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        System.out.println("Carrinho final: " + carrinho.print());

        System.out.println("Removido do início: " + carrinho.removeFront()); // Monitor
        carrinho.insertBack("Monitor");
        System.out.println("Após remover e readicionar Monitor: " + carrinho.print());

        // Exercício 6
        LinkedList<String> lista = new LinkedList<>();

        System.out.println("\n Exercício 6: Histórico de Remoções na LinkedList");
        lista.insertTail("A");
        lista.insertTail("B");
        lista.insertTail("C");
        lista.insertTail("D");
        lista.insertTail("E");
        lista.insertHead("Z");
        System.out.println("Lista inicial: " + lista.print());

        System.out.println("removeHead: " + lista.removeHead());
        System.out.println("removeTail: " + lista.removeTail());
        System.out.println("remove(1): " + lista.remove(1));
        System.out.println("Lista após remoções: " + lista.print());

        System.out.println("remove(10): " + lista.remove(10));
        System.out.println("Histórico: " + lista.getHistory());

        LinkedList<Integer> listavazia = new LinkedList<>();
        listavazia.removeHead();
        System.out.println("Histórico da lista vazia: " + vazia.getHistory());

        // Exercício 7
        LinkedList<Integer> numeros = new LinkedList<>();

        System.out.println("\n Exercício 7: Reversão da LinkedList ");
        for (int i = 1; i <= 5; i++) {
            numeros.insertTail(i * 10);
        }

        System.out.println("Antes:  " + numeros.print());
        numeros.reverse();
        System.out.println("Depois: " + numeros.print());
        System.out.println("Head: " + numeros.peekHead() + ", Tail: " + numeros.peekTail());

        numeros.insertTail(0);
        numeros.insertHead(99);
        System.out.println("Após novas inserções: " + numeros.print());

        LinkedList<String> listavazia2 = new LinkedList<>();
        listavazia2.reverse();
        System.out.println("Lista vazia: " + vazia.print());

        LinkedList<String> unico = new LinkedList<>();
        unico.insertTail("X");
        unico.reverse();
        System.out.println("Um elemento: " + unico.print());

        numeros.reverse();
        numeros.reverse();
        System.out.println("Duas reversões: " + numeros.print());

        // Exercício 8
        LinkedList<String> frutas = new LinkedList<>();

        System.out.println("\n Exercício 8: Contagem de Ocorrências");
        String[] itens8 = {"maçã", "banana", "maçã", "uva", "banana", "maçã", "pera"};
        for (String fruta : itens) {
            frutas.insertTail(fruta);
        }

        System.out.println("Lista: " + frutas.print());
        System.out.println("Ocorrências de 'maçã': " + frutas.countOccurrences("maçã"));
        System.out.println("Ocorrências de 'banana': " + frutas.countOccurrences("banana"));
        System.out.println("Ocorrências de 'uva': " + frutas.countOccurrences("uva"));
        System.out.println("Ocorrências de 'kiwi': " + frutas.countOccurrences("kiwi"));

        frutas.remove(0);
        System.out.println("Após remover a 1ª maçã: " + frutas.countOccurrences("maçã"));

        LinkedList<Integer> vazia3 = new LinkedList<>();
        System.out.println("Lista vazia: " + vazia3.countOccurrences(5));

        LinkedList<String> comNulo = new LinkedList<>();
        comNulo.insertTail(null);
        comNulo.insertTail("a");
        comNulo.insertTail(null);
        System.out.println("Ocorrências de null: " + comNulo.countOccurrences(null));

        // Exercício 9
        LinkedList<Integer> valores = new LinkedList<>();

        System.out.println("\n Exercício 9: Remoção de Todas as Ocorrências");
        int[] entrada = {7, 7, 1, 2, 7, 3, 7, 4, 7};
        for (int n : entrada) {
            valores.insertTail(n);
        }

        System.out.println("Antes:  " + valores.print());
        int removidos = valores.removeAll(7);
        System.out.println("Removidos: " + removidos);
        System.out.println("Depois: " + valores.print());
        System.out.println("Head: " + valores.peekHead() + ", Tail: " + valores.peekTail());
        System.out.println("Histórico: " + valores.getHistory());

        System.out.println("removeAll(99): " + valores.removeAll(99));
        System.out.println("Lista: " + valores.print());

        valores.insertTail(8);
        valores.insertHead(0);
        System.out.println("Após novas inserções: " + valores.print());

        LinkedList<String> iguais = new LinkedList<>();
        iguais.insertTail("x");
        iguais.insertTail("x");
        iguais.insertTail("x");
        System.out.println("Removidos: " + iguais.removeAll("x"));
        System.out.println("Lista vazia: " + iguais.print());
        System.out.println("Head: " + iguais.peekHead() + ", Tail: " + iguais.peekTail());
        iguais.insertTail("novo");
        System.out.println("Reinserindo: " + iguais.print());

        // Exercício 10
        LinkedList<String> cidades = new LinkedList<>();

        System.out.println("\n=== Exercício 10: LinkedList para ArrayList ===");
        cidades.insertTail("Recife");
        cidades.insertTail("Salvador");
        cidades.insertTail("Fortaleza");
        cidades.insertHead("Natal");

        System.out.println("LinkedList: " + cidades.print());
        ArrayList<String> convertida = cidades.toArray();
        System.out.println("ArrayList:  " + convertida);

        convertida.add("Belém");
        convertida.remove("Natal");
        System.out.println("ArrayList alterado: " + convertida);
        System.out.println("LinkedList intacta: " + cidades.print());

        cidades.reverse();
        System.out.println("Após reverse(): " + cidades.toArray());

        LinkedList<Integer> vazia4 = new LinkedList<>();
        System.out.println("Lista vazia: " + vazia4.toArray());
    }
}

