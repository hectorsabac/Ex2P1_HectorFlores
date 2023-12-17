/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex2p1_hectorflores;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hecto
 */
public class Personaje {
    Scanner sc = new Scanner(System.in);
    Ex2P1_HectorFlores main = new Ex2P1_HectorFlores();
    
    String Nombre;
    int HP;
    int MP;
    int AttackPoints;
    int DefensePoints;

    public Personaje(String Nombre, int HP, int MP, int AttackPoints, int DefensePoints) {
        this.Nombre = Nombre;
        this.HP = HP;
        this.MP = MP;
        this.AttackPoints = AttackPoints;
        this.DefensePoints = DefensePoints;
    }
    
    public Personaje(){
        
    }

    public Personaje(String Nombre) {
        this.Nombre = Nombre;
    }
    
    public Personaje(int HP){
        this.HP = HP;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getMP() {
        return MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public int getAttackPoints() {
        return AttackPoints;
    }

    public void setAttackPoints(int AttackPoints) {
        this.AttackPoints = AttackPoints;
    }

    public int getDefensePoints() {
        return DefensePoints;
    }

    public void setDefensePoints(int DefensePoints) {
        this.DefensePoints = DefensePoints;
    }
    
    public void mostrarStatsParty(ArrayList <Personaje> party){
        for (int i = 0; i < party.size(); i++){
            System.out.println("Personaje " + i + ": " + party.get(i).getNombre());
            System.out.println("HP: " + party.get(i).getHP());
            System.out.println("MP: " + party.get(i).getMP());
            System.out.println("Attack: " + party.get(i).getAttackPoints());
            System.out.println("Defense: " + party.get(i).getDefensePoints());
            
            System.out.println("");
        }
    }
    
    public Personaje elegirPersonaje(ArrayList <Personaje> party){
        System.out.println("Ingrese el numero del personaje que desea ");
        int opcion = sc.nextInt();
        int lim_sup = party.size() - 1;
        
        while (opcion < 0 || opcion > lim_sup){
            System.out.println("Ingrese un numero valido de personaje (entre 0 y " + lim_sup + ")");
            opcion = sc.nextInt();
        }
        
        System.out.println("Ha elegido a " + party.get(opcion).getNombre());
        
        return party.get(opcion);
    }
    
    public int restanteDespuesDeAtaque(int restante, Personaje jugador){
        int temporal = restante - jugador.getAttackPoints();
        return temporal;
    }
    
    public int hpDespuesDeAtaque(int hp, Personaje jugador){
        int temporal = 0;
        
        if (jugador.getDefensePoints() >= 25){
            temporal = hp;
        } else {
            temporal = hp - 25 + jugador.getDefensePoints();
        }
        
        return temporal;
    }
    
    public int infligido(int hp, Personaje jugador){
        int temporal = 0;
        
        if (jugador.getDefensePoints() >= 25){
            temporal = 0;
        } else {
            temporal = 25 - jugador.getDefensePoints();
        }
        
        return temporal;
    }
    
    public void mostrarItems(ArrayList <Items> mochila){
        for (int i = 0; i < mochila.size(); i++){
            System.out.println("Item " + i + ": " + mochila.get(i).getNombre() + ", HPpoints: " + mochila.get(i).getHPpoints() + ", MPpoints: " + mochila.get(i).getMPpoints());
        }
    }
    
    public void mostrarReservas(ArrayList <Personaje> reservas){
        for (int i = 0; i < reservas.size() ; i++){
            System.out.println("Reserva " + i + ": " + reservas.get(i).getNombre() + "\nHPpoints: " + reservas.get(i).getHP() + "\nMPpoints: " + reservas.get(i).getMP() + "\nAttack P: " + reservas.get(i).getAttackPoints() + "\nDefense P: " + reservas.get(i).getDefensePoints() + "\n");
        }
    }
}
