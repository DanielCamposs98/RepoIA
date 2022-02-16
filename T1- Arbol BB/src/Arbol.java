
public class Arbol <T> {

    private Nodo<T> raiz;

    public Arbol(){
        this.raiz = null;
    }

    public Nodo<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo<T> raiz) {
        this.raiz = raiz;
    }

    //Recorrido del arbol por busqueda inorden
    public void buscarOrden(){
        buscarOrden(this.raiz);
    }

    private void buscarOrden(Nodo<T> n){
        if(!this.vacio(n) ){
            buscarOrden(n.getHijoIzq());
            System.out.println(n.getDato() + " ");
            buscarOrden(n.getHijoDer());
        }
    }


    private boolean vacio(Nodo <T> n){
        return n == null;
    }


}