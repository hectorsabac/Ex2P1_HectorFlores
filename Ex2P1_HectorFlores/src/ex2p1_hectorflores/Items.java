/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex2p1_hectorflores;

public class Items {
    String Nombre;
    int HPpoints;
    int MPpoints;
    
    public Items(){
        
    }

    public Items(String Nombre, int HPpoints, int MPpoints) {
        this.Nombre = Nombre;
        this.HPpoints = HPpoints;
        this.MPpoints = MPpoints;
    }
    
    public Items(String Nombre){
        this.Nombre = Nombre;
    }
    
    public Items(int HPpoints){
        this.HPpoints = HPpoints;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getHPpoints() {
        return HPpoints;
    }

    public void setHPpoints(int HPpoints) {
        this.HPpoints = HPpoints;
    }

    public int getMPpoints() {
        return MPpoints;
    }

    public void setMPpoints(int MPpoints) {
        this.MPpoints = MPpoints;
    }
}
