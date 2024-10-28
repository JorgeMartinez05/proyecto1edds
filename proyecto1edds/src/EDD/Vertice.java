/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import javax.swing.JOptionPane;
import proyecto1edds.Estacion;

/**
 *
 * @author jorge
 */
public class Vertice {

    Estacion estacion;  // Estación asociada al vértice
    int numVertice;    // Número de vértice
    Lista adyacentes;  // Lista de vértices adyacentes
/**
     * Constructor que inicializa un vértice con una estación.
     * @param estacion la estación asociada al vértice.
     */
    public Vertice(Estacion estacion) {
        this.estacion = estacion;
        this.numVertice = -1;
        this.adyacentes = new Lista();
    }
/**
     * Retorna la estación asociada al vértice.
     * @return la estación del vértice.
     */
    public Estacion getEstacion() {
        return estacion;
    }
 /**
     * Establece la estación asociada al vértice.
     * @param estacion la nueva estación del vértice.
     */
    public void setEstacion(Estacion estacion) {
        this.estacion = estacion;
    }
/**
     * Retorna el número de vértice.
     * @return número de vértice.
     */
    public int getNumVertice() {
        return numVertice;
    }
 /**
     * Establece el número de vértice.
     * @param numVertice el nuevo número de vértice.
     */
    public void setNumVertice(int numVertice) {
        this.numVertice = numVertice;
    }
/**
     * Retorna la lista de vértices adyacentes.
     * @return lista de vértices adyacentes.
     */
    public Lista getAdyacentes() {
        return adyacentes;
    }
/**
     * Establece la lista de vértices adyacentes.
     * @param adyacentes la nueva lista de vértices adyacentes.
     */
    public void setAdyacentes(Lista adyacentes) {
        this.adyacentes = adyacentes;
    }
 /**
     * Retorna los nombres de las estaciones adyacentes en una cadena de texto.
     * @return los nombres de las estaciones adyacentes o un mensaje si no hay adyacentes.
     */
    public String nombresEstacionesAdyacentes() {
        if (this.adyacentes.isEmpty()) {
            return "No tiene ciudades adyacentes";
        } else {
            String nombreEstaciones = "";
            int ultimoIndice = this.adyacentes.getSize() - 1;
            for (int i = 0; i < this.adyacentes.getSize(); i++) {
                Estacion estacionActual = (Estacion) adyacentes.getValor(i);
                if (i != ultimoIndice) {
                    nombreEstaciones += estacionActual.getNombre() + " => ";
                } else {
                    nombreEstaciones += estacionActual.getNombre();
                }
            }
            return nombreEstaciones;
        }
    }
     /**
     * Muestra la lista de adyacencia transformada a una cadena.
     * 
     * @return la cadena que representa la lista de adyacencia o null si está vacía.
     */
    public String mostrarListaAdyacencia(){
        if(!this.adyacentes.isEmpty()){
            return adyacentes.transformar();
        }
        return null;
    }
      /**
     * Devuelve una representación en cadena del vértice, incluyendo su estación, número y adyacentes.
     * 
     * @return una cadena que representa el vértice.
     */
    @Override
    public String toString(){
        if(this.mostrarListaAdyacencia() != null){
            return numVertice + "," + estacion.getNombre()+"->" +this.mostrarListaAdyacencia();
        }
        return numVertice + ", " + estacion.getNombre();
    }
    /**
     * Muestra los detalles del vértice en un cuadro de diálogo.
     */
     public void mostrar(){
        JOptionPane.showMessageDialog(null, this.toString());
    }
    

}
