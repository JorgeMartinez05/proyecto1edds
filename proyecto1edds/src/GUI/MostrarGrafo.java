/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import EDD.Grafo;
import EDD.Lista;
import EDD.Vertice;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;
import proyecto1edds.Estacion;

/**
 *
 * @author eabdf
 */
public class MostrarGrafo extends JFrame {
      private Grafo grafo;
    private Viewer visor;
    private ViewPanel panelVista;

    public MostrarGrafo(Grafo grafo) {
        this.grafo = grafo;
        configurarInterfaz();
        inicializarVisor();
        agregarBotonRegresar();
    }

    private void configurarInterfaz() {
        setTitle("Mapa de Estaciones");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }

    private void inicializarVisor() {
        Graph grafoVisual = new SingleGraph("Estaciones");
        construirGrafo(grafoVisual);

        
        visor = grafoVisual.display(false);
        visor.enableAutoLayout();  

       
        if (panelVista == null) {
            panelVista = (ViewPanel) visor.getDefaultView();  
            add(panelVista, BorderLayout.CENTER); 
        }
    }

    private void construirGrafo(Graph grafoVisual) {
        for (int i = 0; i < grafo.getEstaciones().getSize(); i++) {
            Vertice vertice = (Vertice) grafo.getEstaciones().getValor(i);
            Estacion estacion = vertice.getEstacion();
            Node nodo = grafoVisual.addNode(estacion.getNombre());
            nodo.setAttribute("ui.label", estacion.getNombre());

            
            String colorNodo = estacion.isSucursal() ? "gray" : "blue";
            nodo.setAttribute("ui.style", "fill-color: " + colorNodo + ";");
        }

        agregarRutas(grafoVisual);

        
        grafoVisual.setAttribute("ui.stylesheet", 
            "node { text-size: 10px; size: 30px; text-alignment: under; }" +
            "edge { size: 1.5px; }"
        );
    }

    private void agregarRutas(Graph grafoVisual) {
        for (int i = 0; i < grafo.getEstaciones().getSize(); i++) {
            Vertice vertice = (Vertice) grafo.getEstaciones().getValor(i);
            Lista adyacentes = vertice.getAdyacentes();

           
            for (int j = 0; j < adyacentes.getSize(); j++) {
                Vertice verticeAdyacente = (Vertice) adyacentes.getValor(j);

               
                String idConexion = vertice.getEstacion().getNombre() + "-" + verticeAdyacente.getEstacion().getNombre();

               
                if (grafoVisual.getEdge(idConexion) == null && grafoVisual.getEdge(verticeAdyacente.getEstacion().getNombre() + "-" + vertice.getEstacion().getNombre()) == null) {
                    grafoVisual.addEdge(idConexion, vertice.getEstacion().getNombre(), verticeAdyacente.getEstacion().getNombre());
                }
            }

           
            agregarRutaPeatonal(grafoVisual, vertice);
        }
    }

    private void agregarRutaPeatonal(Graph grafoVisual, Vertice vertice) {
        Estacion peatonal = vertice.getEstacion().getPasoPeatonal();
        if (peatonal != null) {
            String idPeatonal = vertice.getEstacion().getNombre() + "-" + peatonal.getNombre() + "-peatonal";

            if (grafoVisual.getEdge(idPeatonal) == null) {
                Edge aristaPeatonal = grafoVisual.addEdge(idPeatonal, vertice.getEstacion().getNombre(), peatonal.getNombre(), true);
                aristaPeatonal.setAttribute("ui.style", "stroke-mode: dots; stroke-color: blue;");
            }
        }
    }

    private void agregarBotonRegresar() {
        JButton botonRegresar = new JButton("Volver al Menu");
        botonRegresar.addActionListener(e -> {
            cerrarVisor();
            this.dispose();
            
            MenuPrincipal menuPrincipal = new MenuPrincipal();
            menuPrincipal.setVisible(true);
        });
        add(botonRegresar, BorderLayout.SOUTH);
    }

    private void cerrarVisor() {
        if (visor != null) {
            visor.disableAutoLayout();
            visor.close();
        }
        if (panelVista != null) {
            remove(panelVista);
            panelVista = null;
        }
    }
    
}
