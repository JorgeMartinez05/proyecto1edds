/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coberturas;

import EDD.Grafo;
import EDD.Lista;
import EDD.Vertice;
import javax.swing.JOptionPane;

/**
 *
 * @author eabdf
 */
public class DFS {
    
    private Grafo grafo;
    private int t;
    /**
     * Constructor que inicializa el grafo y la distancia máxima para el recorrido DFS.
     * 
     * @param grafo el grafo que se va a recorrer.
     * @param t la distancia máxima permitida para el recorrido DFS.
     */
    public DFS (Grafo grafo,int t) {
        this.grafo = grafo;
        this.t = t;
    }
    /**
     * Realiza un recorrido DFS (búsqueda en profundidad) comenzando desde un vértice específico.
     * Muestra el recorrido en un cuadro de diálogo.
     * 
     * @param verticeInicial el vértice desde donde empieza el recorrido.
     */
    public void busquedaDFS (Vertice verticeInicial) {
        if (verticeInicial == null) {
            JOptionPane.showMessageDialog(null, "El vértice inicial no puede ser nulo.");
            return;
        }
        
        Lista visitados = new Lista();
        StringBuilder resultado = new StringBuilder();
        resultado.append ("Partiendo desde: ").append(verticeInicial.getEstacion().getNombre()).append("\n");
        
        dfsRecursivo (verticeInicial, visitados, 0, resultado);
        
        resultado.append("Cobertura DFS completada.\n");
        JOptionPane.showMessageDialog(null, resultado.toString());
    }
    /**
     * Método recursivo que realiza el recorrido DFS por los vértices adyacentes y los pasos peatonales,
     * manteniendo un registro de las estaciones visitadas y las distancias.
     * 
     * @param vertice el vértice actual que se está recorriendo.
     * @param visitados lista de los vértices ya visitados.
     * @param distanciaActual la distancia recorrida desde el vértice inicial.
     * @param resultado cadena acumulada con los resultados del recorrido.
     */
    private void dfsRecursivo(Vertice vertice, Lista visitados, int distanciaActual, StringBuilder resultado) {
        visitados.insertarFinal(vertice);
        
        resultado.append("Vértice: ").append(vertice.getEstacion().getNombre())
                .append(", Distancia: ").append(distanciaActual).append("\n");
        
        if (distanciaActual >= t) {
            return;
        }
        
        if (vertice.getEstacion().getPasoPeatonal() != null) {
            Vertice verticePeatonal = grafo.buscarEstacion(vertice.getEstacion().getPasoPeatonal().getNombre());
            if (!visitados.buscar(verticePeatonal)) {
                dfsRecursivo(verticePeatonal, visitados, distanciaActual, resultado);
            }
        }
        
        Lista adyacentes = vertice.getAdyacentes();
        for (int i = 0; i < adyacentes.getSize(); i++) {
            Vertice adyacente = (Vertice) adyacentes.getValor(i);
            if (!visitados.buscar(adyacente)) {
                dfsRecursivo (adyacente, visitados, distanciaActual + 1,resultado);
            }
        }
    }
}
