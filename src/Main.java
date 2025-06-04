public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();

        arvore.inserir("A");
        arvore.inserir("B");
        arvore.inserir("C");
        arvore.inserir("D");
        arvore.inserir("E");
        arvore.inserir("F");
        arvore.inserir("G");

        System.out.print("Pré-ordem: ");
        arvore.preOrdem(arvore.raiz);

        System.out.println("\nBusca em nível:");
        arvore.buscaEmNivel();

        arvore.excluir("F"); // Remove um nó com 2 filhos
        System.out.println("Após exclusão de F:");
        arvore.preOrdem(arvore.raiz);
    }
}
