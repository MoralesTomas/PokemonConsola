/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import static App.Start.random;
import static App.Start.tenko;
import Enumeraciones.PokeTipo;
import Utilidades.utilidad;
import java.util.Scanner;

/**
 *
 * @author lenovo
 */
public class AccionesJuego {

    utilidad util = new utilidad();
    Usuario user;
    Pokemon seleccionado;
    Pokemon seleccionMaquina;
    
    public AccionesJuego(Usuario user) {
        this.user = user;
    }

    public void inicioMenuPelea() {
        util.mensaje("Comenzando a jugar");
        seleccionado = seleccionPokemon();
        if(seleccionado == null){
            util.mensaje("No tienes Pokemons para jugar");
        }else{
            
            //seleccion de la maquina
            seleccionMaquina = seleccionPokemonMaquina();
            
            //ahora la simulacion
            simulacionJuego();
        }
    }
    
    public void simulacionJuego(){
        Scanner lector = new Scanner(System.in);
        
        int turno  = 0;
        boolean continuar = true;
        while( continuar ){
            
            if(turno % 2 == 0){
                util.datosPantalla(seleccionado, seleccionMaquina);
                if( !seleccionado.isVivo() ){
                    seleccionado = seleccionPokemon();
                    if( seleccionado == null){
                        util.mensaje("PERDISTE :c");
                        break;
                    }
                }
                continuar = turnoUsuario();
                System.out.println("\nPresiona ENTER para continuar\n");
                lector.nextLine();
            }
            else{
                if( !seleccionMaquina.isVivo() ){
                    seleccionMaquina = seleccionPokemonMaquina();
                    if( seleccionMaquina == null){
                        util.mensaje("GANASTE :D");
                        break;
                    }
                }
                util.mensaje("<--TURNO DE LA MAQUINA-->");
                continuar = turnoMaquina(seleccionMaquina, seleccionado, tenko);
            }
            turno ++;
        }
    }
    
    public boolean turnoMaquina(Pokemon atacante, Pokemon defensor, Usuario user) {

        //elegir de manera aleatoria el ataque
        int num_ataque = (int) random(0, 3);
        while (num_ataque > 3 && num_ataque < 0) {
            num_ataque = (int) random(0, 3);
        }

        //codigo copia
        util.mensaje("Pelea!!!");
        double valor_ataque = atacante.atacar(atacante.getAtaques()[num_ataque].getDanio());

        //preparando simulacion de defensa
        def_simu(defensor, atacante.getTipo(), valor_ataque);

        //ver como quedo el defensor
        util.round("Resultados del ataque...");
        util.notificacion("Defensa de pokemon de la maquina: " + atacante.getDefensa());
        util.notificacion("Vida de pokemon de la maquina: " + atacante.getVida());
        util.apartador();
        util.notificacion("Defensa tu pokemon: " + defensor.getDefensa());
        util.notificacion("Vida tu pokemon: " + defensor.getVida());

        //fin codigo copia
        return true;
    }
    
    public boolean turnoUsuario(){
        Scanner lector = new Scanner(System.in);
        
        System.out.println("Selecciona que quieres hacer:");
        System.out.println("1.Lucha");
        System.out.println("2.Cambiar de pokemon");
        System.out.println("3.Huir");
        
        int opcion = lector.nextInt();
        
        if( opcion > 0 && opcion < 4){
            
            if( opcion == 1){
                pelea(seleccionado, seleccionMaquina, user);
                return true;
            }else if( opcion == 2){
                seleccionado = seleccionPokemon();
                return true;
            }else{
                return false;
            }
            
        }else{
            util.notificacion("Seleccion incorrecta intenta nuevamente...");
            return turnoUsuario();
        }
        
    }

    public Pokemon seleccionPokemonMaquina(){
        int x = 0;
        while( x < tenko.getListaPokemons().length){
            Pokemon tmp = tenko.getListaPokemons()[x];
            if( tmp.isVivo() ){
                return tmp;
            }else{
                x++;
            }
        }
        return null;
    }
    
    public Pokemon seleccionPokemon() {
        util.mensaje("Selecciona tu pokemon");
        Scanner lector = new Scanner(System.in);

        boolean seguirJugando = false;

        for (int i = 0; i < user.getListaPokemons().length; i++) {
            Pokemon tmp = user.getListaPokemons()[i];

            if (tmp.isVivo()) {
                System.out.println((i + 1) + "." + tmp.getNombre() + " tipo: " + tmp.getTipo());
                seguirJugando = true;
            }
        }

        if ( seguirJugando ) {
            System.out.print(">");
            int sel = lector.nextInt();
            if (sel > 0 && sel < 7) {
                sel--;
                Pokemon tmp = user.getListaPokemons()[sel];
                if (tmp.isVivo()) {
                    return tmp;
                } else {
                    util.notificacion("Eleccion erronea intenta nuevamente...");
                    return seleccionPokemon();
                }
            } else {
                util.notificacion("Eleccion erronea intenta nuevamente...");
                return seleccionPokemon();
            }
        }
        return null;
    }
    //usuario
    public void pelea(Pokemon atacante, Pokemon defensor, Usuario user) {
        util.mensaje("Pelea!!!");
        Scanner lector = new Scanner(System.in);

        System.out.println("Selecciona el ataque que desees utilizar:");
        for (int i = 0; i < atacante.getAtaques().length; i++) {
            System.out.println(( i + 1 ) + "." + atacante.getAtaques()[i].getNombre());
        }
        int ataque = 0;

        while (true) {
            System.out.print(">");
            ataque = lector.nextInt();
            if (ataque > 0 && ataque < 5) {
                //posicion del ataque
                ataque--;

                //calcular el danio
                double valor_ataque = atacante.atacar(atacante.getAtaques()[ataque].getDanio());

                //preparando simulacion de defensa
                def_simu(defensor, atacante.getTipo(), valor_ataque);

                //ver como quedo el defensor
                util.round("Resultados del ataque...");
                util.notificacion("Defensa de tu pokemon: " + atacante.getDefensa());
                util.notificacion("Vida de tu pokemon: " + atacante.getVida());
                util.apartador();
                util.notificacion("Defensa del pokemon atacado: " + defensor.getDefensa());
                util.notificacion("Vida del pokemon atacado: " + defensor.getVida());
                break;

            } else {
                System.out.println("Selecciona un ataque valido");
            }
        }

    }

    public void def_simu(Pokemon defensor, PokeTipo atacante, double ataque) {

        if (defensor.getTipo() == PokeTipo.Agua) {
            PokemonAgua tmp = (PokemonAgua) defensor;
            tmp.recibirAtaque(ataque, atacante);
        }
        if (defensor.getTipo() == PokeTipo.Fuego) {
            PokemonFuego tmp = (PokemonFuego) defensor;
            tmp.recibirAtaque(ataque, atacante);
        }
        if (defensor.getTipo() == PokeTipo.Planta) {
            PokemonPlanta tmp = (PokemonPlanta) defensor;
            tmp.recibirAtaque(ataque, atacante);
        }
        if (defensor.getTipo() == PokeTipo.Electrico) {
            PokemonElectrico tmp = (PokemonElectrico) defensor;
            tmp.recibirAtaque(ataque, atacante);
        }
        if (defensor.getTipo() == PokeTipo.Volador) {
            PokemonVolador tmp = (PokemonVolador) defensor;
            tmp.recibirAtaque(ataque, atacante);
        }
    }

}
