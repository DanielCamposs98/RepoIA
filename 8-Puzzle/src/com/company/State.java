package com.company;

import java.util.ArrayList;

public interface State {

    boolean objetivoAlcanzado();

    ArrayList<State> sucesores();

    double obtenerCosto();

    void imprimirState();

    boolean comparar(State s);
}
