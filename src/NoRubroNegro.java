enum Color {
    VERMELHO, PRETO
}

class Node {
    int key;
    Color color;
    Node left, right, parent;

    Node(int key) {
        this.key = key;
        this.color = Color.VERMELHO;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}