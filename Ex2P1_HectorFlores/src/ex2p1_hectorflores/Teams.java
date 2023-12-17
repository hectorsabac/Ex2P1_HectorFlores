/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex2p1_hectorflores;
import java.util.ArrayList;

/**
 *
 * @author hecto
 */
public class Teams {
    ArrayList <Personaje> party;
    ArrayList <Items> mochila;
    ArrayList <Personaje> reservas;

    public Teams() {
    }

    public Teams(ArrayList<Personaje> party) {
        this.party = party;
    }    

    public ArrayList<Personaje> getParty() {
        return party;
    }

    public void setParty(ArrayList<Personaje> party) {
        this.party = party;
    }

    public ArrayList<Items> getMochila() {
        return mochila;
    }

    public void setMochila(ArrayList<Items> mochila) {
        this.mochila = mochila;
    }

    public ArrayList<Personaje> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Personaje> reservas) {
        this.reservas = reservas;
    }
    
    
}
