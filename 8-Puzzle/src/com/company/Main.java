package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Escribe el estado inicial del puzzle (Ejemplo : 0 1 2 3 4 5 6 7 8) : \n");

        int[] tableroInicial = crearPuzzle(reader.nextLine().split(" "));

        BusquedaAStar.busqueda(tableroInicial, 'o');


        }


    private static int[] crearPuzzle(String[] a) {
        int[] initState = new int[9];
        for (int i = 0; i < a.length; i++) {
            initState[i] = Integer.parseInt(a[i]);
        }
        return initState;
    }
}
