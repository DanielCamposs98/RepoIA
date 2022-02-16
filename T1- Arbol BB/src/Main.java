public class Main {

    public static void main(String[] a){

        Arbol<Integer> arb = new Arbol<>();
        Nodo<Integer> n1 = new Nodo<>(1);
        Nodo<Integer> n2 = new Nodo<>(2);
        Nodo<Integer> n3 = new Nodo<>(3);
        Nodo<Integer> n4 = new Nodo<>(4);
        Nodo<Integer> n5 = new Nodo<>(5);

        n2.setHijoIzq(n4);
        n2.setHijoDer(n5);
        n1.setHijoIzq(n2);
        n1.setHijoDer(n3);
        arb.setRaiz(n1);
        arb.buscarOrden();

    }
}
