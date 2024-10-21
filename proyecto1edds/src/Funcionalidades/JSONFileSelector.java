/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionalidades;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author jorge
 */
public class JSONFileSelector {
    public void buscarArchivoJson(JTextPane ruta, JTextArea contenido, JFrame cargar) {
        JFileChooser fc = new JFileChooser();

        // Creo el filtro para archivos .json
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos JSON (*.json)", "json");

        // Le indico el filtro
        fc.setFileFilter(filtro);

        // Deshabilito la opción de aceptar todos los tipos de archivos
        fc.setAcceptAllFileFilterUsed(false);

        // Abrimos la ventana, guardamos la opción seleccionada por el usuario
        int seleccion = fc.showOpenDialog(cargar);

        // Si el usuario presiona aceptar
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = fc.getSelectedFile();
            ruta.setText(fichero.getAbsolutePath());

            try (FileReader fr = new FileReader(fichero)) {
                StringBuilder cadena = new StringBuilder();
                int valor = fr.read();

                while (valor != -1) {
                    cadena.append((char) valor);
                    valor = fr.read();
                }

                contenido.setText(cadena.toString());

            } catch (IOException e1) {
                e1.printStackTrace();
            }

        } else {
            JOptionPane.showMessageDialog(cargar, "No se ha seleccionado ningún archivo.");
        }
    }
}
