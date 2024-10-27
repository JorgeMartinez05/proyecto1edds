/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coberturas;

import EDD.Cola;
import EDD.Lista;
import EDD.Vertice;
import javax.swing.JOptionPane;

/**
 *
 * @author eabdf
 */
public class BFS {
    
    public void recorridoBFS (Vertice puntoInicio, int maxDistancia) {
        
        String camino = "Partiendo desde: " + puntoInicio.getEstacion().getNombre()+ "\n";
        Cola pendientes = new Cola();
        Cola pasos = new Cola();
        Lista yaVisitadas = new Lista();
        
        pendientes.enColar (puntoInicio);
        pasos.enColar (0);
        yaVisitadas.insertarFinal(puntoInicio);
        
        
        while (!pendientes.colaVacia()) {
            Vertice estacionActual = (Vertice) pendientes.desEnColar();
            int distanciaRecorrida = (int) pasos.desEnColar(); 
            
            if (distanciaRecorrida > maxDistancia) {
                continue;
            }
        
            camino += "Estacion: " + estacionActual.getEstacion().getNombre() + ", a una distancia de: " + distanciaRecorrida + "\n";
        
            Lista conexiones = estacionActual.getAdyacentes();
            for (int i = 0; i < conexiones.getSize(); i++) {
                Vertice proxima = (Vertice) conexiones.getValor(i);
            
                if (!yaVisitadas.buscar(proxima)) {
                    pendientes.enColar(proxima);
                    pasos.enColar(distanciaRecorrida + 1);
                    yaVisitadas.insertarFinal(proxima);
                }
            }
        }
        
        JOptionPane.showMessageDialog(null, camino);
    }
    
}
