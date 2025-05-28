import java.util.LinkedList;
import java.util.Queue;

public class Arvore {
    No raiz;

    public Arvore() {
        // Montando a árvore conforme a imagem
        raiz = new No("A");
        raiz.esquerda = new No("B");
        raiz.direita = new No("C");
        raiz.esquerda.esquerda = new No("D");
        raiz.esquerda.direita = new No("E");
        raiz.direita.direita = new No("F");
    }

//    public void emOrdem(No no) {
//        if (no != null) {
//            emOrdem(no.esquerda);
//            emOrdem(no.direita);
//            System.out.print(no.valor + " ");
//
//        }
//    }

    public void buscaEmNivel() {
        if (raiz == null) return;

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No atual = fila.poll();
            System.out.print(atual.valor + " ");

            if (atual.esquerda != null) fila.add(atual.esquerda);
            if (atual.direita != null) fila.add(atual.direita);
        }
    }

    public int contarNos (No no) {
        if (no == null) return 0;
        return 1 + contarNos(no.esquerda) + contarNos(no.direita);
    }
}
