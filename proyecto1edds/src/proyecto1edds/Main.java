/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1edds;

import EDD.Grafo;

/**
 *
 * @author jorge
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estacion estacion = new Estacion("Los Dos Caminos");
        Estacion estacion2 = new Estacion("Parque del Este");
        Estacion estacion3 = new Estacion("Altamira");
        Estacion estacion4 = new Estacion("Chacao");
        System.out.println(estacion);
        Grafo grafo = new Grafo();

        grafo.insertar(estacion);
        grafo.insertar(estacion2);
        grafo.insertar(estacion3);
        grafo.insertar(estacion4);

        grafo.agregarConexion("Los Dos Caminos", "Parque del Este");
        grafo.agregarConexion("Parque del Este", "Altamira");
        grafo.agregarConexion("Altamira", "Chacao");

        System.out.println(grafo.toString());
    }

}
