/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import javax.swing.JOptionPane;

/**
 *
 * @author jorge
 */
public class Lista {

    private Nodo pFirst;
    private int size;

    public Lista() {
        this.pFirst = null;
        this.size = 0;
    }

    //Metodos get y set para los atrubutos
    public Nodo getpFirst() {
        return pFirst;
    }

    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //Primitivas
    //Funcion para verificar si la lista es vacia
    public boolean isEmpty() {
        return this.pFirst == null;
    }

    //Destructor
    public void eliminar() {
        pFirst = null;
        size = 0;
    }

    public Nodo insertarInicio(Object dato) {

        Nodo pNew = new Nodo();
        pNew.setDato(dato);

        if (isEmpty()) {
            pFirst = pNew;
        } else {
            pNew.setPnext(pFirst);
            pFirst = pNew;
        }
        size++;
        return pNew;
    }

    //Metodo para insertar al final
    public void insertarFinal(Object dato) {
        Nodo pNew = new Nodo(dato);
        if (isEmpty()) {
            pFirst = pNew;
        } else {
            Nodo aux = pFirst;
            while (aux.getPnext() != null) {
                aux = aux.getPnext();
            }
            aux.setPnext(pNew);
        }
        size++;
    }

    public void mostrar() {
        if (!isEmpty()) {
            Nodo aux = pFirst;
            String expresion = "";
            while (aux != null) {
                expresion = expresion + aux.getDato().toString() + "\n";
                aux = aux.getPnext();
            }
            JOptionPane.showMessageDialog(null, expresion);

        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
    }

    //Funcion para eliminar al inicio
    public boolean Eliminar_Inicio() {
        if (!isEmpty()) {
            pFirst = pFirst.getPnext();
            size--;
            return true;
        } else {
            return false;
        }
    }

    public void eliminar_Final() {
        if (!isEmpty()) {
            if (getSize() == 1) {
                eliminar();
            } else {
                Nodo pointer = getpFirst();
                while (pointer.getPnext() != null && pointer.getPnext().getPnext() != null) {
                    pointer = pointer.getPnext();
                }
                pointer.setPnext(null);
            }
            size--;
        }
    }

    // Funcion para buscar un elemento en la lista
    public boolean buscar(Object referencia) {
        Nodo aux = pFirst;
        boolean encontrado = false;
        while (aux != null && encontrado != true) {
            if (referencia == aux.getDato()) {
                encontrado = true;
            } else {
                aux = aux.getPnext();
            }
        }
        return encontrado;
    }

    public void insertar_por_posicion(int posicion, Object valor) {
        if (posicion >= 0 && posicion < size) {
            Nodo nuevo = new Nodo(valor);
            if (posicion == 0) {
                nuevo.setPnext(pFirst);
                pFirst = nuevo;
            } else {
                if (posicion == size - 1) {
                    Nodo aux = pFirst;
                    while (aux.getPnext() != null) {
                        aux = aux.getPnext();
                    }
                    aux.setPnext(nuevo);
                } else {
                    Nodo aux = pFirst;
                    for (int i = 0; i < (posicion - 1); i++) {
                        aux = aux.getPnext();
                    }
                    Nodo siguiente = aux.getPnext();
                    aux.setPnext(nuevo);
                    nuevo.setPnext(siguiente);
                }
            }
            size++;
        }
    }

    //Metodo para Insertar por referencia
    public void inserta_por_referencia(Object ref, Object valor) {

        Nodo nuevo = new Nodo();
        nuevo.setDato(valor);

        if (!isEmpty()) {
            if (buscar(ref)) {
                Nodo aux = pFirst;
                // Recorre la lista hasta llegar al nodo de referencia.
                while (aux.getDato() != ref) {
                    aux = aux.getPnext();
                }

                Nodo siguiente = aux.getPnext();

                aux.setPnext(nuevo);

                nuevo.setPnext(siguiente);

                size++;
            }
        }
    }

    public void eliminar_por_referencia(Object referencia) {

        if (buscar(referencia)) {
            if (pFirst.getDato() == referencia) {
                pFirst = pFirst.getPnext();
            } else {
                Nodo aux = pFirst;
                while (aux.getPnext().getDato() != referencia) {
                    aux = aux.getPnext();
                }
                Nodo siguiente = aux.getPnext().getPnext();
                aux.setPnext(siguiente);
            }
            size--;
        }
    }

    public void eliminarPorPosicion(int posicion) {

        if (posicion >= 0 && posicion < size) {
            if (posicion == 0) {
                pFirst = pFirst.getPnext();
            } else {
                Nodo aux = pFirst;
                for (int i = 0; i < posicion - 1; i++) {
                    aux = aux.getPnext();
                }
                Nodo siguiente = aux.getPnext();
                aux.setPnext(siguiente.getPnext());
            }
            size--;
        }
    }

    public void editarPorReferencia(Object referencia, Object dato) {
        if (buscar(referencia)) {
            Nodo aux = pFirst;
            while (aux.getDato() != referencia) {
                aux = aux.getPnext();
            }
            aux.setDato(dato);
        }
    }

    //Metodo para editar el valor de un nodo en una posicion
    public void editar_por_posicion(int posicion, Object dato) {

        if (posicion >= 0 && posicion < size) {
            if (posicion == 0) {
                pFirst.setDato(dato);
            } else {
                Nodo aux = pFirst;

                for (int i = 0; i < posicion; i++) {
                    aux = aux.getPnext();
                }
                aux.setDato(dato);
            }
        }
    }

    //Metodo para obtener el valor de un nodo en una determinada posición
    public Object getValor(int posicion) {

        if (posicion >= 0 && posicion < size) {

            if (posicion == 0) {
                return pFirst.getDato();
            } else {
                Nodo aux = pFirst;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getPnext();
                }
                return aux.getDato();
            }
        }
        return null;
    }

