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

    private Lista estaciones;

    public Grafo() {
        this.estaciones = new Lista();
    }

    public Lista getEstaciones() {
        return estaciones;
    }

    public void setEstaciones(Lista estaciones) {
        this.estaciones = estaciones;
    }

    public boolean esVacio() {
        return this.estaciones.isEmpty();
    }

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

    public void agregarConexion(String nombre1, String nombre2) {
        Estacion estacionInicial = this.buscarEstacion(nombre1).getEstacion();
        Estacion estacionFinal = this.buscarEstacion(nombre2).getEstacion();

        if (estacionInicial != null && estacionFinal != null) {
            this.buscarEstacion(nombre1).getAdyacentes().insertarFinal(estacionFinal);
            this.buscarEstacion(nombre2).getAdyacentes().insertarFinal(estacionInicial);
            JOptionPane.showMessageDialog(null, "Conexion agregada con exito");
        } else {
            JOptionPane.showMessageDialog(null, "No existe alguna de las estaciones.,");
        }
    }

    public void InsertarVertice(Vertice vertice) {
        String nombre = vertice.getEstacion().getNombre();
        if (buscarEstacion(nombre) == null) {
            vertice.setNumVertice(this.estaciones.getSize());

        } else {
            JOptionPane.showMessageDialog(null, "El vertice ya se encuentra insertado");

        }
    }

    public boolean haySucursales() {
        if (!this.estaciones.isEmpty()) {
            for (int i = 0; i < estaciones.getSize(); i++) {
                Vertice verticeActual = (Vertice) estaciones.getValor(i);
                if (verticeActual.getEstacion().isSucursal()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

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

    public void mostrar() {
        JOptionPane.showMessageDialog(null, this.estaciones.toString());
    }

    public void destruir() {
        this.estaciones.destruir();
    }
}
