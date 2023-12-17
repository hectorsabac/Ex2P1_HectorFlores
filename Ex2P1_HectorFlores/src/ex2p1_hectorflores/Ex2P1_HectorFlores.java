/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex2p1_hectorflores;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author hecto
 */
public class Ex2P1_HectorFlores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        Personaje personaje = new Personaje();
        Items items = new Items();
        Teams teams = new Teams();
        
        Items pocion = new Items ("Pocion", 50, 0);
        Items ether = new Items ("Ether", 0, 50);
        Items elixir = new Items ("Elixir", 100, 100);
        
        System.out.println("1. Kingdom Hearts\n2. Salir\n\nIngrese su opcion:");
        
        int opcion = sc.nextInt();
        char res = 's';
        
        while (true){
            if (opcion == 1 || opcion == 2){
                break;
            } else {
                System.out.println("Ingresar 1 o 2");
                opcion = sc.nextInt();
            }
        } 
        
        ArrayList <Personaje> personajes_main = new ArrayList<>();
        ArrayList <Items> mochila_main = new ArrayList<>();
        ArrayList <Personaje> reservas_main = new ArrayList<>();
        
        while (opcion == 1){
            
            Personaje sora = new Personaje ("Sora", 300, 300, 75, 15);
            Personaje donald = new Personaje ("Donald", 150, 450, 45, 10);
            Personaje goofy = new Personaje ("Goofy", 450, 100, 150, 50);
            Personaje mickey = new Personaje ("Mickey", 100, 500, 150, 35);
            Personaje roxas = new Personaje ("Roxas", 300, 300, 15, 75);
            Personaje kairi = new Personaje ("Kairi", 200, 200, 50, 15);

            personajes_main.clear();
            
            personajes_main.add(sora); personajes_main.add(donald); personajes_main.add(goofy);
            teams.setParty(personajes_main);
            
            mochila_main.clear();
            
            mochila_main.add(pocion); mochila_main.add(ether); mochila_main.add(elixir);
            teams.setMochila(mochila_main);
            
            reservas_main.clear();
            
            reservas_main.add(mickey); reservas_main.add(roxas); reservas_main.add(kairi);
            teams.setReservas(reservas_main);
            
            for (int i = 1; i <= 20; i++){
                res = ' ';
                
                if (i == 1){
                    System.out.println("Deseas entrar al primer cuarto? [s/n]");
                    res = sc.next().charAt(0);
                } else {
                    System.out.println("Deseas entrar al siguiente cuarto? [s/n]");
                    res = sc.next().charAt(0);
                }
                
                while (true){
                    if (res == 's' || res == 'S' || res == 'n' || res == 'N'){
                        break;
                    } else {
                        System.out.println("Ingrese solo s o n");
                        res = sc.next().charAt(0);
                    }
                }
                if (res == 's' || res == 'S'){
                    System.out.println("-----------Cuarto #" + i + "-----------");
                    int evento = random.nextInt((5-1)+1)+1;

                    switch (evento){
                        case 1:
                            int enemigos = random.nextInt((3-1)+1)+1;
                            int vida_enemigos = enemigos * 75;
                            System.out.println("Te has encontrado con " + enemigos + " heartless!");
                            System.out.println("HP de los heartless: " + vida_enemigos);

                            while (vida_enemigos > 0 && teams.party.size() > 0){
                                
                                System.out.println("Menu:\n1. Attack\n2. Magic\n3. Items\n4. Party\nSeleccionar accion:");
                                int opcion2 = sc.nextInt();

                                while (true){
                                    if (opcion2 > 0 && opcion2 < 5){
                                        break;
                                    } else {
                                        System.out.println("Ingrese una opcion de 1 - 4");
                                        opcion2 = sc.nextInt();
                                    }
                                }

                                switch (opcion2){
                                    case 1:
                                        int vida_atacante = 1;
                                        Personaje player = sora;

                                        System.out.println("Party:");
                                        personaje.mostrarStatsParty(teams.getParty());
                                        player = personaje.elegirPersonaje(teams.getParty());

                                        vida_enemigos = personaje.restanteDespuesDeAtaque(vida_enemigos, player);

                                        if (vida_enemigos < 0){
                                            vida_enemigos = 0;
                                        }

                                        int infligido = personaje.infligido(personaje.getHP(), player);

                                        vida_atacante = personaje.hpDespuesDeAtaque(player.getHP(), player);

                                        if (vida_atacante < 0){
                                            vida_atacante = 0;
                                        }

                                        player.setHP(player.getHP() - infligido);

                                        System.out.println(player.getNombre() + " ha infligido " + player.getAttackPoints() + " puntos de daño, dejando a los heartless con " + vida_enemigos + " HP");
                                        System.out.println(player.getNombre() + " ha recibido " + infligido + " puntos de daño, dejandole con " + player.getHP() + " HP");

                                        if (vida_atacante == 0){
                                            System.out.println(player.getNombre() + " ha muerto!"); 
                                            personajes_main.remove(player);
                                            teams.setParty(personajes_main);
                                        }

                                        if (vida_enemigos == 0){
                                            System.out.println("Ha derrotado a los heartless! Proceda al siguiente cuarto!");
                                        }

                                        if (teams.getParty().isEmpty()){
                                            System.out.println("Game over. Su party ha muerto :(");
                                            i = 21;
                                        }

                                        break;
                                    case 2:
                                        System.out.println("Party:");
                                        personaje.mostrarStatsParty(teams.getParty());
                                        player = personaje.elegirPersonaje(teams.getParty());

                                        if (player.getMP() < 25){
                                            System.out.println("No tiene suficientes MP");
                                        } else {
                                            System.out.println("1. Blizzard - 50MP - 50DMG\n2. Firaga 25MP - 25DMG\n3. Gravity 75MP - 100DMG");
                                            int magia = sc.nextInt();

                                            while (magia < 1 || magia > 3){
                                                System.out.println("Elija un numero entre 1 y 3");
                                                magia = sc.nextInt();
                                            }

                                            switch (magia){
                                                case 1:
                                                    if (player.getMP() < 50){
                                                        System.out.println("No tiene suficientes MP");
                                                        break;
                                                    } else {
                                                        vida_enemigos -= 50;
                                                        player.setMP(player.getMP() - 50);

                                                        System.out.println(player.getNombre() + " ha usado Blizzard! Ha infligido 50 puntos de daño y tiene " + player.getMP() + " MP ahora");
                                                        System.out.println("Los heartless ahora tienen " + vida_enemigos + " HP");
                                                        infligido = personaje.infligido(personaje.getHP(), player);
                                                        player.setHP(player.getHP() - infligido);
                                                        System.out.println(player.getNombre() + " ha recibido " + infligido + " puntos de daño, dejandole con " + player.getHP() + " HP");
                                                        break;
                                                    }
                                                case 2:
                                                    if (player.getMP() < 25){
                                                        System.out.println("No tiene suficientes MP");
                                                        break;
                                                    } else {
                                                        vida_enemigos -= 25;
                                                        player.setMP(player.getMP() - 25);

                                                        System.out.println(player.getNombre() + " ha usado Firaga! Ha infligido 25 puntos de daño y tiene " + player.getMP() + " MP ahora");
                                                        System.out.println("Los heartless ahora tienen " + vida_enemigos + " HP");
                                                        infligido = personaje.infligido(personaje.getHP(), player);
                                                        player.setHP(player.getHP() - infligido);
                                                        System.out.println(player.getNombre() + " ha recibido " + infligido + " puntos de daño, dejandole con " + player.getHP() + " HP");
                                                        break;
                                                    }
                                                case 3:
                                                    if (player.getMP() < 75){
                                                        System.out.println("No tiene suficientes MP");
                                                        break;
                                                    } else {
                                                        vida_enemigos -= 100;
                                                        
                                                        if (vida_enemigos < 0){
                                                            vida_enemigos = 0;
                                                        }
                                                        
                                                        player.setMP(player.getMP() - 75);
                                                        personaje.hpDespuesDeAtaque(player.getHP(), player);

                                                        System.out.println(player.getNombre() + " ha usado Gravity! Ha infligido 100 puntos de daño y tiene " + player.getMP() + " MP ahora");
                                                        System.out.println("Los heartless ahora tienen " + vida_enemigos + " HP");
                                                        infligido = personaje.infligido(personaje.getHP(), player);
                                                        player.setHP(player.getHP() - infligido);
                                                        System.out.println(player.getNombre() + " ha recibido " + infligido + " puntos de daño, dejandole con " + player.getHP() + " HP");
                                                        break;
                                                    }
                                            }
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Party:");
                                        personaje.mostrarStatsParty(teams.getParty());
                                        player = personaje.elegirPersonaje(teams.getParty());
                                        
                                        System.out.println("Items en mochila:");
                                        personaje.mostrarItems(mochila_main);
                                        
                                        System.out.println("Que item deseas usar?");
                                        int item = sc.nextInt();
                                        int lim_item = teams.mochila.size() - 1;
                                        
                                        while (item < 0 || item > lim_item){
                                            System.out.println("Ingrese un numero de item entre 0 y " + lim_item);
                                            item = sc.nextInt();
                                        }
                                        
                                        if (teams.mochila.get(item) == pocion){
                                            player.setHP(player.getHP() + 50);
                                            System.out.println(player.getNombre() + " ha regenerado 50HP");
                                        } else if (teams.mochila.get(item) == ether){
                                            player.setMP(player.getMP() + 50);
                                            System.out.println(player.getNombre() + " ha regenerado 50MP");
                                        } else {
                                            player.setHP(player.getHP() + 100);
                                            player.setMP(player.getMP() + 100);
                                            System.out.println(player.getNombre() + " ha regenerado 100HP y 100MP");
                                        }
                                        
                                        mochila_main.remove(item);
                                        teams.setMochila(mochila_main);
                                        
                                        infligido = personaje.infligido(personaje.getHP(), player);
                                        player.setHP(player.getHP() - infligido);
                                        System.out.println(player.getNombre() + " ha recibido " + infligido + " puntos de daño, dejandole con " + player.getHP() + " HP");
                                        
                                        break;
                                    case 4:
                                        System.out.println("Reservas:");
                                        personaje.mostrarReservas(teams.getReservas());
                                        
                                        System.out.println("Que reserva desea adquirir?");
                                        int reserva = sc.nextInt();
                                        int lim_reserva = teams.getReservas().size() - 1;
                                        
                                        while (reserva < 0 || reserva > lim_reserva){
                                            System.out.println("Ingrese un numero de reserva valido");
                                            reserva = sc.nextInt();
                                        }
                                        
                                        System.out.println("A cambio de cual personaje de su Party lo desea adquirir?");
                                        System.out.println("Party:");
                                        personaje.mostrarStatsParty(teams.getParty());
                                        
                                        int cambio = sc.nextInt();
                                        int lim_cambio = teams.getParty().size() - 1;
                                        
                                        while (cambio < 0 || cambio > lim_cambio){
                                            System.out.println("Ingrese un numero de cambio valido");
                                            cambio = sc.nextInt();
                                        }
                                        
                                        personajes_main.add(teams.getReservas().get(reserva));
                                        reservas_main.add(teams.getParty().get(cambio));
                                        
                                        personajes_main.remove(cambio);
                                        reservas_main.remove(reserva);
                                        
                                        System.out.println("Cammbio hecho! Su nueva party es:");
                                        personaje.mostrarStatsParty(personajes_main);
                                        break;
                                }
                            }
                            
                            if (teams.getParty().isEmpty()){
                                System.out.println("Tu party ha muerto! Game over :(");
                                i = 21;
                            }
                            
                            break;
                            
                        case 2:
                            System.out.println("Has encontrado un cofre! Tiene una pocion!");
                            mochila_main.add(pocion);
                            teams.setMochila(mochila_main);
                            break;
                        case 3:
                            System.out.println("Has encontrado un cofre! Tiene un ether!");
                            mochila_main.add(ether);
                            teams.setMochila(mochila_main);
                            break;
                        case 4:
                            System.out.println("Has encontrado un cofre! Tiene un elixir!");
                            mochila_main.add(elixir);
                            teams.setMochila(mochila_main);
                            break;
                        case 5:
                            System.out.println("Has encontrado a tus amigos necesitados!");
                            
                            if (teams.getMochila().isEmpty()){
                                System.out.println("No tienes items para darle a tus amigos. Eres pobre.");
                            } else {
                                int limite_items = teams.getMochila().size();
                                int items_a_regalar = random.nextInt((limite_items - 1)+1)+1;
                                System.out.println("Has regalado " + items_a_regalar + " items a tus amigos!\nSon:");

                                for (int j = 0; j < items_a_regalar; j++){
                                    if (j == items_a_regalar - 1){
                                        System.out.println(mochila_main.get(0).getNombre());
                                    } else {
                                        System.out.print(mochila_main.get(0).getNombre() + ", ");
                                    }

                                    mochila_main.remove(0);
                                }

                                teams.setMochila(mochila_main);
                            }
                            
                            break;
                    }

                    while (true){
                        if (res == 's' || res == 'S' || res == 'n' || res == 'N'){
                            break;
                        } else {
                            System.out.println("Ingrese solo s o n");
                            res = sc.next().charAt(0);
                        }
                    }

                } else {
                    System.out.println("Te has rendido, game over :(");
                    i = 21;
                    break;
                }
            }
            
            if (teams.getParty().size() != 0 && (res != 'n')){
                if (res != 'N'){
                    System.out.println("Felicidades! Ha Vencido todos los 20 cuartos!");
                }
            }
            
            System.out.println("\n1. Kingdom Hearts\n2. Salir\n\nIngrese su opcion:");
            opcion = sc.nextInt();
            
            while (true){
                if (opcion == 1 || opcion == 2){
                    break;
                } else {
                    System.out.println("Ingresar 1 o 2");
                    opcion = sc.nextInt();
                }
            } 
            
        }
        
        System.out.println("Fin del programa");
    }
    
}
