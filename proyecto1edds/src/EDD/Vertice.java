/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import proyecto1edds.Estacion;

/**
 *
 * @author jorge
 */
public class Vertice {

    Estacion estacion;
    int numVertice;
    Lista adyacentes;

    public Vertice(Estacion estacion) {
        this.estacion = estacion;
        this.numVertice = -1;
        this.adyacentes = new Lista();
    }

    public Estacion getEstacion() {
        return estacion;
    }

    public void setEstacion(Estacion estacion) {
        this.estacion = estacion;
    }

    public int getNumVertice() {
        return numVertice;
    }

    public void setNumVertice(int numVertice) {
        this.numVertice = numVertice;
    }

    public Lista getAdyacentes() {
        return adyacentes;
    }

    public void setAdyacentes(Lista adyacentes) {
        this.adyacentes = adyacentes;
    }

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

    @Override
    public String toString() {
        return estacion.toString() + "\nNumero de Vertice: " + numVertice + "\nCiudades adyacentes: " + adyacentes;
    }

}
