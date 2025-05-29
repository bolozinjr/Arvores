public class No {
    String valor;
    No esquerda, direita;
    int fatorBalanceamento;

    public No(String valor) {
        this.valor = valor;
        esquerda = direita = null;
        this.fatorBalanceamento = 0;
    }
}


