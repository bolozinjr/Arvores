public class ArvoreRubroNegra {
    private Node root;
    private final Node NIL;

    public ArvoreRubroNegra() {
    NIL = new Node(-1);
    NIL.color = Color.PRETO;
    NIL.left = NIL.right = NIL.parent = null;
    root = NIL;
    }

    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != NIL) y.left.parent = x;

        y.parent = x.parent;

        if (x.parent == null) root = y;
        else if (x == x.parent.left) x.parent.left = y;
        else x.parent.right = y;

        y.left = x;
        x.parent = y;
    }

    private void rightRotate(Node y) {
        Node x = y.left;
        y.left = x.right;
        if (x.right != NIL) x.right.parent = y;

        x.parent = y.parent;

        if (y.parent == null) root = x;
        else if (y == y.parent.right) y.parent.right = x;
        else y.parent.left = x;

        y.right = x;
        x.parent = y;
    }

    public void insert(int key) {
        Node node = new Node(key);
        node.left = node.right = node.parent = NIL;

        Node y = null;
        Node x = root;

        while (x != NIL) {
            y = x;
            if (node.key < x.key) x = x.left;
            else x = x.right;
        }

        node.parent = y;
        if (y == null) root = node;
        else if (node.key < y.key) y.left = node;
        else y.right = node;

        node.left = NIL;
        node.right = NIL;
        node.color = Color.VERMELHO;

        insertFix(node);
    }

    private void insertFix(Node k) {
        while (k.parent != null && k.parent.color == Color.VERMELHO) {
            if (k.parent == k.parent.parent.left) {
                Node u = k.parent.parent.right;
                if (u.color == Color.VERMELHO) {
                    k.parent.color = Color.PRETO;
                    u.color = Color.PRETO;
                    k.parent.parent.color = Color.VERMELHO;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.color = Color.PRETO;
                    k.parent.parent.color = Color.VERMELHO;
                    rightRotate(k.parent.parent);
                }
            }
        }
    }
}