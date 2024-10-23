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

    private boolean esNumeroValido(String numero) {
        try {
            Integer.valueOf(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int ValidarNumero(String numero) {
        if (esNumeroValido(numero)) {
            return Integer.parseInt(numero);
        } else {
            return -1;
        }
    }

}
