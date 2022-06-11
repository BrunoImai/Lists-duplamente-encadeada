package src;

public class ListaDuplamenteEncadeada<T> {

    private Node<T> base = null;
    private Node<T> top = null;
    private int size;

    public void add(T value) {
        var node = new Node (value);
        node.data = value;
        if(isEmpty()) {
            base = node;
        } else {
            node.last = top;
            top.next = node;
        }
        top = node;
        size++;
    }

    public void addAt(int index, T valor) {
        if (index == getSize()) {
            add(valor);
        }

        var node = new Node(valor);
        var next = getNode(index);
        var last = next.last;

        node.next = next;
        node.last = last;

        if (last != null) {
            last.next = node;
        } else {
            base = node;
        }

        next.last = node;
        size++;
    }

    public T removeAt(int index) {
        if (index < 0 || index > size) { throw new IndexOutOfBoundsException("Index invalido"); }
        var node = getNode(index);
        removeNode(node) ;
        return node.data;
    }

    private T removeNode(Node<T> node){
        T dado = node.data;
        var next = node.next;
        var last = node.last;

        if(node == base) {
            base = base.next;
            if(base != null) {
                base = null;
            }
        } else if (node.next == null) {
            last.next = null;
        } else {
            next.last = last;
            last.next = next;
        }

        node.last = null;
        node.next = null;
        return dado;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Não há essa posição :(");
        }
        int mid = size / 2;

        if (mid >= index) {
            Node<T> actualNode = top;
            for (int i = size -1; i != index; i--) {
                actualNode = actualNode.last;
            }
            return actualNode;
        }
        Node<T> noAtual = base;
        for (int i = 0; i < index; i++) {
            noAtual = noAtual.next;
        }
        return noAtual;
    }

    public boolean isEmpty(){
        return this.base == null && this.top == null;
    }

    public boolean isFull() {
        return false;
    }

    public int getSize() {
        return size;
    }

    public void set(int posicao, T valor) {
        getNode(posicao).data = valor;
    }

    public T get(int posicao) {
        return getNode(posicao).data;
    }


    @Override
    public String toString() {
        String string = "[ ";

        for(Node<T> node = base; node != null; node = node.next) {
            string += node.data + " ";
        }
        return string += "]";
    }
}
class Node<T>{
    Node<T> last;
    T data;
    Node<T> next;

    public Node(T valor) {
        this.data = valor;
    }

}