    //Metodo para obtener un nodo en una determinada posición
    public Nodo getNodo(int posicion) {

        if (posicion >= 0 && posicion < size) {

            if (posicion == 0) {
                return pFirst;
            } else {
                Nodo aux = pFirst;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getPnext();
                }
                return aux;
            }
        }
        return null;
    }

    //Metodo para retornar la posicion de un nodo
    public int getIndex(Nodo nodito) {
        if (!isEmpty()) {
            Nodo aux = pFirst;
            int count = 0;
            while (aux != null) {

                if (nodito == aux) {
                    return count;     //posicion en memoria del nodo
                }
                count++;
                aux = aux.getPnext();
            }
            return -1;
        }
        return -1;
    }

    //Consulta la posición de un elemento en la lista
    public int getPosicion(Object referencia) {

        if (buscar(referencia)) {

            Nodo aux = pFirst;
            int cont = 0;
            while (referencia != aux.getDato()) {
                cont++;
                aux = aux.getPnext();
            }
            return cont;
        } else {
            return -1;
        }
    }

    //Metodo para transformar una lista en cadena de caracteres
    public String transformar() {
        if (!isEmpty()) {
            String listaStr = "";
            if (this.getSize() == 1) {
                Vertice vertice = (Vertice) this.pFirst.getDato();
                listaStr += vertice.getEstacion().getNombre();
            } else {
                Nodo aux = this.pFirst;
                while (aux != null) {
                    Vertice vertice = (Vertice) aux.getDato();
                    if (aux.getPnext() == null) {
                        listaStr += vertice.getEstacion().getNombre();
                        break;
                    }
                    listaStr += vertice.getEstacion().getNombre() + "->";
                    aux = aux.getPnext();
                }
            }
            return listaStr;
        } else {
            return "La lista esta vacia";
        }
    }

    public String transformar2() {
        if (this.isEmpty()) {
            return "La lista esta vacia";
        }
        String listaStr = "";
        Nodo aux = this.pFirst;
        while (aux != null) {
            Vertice dato = (Vertice) aux.getDato();
            listaStr += dato.getEstacion().getNombre();
            if (aux.getPnext() != null) {
                listaStr += "\n";
            }
            aux = aux.getPnext();

        }
        return listaStr;
    }

    @Override
    public String toString() {
        if (!this.isEmpty()) {
            String listaStr = "";
            if (this.getSize() == 1) {
                listaStr += this.pFirst.getDato().toString();
            } else {
                Nodo aux = this.pFirst;
                while (aux != null) {
                    if (aux.getPnext() == null) {
                        listaStr += aux.getDato().toString();
                        break;
                    }
                    listaStr += aux.getDato().toString() + "\n";
                    aux = aux.getPnext();
                }
            }
            return listaStr;
        } else {
            return "La lista esta vacia";
        }

    }

    public void destruir() {
        this.pFirst = null;
        this.size = 0;
    }

    public Vertice buscarVertice(String nombre) {
        if (!this.isEmpty()) {
            for (int i = 0; i < this.size; i++) {
                Vertice verticeACtual = (Vertice) this.getValor(i);
                if (verticeACtual.getEstacion().getNombre().equalsIgnoreCase(nombre)) {
                    return verticeACtual;
                }
            }

            return null;
        }

        return null;
    }

}
