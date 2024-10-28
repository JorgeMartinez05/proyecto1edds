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
    private Lista vertices = new Lista();
    
    public Lista getVertices() {
        return vertices;
    }
    
    public void setVertices(Lista vertices) {
        this.vertices = vertices;
    }
    
    public void cargarArchivoJSON(String rutaArchivo) {
        try {
            Gson gson = new Gson();
            JsonObject redTransporteData = gson.fromJson(new FileReader(rutaArchivo), JsonObject.class);
            
            
            Lista nombresRedes = obtenerClavesDeJsonObject (redTransporteData);
            
            
            for (int i = 0; i< nombresRedes.getSize(); i++) {
                String nombreRed = (String) nombresRedes.getValor(i);
                JsonElement redElement = redTransporteData.get(nombreRed);
                
                
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
    
    private Lista obtenerClavesDeJsonObject (JsonObject jsonObject) {
        Lista listaClaves = new Lista();
        for (String key : jsonObject.keySet()) {
            listaClaves.insertarFinal (key);
        }
        return listaClaves;
    }
    
    
    private void procesarLineasRed (JsonObject lineasObject) {
        Lista nombresLineas = obtenerClavesDeJsonObject (lineasObject);
        
        for (int i = 0; i < nombresLineas.getSize(); i++) {
            String nombreLinea = (String) nombresLineas.getValor(i);
            JsonArray estacionesArray = lineasObject.getAsJsonArray (nombreLinea);
            
            Vertice verticeAnterior = null;
            Vertice verticeActual;
            
            
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
