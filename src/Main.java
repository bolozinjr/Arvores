import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        arvore.emOrdem(arvore.raiz);  // Saída esperada: D B E A C F
        int total = arvore.contarNos(arvore.raiz);
        System.out.println("Total de nós: " + total);
    }
}
