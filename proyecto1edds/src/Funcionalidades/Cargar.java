/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionalidades;

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
            
        }catch (IOExcepcion e) {
            e.printStackTrace ();
        }
    }
    
    
}
