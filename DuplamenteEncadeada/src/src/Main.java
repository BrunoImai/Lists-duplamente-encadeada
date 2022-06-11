package src;

public class Main {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada listaDE = new ListaDuplamenteEncadeada();

        listaDE.add(1);
        listaDE.add(2);
        listaDE.add(3);
        listaDE.add(4);
        listaDE.add(5);
        System.out.println(listaDE);
        listaDE.addAt(4,2);
        System.out.println(listaDE);
        System.out.println(listaDE.removeAt(2));
        System.out.println(listaDE);
        System.out.println(listaDE.removeAt(3));
        System.out.println(listaDE);
        listaDE.getSize();




    }
}
