public class No {
    String valor;
    No esquerda, direita;
    int altura;

    public No(String valor) {
        this.valor = valor;
        this.altura = 1;
        this.esquerda = null;
        this.direita = null;
    }
}
