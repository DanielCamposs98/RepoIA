package com.company;

public class BuscarNodo {

    private State stateActual;
    private BuscarNodo nodoPadre;
    private double costo, costoHeu, costoFn;

    public BuscarNodo(State stateActual) {
        this.stateActual = stateActual;
        nodoPadre = null;
        costo=0;
        costoHeu = 0;
        costoFn = 0;
    }

    public BuscarNodo(BuscarNodo busq,State stateActual, double costo, double costoHeu) {
        this.stateActual = stateActual;
        this.nodoPadre = nodoPadre;
        this.costo = costo;
        this.costoHeu = costoHeu;
        costoFn = costo + costoHeu;
    }


    public State getStateActual() {
        return stateActual;
    }

    public BuscarNodo getNodoPadre() {
        return nodoPadre;
    }

    public double getCosto() {
        return costo;
    }

    public double getCostoHeu() {
        return costoHeu;
    }

    public double getCostoFn(){
        return costoFn;
    }

    public void setCostoFn(double fn){
        this.costoFn= fn;
    }
}
