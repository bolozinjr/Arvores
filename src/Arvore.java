import java.util.LinkedList;
import java.util.Queue;

public class Arvore {
    No raiz;

    public int altura(No no) {
        return (no == null) ? 0 : no.altura;
    }

    public int fatorBalanceamento(No no) {
        return (no == null) ? 0 : altura(no.esquerda) - altura(no.direita);
    }

    private No rotacaoDireita(No y) {
        No x = y.esquerda;
        No T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    private No rotacaoEsquerda(No x) {
        No y = x.direita;
        No T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    public void inserir(String valor) {
        raiz = inserirRec(raiz, valor);
    }

    private No inserirRec(No no, String valor) {
        if (no == null) return new No(valor);

        if (valor.compareTo(no.valor) < 0)
            no.esquerda = inserirRec(no.esquerda, valor);
        else if (valor.compareTo(no.valor) > 0)
            no.direita = inserirRec(no.direita, valor);
        else
            return no; // duplicado

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
        int fb = fatorBalanceamento(no);

        // Rotações
        if (fb > 1 && valor.compareTo(no.esquerda.valor) < 0)
            return rotacaoDireita(no);
        if (fb < -1 && valor.compareTo(no.direita.valor) > 0)
            return rotacaoEsquerda(no);
        if (fb > 1 && valor.compareTo(no.esquerda.valor) > 0) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }
        if (fb < -1 && valor.compareTo(no.direita.valor) < 0) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    public void excluir(String valor) {
        raiz = excluirRec(raiz, valor);
    }

    private No excluirRec(No no, String valor) {
        if (no == null) return null;

        if (valor.compareTo(no.valor) < 0)
            no.esquerda = excluirRec(no.esquerda, valor);
        else if (valor.compareTo(no.valor) > 0)
            no.direita = excluirRec(no.direita, valor);
        else {
            // Um ou nenhum filho
            if (no.esquerda == null || no.direita == null) {
                No temp = (no.esquerda != null) ? no.esquerda : no.direita;
                no = temp;
            } else {
                No sucessor = menorValor(no.direita);
                no.valor = sucessor.valor;
                no.direita = excluirRec(no.direita, sucessor.valor);
            }
        }

        if (no == null) return null;

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
        int fb = fatorBalanceamento(no);

        // Rebalancear
        if (fb > 1 && fatorBalanceamento(no.esquerda) >= 0)
            return rotacaoDireita(no);
        if (fb > 1 && fatorBalanceamento(no.esquerda) < 0) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }
        if (fb < -1 && fatorBalanceamento(no.direita) <= 0)
            return rotacaoEsquerda(no);
        if (fb < -1 && fatorBalanceamento(no.direita) > 0) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    private No menorValor(No no) {
        while (no.esquerda != null) no = no.esquerda;
        return no;
    }

    public void preOrdem(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            preOrdem(no.esquerda);
            preOrdem(no.direita);
        }
    }

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
        System.out.println();
    }

    public int contarNos(No no) {
        if (no == null) return 0;
        return 1 + contarNos(no.esquerda) + contarNos(no.direita);
    }
}
