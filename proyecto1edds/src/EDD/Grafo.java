/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import javax.swing.JOptionPane;
import proyecto1edds.Estacion;

/**
 *
 * @author eabdf
 */
public class Grafo {

    private Lista estaciones; // Lista de estaciones (vértices)
 /**
     * Constructor que inicializa un grafo vacío.
     */
    public Grafo() {
        this.estaciones = new Lista();
    }
/**
     * Retorna la lista de estaciones.
     * @return lista de estaciones.
     */
    public Lista getEstaciones() {
        return estaciones;
    }
/**
     * Establece la lista de estaciones.
     * @param estaciones nueva lista de estaciones.
     */
    public void setEstaciones(Lista estaciones) {
        this.estaciones = estaciones;
    }
 /**
     * Verifica si el grafo está vacío.
     * @return true si está vacío, false de lo contrario.
     */
    public boolean esVacio() {
        return this.estaciones.isEmpty();
    }
/**
     * Inserta una estación al grafo.
     * @param estacion estación a agregar.
     */
    public void insertar(Estacion estacion) {
        String nombre = estacion.getNombre();
        if (buscarEstacion(nombre) == null) {
            Vertice vertice = new Vertice(estacion);
            vertice.setNumVertice(this.estaciones.getSize());
            this.estaciones.insertarFinal(vertice);
            JOptionPane.showMessageDialog(null, "Vertice agregado con exito");
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe");
        }
    }
/**
     * Busca una estación por su nombre.
     * @param nombreEstacion nombre de la estación a buscar.
     * @return el vértice si lo encuentra, null si no.
     */
    public Vertice buscarEstacion(String nombreEstacion) {
        if (!this.estaciones.isEmpty()) {
            Nodo aux = this.estaciones.getpFirst();
            while (aux != null) {
                Vertice verticeActual = (Vertice) aux.getDato();
                if (verticeActual.getEstacion().getNombre().equalsIgnoreCase(nombreEstacion)) {
                    return verticeActual;
                }

                aux = aux.getPnext();
            }

            return null;
        } else {
            return null;
        }
    }
 /**
     * Agrega una conexión entre dos estaciones.
     * @param nombre1 nombre de la primera estación.
     * @param nombre2 nombre de la segunda estación.
     */
     public void agregarConexion(String nombre1, String nombre2) {
        Vertice verticeInicial = this.buscarEstacion(nombre1);
        Vertice verticeFinal = this.buscarEstacion(nombre2);

        if (verticeInicial != null && verticeFinal != null) {
            this.buscarEstacion(nombre1).getAdyacentes().insertarFinal(verticeFinal);
            this.buscarEstacion(nombre2).getAdyacentes().insertarFinal(verticeInicial);
            JOptionPane.showMessageDialog(null, "Conexion agregada con exito");
        } else {
            JOptionPane.showMessageDialog(null, "No existe alguna de las estaciones.,");
        }
    }
     /**
     * Verifica si existen sucursales en las estaciones.
     * @return true si hay sucursales, false si no.
     */
    public boolean haySucursales(){
        if (!this.estaciones.isEmpty()) {
            for (int i = 0; i < estaciones.getSize(); i++) {
                Vertice verticeActual = (Vertice) estaciones.getValor(i);
                if(verticeActual.getEstacion().isSucursal()) {
                    return true;
                }
            }
            return false; 
        }
        
        return false;
    }
/**
     * Inserta un vértice al grafo.
     * @param vertice vértice a agregar.
     */
    public void InsertarVertice(Vertice vertice) {
        String nombre = vertice.getEstacion().getNombre();
        if (buscarEstacion(nombre) == null) {
            vertice.setNumVertice(this.estaciones.getSize());
            this.estaciones.insertarFinal(vertice);

        } else {
            JOptionPane.showMessageDialog(null, "El vertice ya se encuentra insertado");

        }
    }

 /**
     * Retorna el grafo como una cadena de texto.
     * @return representación en cadena del grafo.
     */
    @Override
    public String toString() {
        if (this.esVacio()) {
            return "Grafo Vacio";
        } else {
            Nodo aux = this.estaciones.getpFirst();
            String grafoStr = "";
            while (aux.getPnext() != null) {
                Vertice verticeActual = (Vertice) aux.getDato();
                String nombreEstacionActual = verticeActual.getEstacion().getNombre();
                grafoStr += nombreEstacionActual + " => " + verticeActual.nombresEstacionesAdyacentes() + "\n";
                aux = aux.getPnext();
            }

            Vertice verticeActual = (Vertice) aux.getDato();
            String nombreEstacionActual = verticeActual.getEstacion().getNombre();
            grafoStr += nombreEstacionActual + " => " + verticeActual.nombresEstacionesAdyacentes();

            return grafoStr;
        }
    }
/**
     * Muestra el contenido del grafo.
     */
    public void mostrar() {
        JOptionPane.showMessageDialog(null, this.estaciones.toString());
    }
/**
     * Elimina todas las estaciones del grafo.
     */
    public void destruir() {
        this.estaciones.destruir();
    }
}
