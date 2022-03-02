package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BusquedaAStar {

    public static void busqueda(int [] board, char heuristica){

        BuscarNodo raiz = new BuscarNodo(new PuzzleState(board));
        Queue<BuscarNodo> q = new LinkedList<>();
        q.add(raiz);


        int contador=1;

        while(!q.isEmpty()){
            BuscarNodo nodoTemp = q.poll();

            if(!nodoTemp.getStateActual().objetivoAlcanzado()){
                ArrayList<State> sucesoresTemp = nodoTemp.getStateActual().sucesores();
                ArrayList<BuscarNodo> nodosSuc= new ArrayList<BuscarNodo>();

                for(int i=0; i< sucesoresTemp.size();i++){
                    BuscarNodo visitado;

                    if(heuristica == 'o'){
                        visitado = new BuscarNodo(nodoTemp, sucesoresTemp.get(i), nodoTemp.getCosto()+ sucesoresTemp.get(i).obtenerCosto(), ((PuzzleState) sucesoresTemp.get(i)).getContadorFuera());
                    }else{
                        visitado = new BuscarNodo(nodoTemp, sucesoresTemp.get(i), nodoTemp.getCosto()+ sucesoresTemp.get(i).obtenerCosto(), ((PuzzleState) sucesoresTemp.get(i)).getDistanciaManh());
                    }

                    if(!checarRepeticiones(visitado)){
                        nodosSuc.add(visitado);
                    }
                }
                if(nodosSuc.size()== 0){
                    continue;
                }

                BuscarNodo nodoMen= nodosSuc.get(0);

                for(int i=0; i< nodosSuc.size(); i++){
                    if(nodoMen.getCostoFn() > nodosSuc.get(i).getCostoFn()){
                        nodoMen= nodosSuc.get(i);
                    }
                }

                int valorMen= (int) nodoMen.getCostoFn();

                for(int i=0; i< nodosSuc.size(); i++){
                    if(nodosSuc.get(i).getCostoFn() == valorMen){
                        q.add(nodosSuc.get(i));
                    }
                }

                contador++;
            }else{
                Stack <BuscarNodo> solucion = new Stack<>();
                solucion.push(nodoTemp);
                nodoTemp = nodoTemp.getNodoPadre();

                while(nodoTemp.getNodoPadre() != null){
                    solucion.push(nodoTemp);
                    nodoTemp = nodoTemp.getNodoPadre();
                }

                solucion.push(nodoTemp);

                int tamCiclo= solucion.size();

                for(int i=0;i< tamCiclo;i++){
                    nodoTemp = solucion.pop();
                    nodoTemp.getStateActual().imprimirState();
                    System.out.println("\n");
                }

                System.out.println("Costo : "+ nodoTemp.getCosto());
            }
        }

        System.out.println("Busqueda Terminada");


    }

    private static boolean checarRepeticiones(BuscarNodo visitado) {

        boolean aux = false;
        BuscarNodo vis = visitado;

        while(visitado.getNodoPadre() != null && !aux){
            if( visitado.getNodoPadre().getStateActual().equals(visitado.getStateActual())){
                aux = true;
            }
            visitado = visitado.getNodoPadre();

        }
        return aux;
    }
}
