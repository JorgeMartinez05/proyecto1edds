/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionalidades;

import EDD.Grafo;
import EDD.Lista;
import EDD.Vertice;
import javax.swing.JOptionPane;
import proyecto1edds.Estacion;

/**
 *
 * @author eabdf
 */
public class Funcion {
     /**
     * Retorna una lista de nombres de estaciones que no tienen sucursal en el grafo.
     * 
     * @param grafo el grafo que contiene las estaciones.
     * @return lista de nombres de estaciones sin sucursal.
     */
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
    /**
     * Retorna una lista de nombres de estaciones que tienen sucursal en el grafo.
     * 
     * @param grafo el grafo que contiene las estaciones.
     * @return lista de nombres de estaciones con sucursal.
     */
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
     /**
     * Retorna una lista de los nombres de todas las estaciones en el grafo.
     * 
     * @param grafo el grafo que contiene las estaciones.
     * @return lista de nombres de estaciones.
     */
    public Lista mostrarEstaciones(Grafo grafo) {
        Lista nombresEstaciones = new Lista();
        for (int i = 0; i < grafo.getEstaciones().getSize(); i++) {
            Vertice verticeActual = (Vertice) grafo.getEstaciones().getValor(i);
            nombresEstaciones.insertarFinal(verticeActual.getEstacion().getNombre());

        }

        return nombresEstaciones;
    }
    /**
     * Retorna una lista de los nombres de los vértices en una lista dada.
     * 
     * @param vertices la lista de vértices.
     * @return lista de nombres de los vértices.
     */
    public Lista mostrarListaVertice(Lista vertices){
        Lista nombreVertices = new Lista();
        for (int i = 0; i < vertices.getSize(); i++) {
            Vertice verticeActual = (Vertice) vertices.getValor(i);
            nombreVertices.insertarFinal(verticeActual.getEstacion().getNombre());
        }
        
        return nombreVertices;
    }
     /**
     * Retorna una cadena de texto con los nombres de las estaciones en una línea.
     * 
     * @param linea la lista de estaciones en la línea.
     * @return cadena con los nombres de las estaciones o un mensaje si está vacía.
     */
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
     /**
     * Busca un vértice por el nombre de la estación. Si no existe, lo crea y lo añade a la lista de vértices.
     * 
     * @param nombreEstacion el nombre de la estación a buscar o crear.
     * @param vertices la lista de vértices donde buscar.
     * @return el vértice correspondiente a la estación.
     */
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
