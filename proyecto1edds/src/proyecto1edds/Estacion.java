/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1edds;

/**
 *
 * @author Enrique León
 */
public class Estacion {
    private String nombre;
    private boolean sucursal;
    private Estacion pasoPeatonal;

    public Estacion(String nombre) {
        this.nombre = nombre;
        this.sucursal = false;
        this.pasoPeatonal = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isSucursal() {
        return sucursal;
    }

    public void setSucursal(boolean sucursal) {
        this.sucursal = sucursal;
    }

    public Estacion getPasoPeatonal() {
        return pasoPeatonal;
    }

    public void setPasoPeatonal(Estacion pasoPeatonal) {
        this.pasoPeatonal = pasoPeatonal;
    }
    
    public String tieneSucursal(){
        if(this.sucursal){
            return "Tiene sucursal";
        }else{
            return "No tiene sucursal";
        }
    }
    
    public String nombrePasoPeatonal(){
        if(this.pasoPeatonal != null){
            return this.pasoPeatonal.getNombre();
        }else{
            return "No tiene paso peatonal";
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nSucursal: " + this.tieneSucursal() + "\nPaso Peatonal: " + this.nombrePasoPeatonal();
    }
    
}
