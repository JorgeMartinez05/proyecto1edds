/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionalidades;

/**
 *
 * @author eabdf
 */
public class Validacion {
 /**
     * Verifica si una cadena es un número entero válido.
     * 
     * @param numero la cadena que se va a verificar.
     * @return true si la cadena es un número válido, false en caso contrario.
     */
    private boolean esNumeroValido(String numero) {
        try {
            Integer.valueOf(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
/**
     * Valida si la cadena es un número válido y lo convierte en entero.
     * 
     * @param numero la cadena que se va a validar y convertir.
     * @return el número convertido si es válido, o -1 si no lo es.
     */
    public int ValidarNumero(String numero) {
        if (esNumeroValido(numero)) {
            return Integer.parseInt(numero);
        } else {
            return -1;
        }
    }
/**
     * Valida el tipo de búsqueda ingresado. Retorna 0 si es "BFS", 1 si es "DFS" y -1 si no es válido.
     * 
     * @param nombreTipo el nombre del tipo de búsqueda a validar.
     * @return 0 si es BFS, 1 si es DFS, o -1 si no es válido.
     */
    public int validarTipoBusqueda(String nombreTipo) {
        if (nombreTipo.equalsIgnoreCase("BFS") || nombreTipo.equalsIgnoreCase("DFS")) {
            if (nombreTipo.equalsIgnoreCase("BFS")) {
                return 0;
            }

            return 1;
        }

        return -1;

    }
}
