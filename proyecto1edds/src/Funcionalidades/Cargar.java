/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionalidades;

import EDD.Lista;
import EDD.Vertice;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.FileReader;
import java.io.IOException;
import proyecto1edds.Estacion;

/**
 *
 * @author eabdf
 */
public class Cargar {
    private Lista vertices = new Lista(); // Lista de vértices (estaciones)
     /**
     * Retorna la lista de vértices (estaciones) cargados.
     * @return lista de vértices.
     */
    public Lista getVertices() {
        return vertices;
    }
    /**
     * Establece la lista de vértices (estaciones).
     * @param vertices nueva lista de vértices.
     */
    public void setVertices(Lista vertices) {
        this.vertices = vertices;
    }
     /**
     * Carga y procesa un archivo JSON con los datos de la red de transporte.
     * @param rutaArchivo la ruta del archivo JSON a cargar.
     */
    public void cargarArchivoJSON(String rutaArchivo) {
        try {
            Gson gson = new Gson();
            JsonObject redTransporteData = gson.fromJson(new FileReader(rutaArchivo), JsonObject.class);
            
             // Obtener las redes de transporte
            Lista nombresRedes = obtenerClavesDeJsonObject (redTransporteData);
            
            // Procesar cada red de transporte
            for (int i = 0; i< nombresRedes.getSize(); i++) {
                String nombreRed = (String) nombresRedes.getValor(i);
                JsonElement redElement = redTransporteData.get(nombreRed);
                
                // Procesar red de transporte si es un objeto o un array
                if (redElement.isJsonObject()) {
                    JsonObject lineasObject = redElement.getAsJsonObject();
                    procesarLineasRed (lineasObject);
                }
                else if (redElement.isJsonArray()) {
                    JsonArray lineasArray = redElement.getAsJsonArray();
                    for(JsonElement elementoLinea : lineasArray) {
                        if (elementoLinea.isJsonObject()) {
                            JsonObject lineaObject = elementoLinea.getAsJsonObject();
                            procesarLineasRed(lineaObject);
                        }
                    }
                }
            }
            
        }catch (IOException e) {
            e.printStackTrace ();
        }
    }
    /**
     * Obtiene las claves de un objeto JSON y las guarda en una lista.
     * @param jsonObject el objeto JSON del cual obtener las claves.
     * @return lista de claves obtenidas.
     */
    private Lista obtenerClavesDeJsonObject (JsonObject jsonObject) {
        Lista listaClaves = new Lista();
        for (String key : jsonObject.keySet()) {
            listaClaves.insertarFinal (key);
        }
        return listaClaves;
    }
    
     /**
     * Procesa las líneas de la red de transporte a partir de un objeto JSON.
     * @param lineasObject el objeto JSON que contiene las líneas.
     */
    private void procesarLineasRed (JsonObject lineasObject) {
        Lista nombresLineas = obtenerClavesDeJsonObject (lineasObject);
        
        for (int i = 0; i < nombresLineas.getSize(); i++) {
            String nombreLinea = (String) nombresLineas.getValor(i);
            JsonArray estacionesArray = lineasObject.getAsJsonArray (nombreLinea);
            
            Vertice verticeAnterior = null;
            Vertice verticeActual;
            
            // Procesar cada estación de la línea
            for (JsonElement estacionElement : estacionesArray) {
                if (estacionElement.isJsonPrimitive()) {
                    
                    String nombreEstacion = estacionElement.getAsString();
                    verticeActual = obtenerOcrearVertice (nombreEstacion);
                    
                    if (verticeAnterior != null) {
                        verticeAnterior.getAdyacentes ().insertarFinal(verticeActual);
                        verticeActual.getAdyacentes().insertarFinal (verticeAnterior);
                    }
                    
                    verticeAnterior = verticeActual;
                    
                } else if (estacionElement.isJsonObject()) {
                    JsonObject conexionPeatonal = estacionElement.getAsJsonObject();
                    Lista clavesPeatonales = obtenerClavesDeJsonObject(conexionPeatonal);
                    
                    for (int j = 0; j < clavesPeatonales.getSize(); j++) {
                        String estacion1 = (String) clavesPeatonales.getValor(j);
                        String estacion2 = conexionPeatonal.get(estacion1).getAsString();
                        verticeAnterior = this.crearPasoPeatonal (estacion1, estacion2, verticeAnterior);
                    }
                }
            }
        }
    }
     /**
     * Crea una conexión peatonal entre dos estaciones.
     * @param estacion1 nombre de la primera estación.
     * @param estacion2 nombre de la segunda estación.
     * @param estacionAnterior vértice anterior para conectar.
     * @return el último vértice creado o encontrado.
     */
    private Vertice crearPasoPeatonal (String estacion1, String estacion2, Vertice estacionAnterior) {
        Vertice v1 = obtenerOcrearVertice (estacion1);
        Vertice v2 = obtenerOcrearVertice (estacion2);
        
        v1.getEstacion().setPasoPeatonal(v2.getEstacion());
        v2.getEstacion().setPasoPeatonal(v1.getEstacion());
        
        if (estacionAnterior != null) {
            estacionAnterior.getAdyacentes().insertarFinal(v1);
            v1.getAdyacentes().insertarFinal(estacionAnterior);
        }
        
        estacionAnterior = v1;
        return estacionAnterior;
    }
     /**
     * Busca un vértice por el nombre de la estación. Si no existe, lo crea.
     * @param nombreEstacion el nombre de la estación a buscar o crear.
     * @return el vértice correspondiente a la estación.
     */
    private Vertice obtenerOcrearVertice (String nombreEstacion) {
        
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
