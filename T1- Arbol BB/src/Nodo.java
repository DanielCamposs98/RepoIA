//Clase Nodo con Genéricos

public class Nodo <T>{

    private T dato;
    private Nodo<T> hijoIzq;
    private Nodo<T> hijoDer;

    public Nodo(T dato) {
        this.dato = dato;
        this.hijoIzq = null;
        this.hijoDer = null;
    }
    public T getDato() {
        return dato;
    }

    public Nodo<T> getHijoIzq() {
        return hijoIzq;
    }
    public void setHijoIzq(Nodo<T> hijoIzq) {
        this.hijoIzq = hijoIzq;
    }
    public Nodo<T> getHijoDer() {
        return hijoDer;
    }
    public void setHijoDer(Nodo<T> hijoDer) {
        this.hijoDer = hijoDer;
    }

}