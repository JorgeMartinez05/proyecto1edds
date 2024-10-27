/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionalidades;

import EDD.Grafo;
import EDD.Lista;
import EDD.Vertice;
import proyecto1edds.Estacion;

/**
 *
 * @author eabdf
 */
public class Funcion {
    
    public Lista estacionesSinSucursal(Grafo grafo) {
        Lista nombresEstaciones = new Lista();
        for (int i = 0; i < grafo.getEstaciones().getSize(); i++) {
            Vertice verticeActual = (Vertice) grafo.getEstaciones().getValor(i);
            if (!verticeActual.getEstacion().isSucursal()) {
                nombresEstaciones.insertarFinal(verticeActual.getEstacion().getNombre());      
            }
           
        }
        
        return nombresEstaciones;
    }
    
    public Lista estacionesConSucursal (Grafo grafo) {
        Lista nombresEstaciones = new Lista();
        for (int i = 0; i < grafo.getEstaciones().getSize(); i++) {
            Vertice verticeActual = (Vertice) grafo.getEstaciones().getValor(i);
            if (verticeActual.getEstacion().isSucursal()) {
                nombresEstaciones.insertarFinal(verticeActual.getEstacion().getNombre());
            }
        }
        
        return nombresEstaciones;
    }
    public Lista mostrarEstaciones(Grafo grafo) {
        Lista nombresEstaciones = new Lista();
        for (int i = 0; i < grafo.getEstaciones().getSize(); i++) {
            Vertice verticeActual = (Vertice) grafo.getEstaciones().getValor(i);
            nombresEstaciones.insertarFinal(verticeActual.getEstacion().getNombre());

        }

        return nombresEstaciones;
    }
    
    public Lista mostrarListaVertice(Lista vertices){
        Lista nombreVertices = new Lista();
        for (int i = 0; i < vertices.getSize(); i++) {
            Vertice verticeActual = (Vertice) vertices.getValor(i);
            nombreVertices.insertarFinal(verticeActual.getEstacion().getNombre());
        }
        
        return nombreVertices;
    }
    
    public String mostrarLinea (Lista linea) {
        if (linea.isEmpty()) {
            return "La linea no tiene estaciones";
        }
        else {
            String lineaStr = "";
            for (int i = 0; i < linea.getSize(); i++) {
                String nombreActual = (String) linea.getValor(i);
                lineaStr += nombreActual + "\n";
            }
            return lineaStr;
        }
    }
    
    public Vertice obtenerOcrearVertice (String nombreEstacion, Lista vertices) {
        
        for (int i = 0; i < vertices.getSize(); i++) {
            Vertice verticeActual = (Vertice) vertices.getValor(i);
            if (verticeActual.getEstacion().getNombre().equalsIgnoreCase(nombreEstacion)) {
                return verticeActual;
            }
        }
        
        Estacion nuevaEstacion = new Estacion(nombreEstacion);
        Vertice verticeNuevo = new Vertice(nuevaEstacion);
        vertices.insertarFinal(verticeNuevo);
        return verticeNuevo;
    }
    
    

    
}
