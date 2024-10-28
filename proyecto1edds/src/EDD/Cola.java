/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Enrique León
 */
public class Cola {
    
    private Nodo cabeza; // Primer elemento de la cola
    private Nodo cola; // Último elemento de la cola
    private int size;  // Tamaño de la cola
 /**
     * Constructor que inicializa una cola vacía.
     */
    public Cola() {
        this.cabeza = null;
        this.cola = null;
        this.size = 0;
    }
 /**
     * Retorna el primer elemento de la cola.
     * @return cabeza de la cola.
     */
    public Nodo getCabeza() {
        return cabeza;
    }
 /**
     * Define el primer elemento de la cola.
     * @param cabeza nuevo primer elemento.
     */
    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }
 /**
     * Retorna el último elemento de la cola.
     * @return cola de la cola.
     */
    public Nodo getCola() {
        return cola;
    }
 /**
     * Define el último elemento de la cola.
     * @param cola nuevo último elemento.
     */
    public void setCola(Nodo cola) {
        this.cola = cola;
    }

    /**
     * Retorna el tamaño de la cola.
     * @return tamaño de la cola.
     */
    public int getSize() {
        return size;
    }
 /**
     * Establece el tamaño de la cola.
     * @param size nuevo tamaño.
     */
    public void setSize(int size) {
        this.size = size;
    }
 /**
     * Verifica si la cola está vacía.
     * @return true si la cola está vacía.
     */
    public boolean colaVacia() {
        return this.cabeza == null;
    }
     /**
     * Agrega un elemento al final de la cola.
     * @param dato elemento a agregar.
     */
    public void enColar(Object dato) {
        Nodo pNew = new Nodo(dato);
        if (this.colaVacia()) {
            this.setCabeza(pNew);
            this.setCola(pNew);
        } else {
            this.cola.setPnext(pNew);
            this.setCola(pNew);
        }
        size++;
    }
 /**
     * Quita y retorna el primer elemento de la cola.
     * @return elemento removido.
     */
    public Object desEnColar() {
        if (this.colaVacia()) {
            Object quitar = this.cabeza.getDato();
            this.setCabeza(null);
            this.setCola(null);
            size--;
            return quitar;

        } else {
            Object quitar = this.cabeza.getDato();
            this.setCabeza(this.cabeza.getPnext());
            size--;
            return quitar;
        }

    }
 /**
     * Elimina todos los elementos de la cola.
     */
    public void destruir() {
        cabeza = null;
        cola = null;
        size = 0;
    }
 /**
     * Muestra todos los elementos de la cola.
     */
    public void listar() {
        Nodo aux = cabeza;
        String pila = "COLA:\n";
        while (aux != null) {
            pila = pila + aux.getDato() + "\n";
            aux = aux.getPnext();
        }
        System.out.println(pila);
    }
    
}
