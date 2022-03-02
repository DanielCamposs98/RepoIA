package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class PuzzleState implements State{

    private final int tamanio = 9;
    private int contadorFuera = 0, distanciaManh = 0;
    private final int [] objetivo = new int [] {1,2,3,4,5,6,7,8,0};
    private int [] tableroActual;



    public PuzzleState(int [] tab){
        tableroActual= tab;
        setContadorFuera();
        setDistanciaManh();
    }

    private void setDistanciaManh() {
        int aux = -1;

        for(int y=0; y<3; y++){
            for(int x=0; x<3; x++){
                aux++;

                int valor = tableroActual[aux] -1;

                if(valor!= -1){
                    int valorH = valor % 3;
                    int valorV = valor / 3;

                    distanciaManh += Math.abs(valorV -y ) + Math.abs(valorH - x);
                }
            }
        }
    }

    private int obtenerEspacioVacio(){
        int aux = -1;

        for(int i=0; i< tamanio; i++){
            if(tableroActual[i] == 0){
                aux = i;
            }
        }
        return aux;
    }

    private void setContadorFuera() {

        for(int i=0; i< tableroActual.length; i++){
            if(tableroActual[i] != objetivo[i]){
                contadorFuera++;
            }
        }
    }

    public int getDistanciaManh(){
        return distanciaManh;
    }

    private int[] obtenTablero(int [] state){
        int [] aux = new int[tamanio];
        for(int i=0; i< tamanio; i++){
            aux[i] = state[i];
        }
        return aux;
    }


    @Override
    public boolean objetivoAlcanzado() {
        return Arrays.equals(tableroActual,objetivo);
    }

    @Override
    public ArrayList<State> sucesores() {
        ArrayList<State> arrSuc =  new ArrayList<>();
        int hueco = obtenerEspacioVacio();

        if(hueco != 0 && hueco != 3 && hueco != 6){
            intercambiar(hueco - 1, hueco, arrSuc);
        }

        if(hueco != 6 && hueco != 7 && hueco != 8){
            intercambiar(hueco + 3, hueco, arrSuc);
        }

        if(hueco != 0 && hueco != 1 && hueco != 2){
            intercambiar(hueco - 3, hueco, arrSuc);
        }


        if(hueco != 2 && hueco != 5 && hueco != 8){
            intercambiar(hueco + 1, hueco, arrSuc);
        }

        return  arrSuc;
    }

    @Override
    public double obtenerCosto() {
        int costo = 0;
        for (int i = 0; i < tableroActual.length; i++) {
            int goalNumber = objetivo[i] == 0 ? 9 : objetivo[i];
            costo += Math.abs(tableroActual[i] - goalNumber);
        }
        return costo;
    }

    private void intercambiar(int i, int hueco, ArrayList<State> arrSuc) {

        int [] tabCop = obtenTablero(tableroActual);
        int temp = tabCop[i];
        tabCop[i] = tableroActual[hueco];
        tabCop[hueco] = temp;
        arrSuc.add(new PuzzleState(tabCop));
    }


    @Override
    public void imprimirState() {
        System.out.println(tableroActual[6] + '|' + tableroActual[7] + '|' + tableroActual[8] );
        System.out.println("------------");
        System.out.println(tableroActual[3] + '|' + tableroActual[4] + '|' + tableroActual[5] );
        System.out.println("------------");
        System.out.println(tableroActual[0] + '|' + tableroActual[1] + '|' + tableroActual[2] );
    }

    @Override
    public boolean comparar(State s) {
      return Arrays.equals(tableroActual,((PuzzleState)s).getTableroActual());
    }

    private int[] getTableroActual() {
        return tableroActual;
    }

public int getContadorFuera(){
        return contadorFuera;
}
}
