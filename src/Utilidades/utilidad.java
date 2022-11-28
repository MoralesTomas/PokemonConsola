/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Clases.Pokemon;
import Clases.PokemonAgua;
import Clases.PokemonElectrico;
import Clases.PokemonFuego;
import Clases.PokemonPlanta;
import Clases.PokemonVolador;
import Enumeraciones.PokeTipo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author lenovo
 */
public class utilidad {
    
    
    
    public boolean EditPokemon(ArrayList<Pokemon> listado,String Nombre, Pokemon nuevo){
        for (int i = 0; i < listado.size(); i++) {
            if(listado.get(i).getNombre().equals(Nombre)){
                listado.set(i, nuevo);
                mensaje("Pokemon actualizado exitosamente");
                return true;
            }
        }
        System.out.println("No se encontro al pokemon con el nombre: "+Nombre);
        return false;
    }
    
    public boolean DeletePokemon(ArrayList<Pokemon> listado,String Nombre){
        for (int i = 0; i < listado.size(); i++) {
            if(listado.get(i).getNombre().equals(Nombre)){
                listado.remove(i);
                mensaje("Pokemon eliminado exitosamente");
                return true;
            }
        }
        return false;
    }
    
    public void mensaje(String mensaje){
        String marco = "";
        for (int i = 0; i < mensaje.length()+4; i++) {
            marco += "=";
        }
        System.out.println(marco);
        System.out.println("| "+mensaje+" |");
        System.out.println(marco);
    }
    
    public void mostrarPokemons(ArrayList<Pokemon> listado){
        mensaje("Listado de pokemons");
        for (int i = 0; i < listado.size(); i++) {
            System.out.println((i+1) + "." + listado.get(i).toString());
        }
        mensaje("Fin de listado...");
    }
    
    public void ordenarPokemon(ArrayList<Pokemon> listado){
        Collections.sort(listado, (Pokemon p1, Pokemon p2) -> p1.getNombre().compareTo(p2.getNombre()));
    }
    
    public Pokemon buscarPokemonPorNombre(ArrayList<Pokemon> listado, String Nombre){
        for (int i = 0; i < listado.size(); i++) {
            if(listado.get(i).getNombre().equals(Nombre)){
                return listado.get(i);
            }
        }
        return null;
    }
    
    public PokeTipo seleccionPokeTipo(String sangria){
        PokeTipo tipo;
        System.out.println(sangria+"Ingrese el tipo del pokemon digitando el numero del tipo");
        System.out.println(sangria+"1."+PokeTipo.Agua);
        System.out.println(sangria+"2."+PokeTipo.Fuego);
        System.out.println(sangria+"3."+PokeTipo.Planta);
        System.out.println(sangria+"4."+PokeTipo.Electrico);
        System.out.println(sangria+"5."+PokeTipo.Volador);
        
        
        Scanner lector = new Scanner(System.in);
        System.out.print(sangria+">");
        int opcion = lector.nextInt();
        switch(opcion){
            case 1:
                tipo = PokeTipo.Agua;
                break;
            case 2:
                tipo = PokeTipo.Fuego;
                break;
            case 3:
                tipo = PokeTipo.Planta;
                break;
            case 4:
                tipo = PokeTipo.Electrico;
                break;
            case 5:
                tipo = PokeTipo.Volador;
                break;
            default:
                System.out.println(sangria+"Opcion erronea ");
                tipo = PokeTipo.Agua;
                break;
        }
        return tipo;
    }
    
    public Pokemon copiado(PokemonAgua base){
        Pokemon result = new PokemonAgua(base.getNombre(),base.getVida(),base.getDefensa(),base.getPrecision(),base.getTipo());
        return result;
    }
    
    public Pokemon copiado(PokemonFuego base){
        Pokemon result = new PokemonFuego(base.getNombre(),base.getVida(),base.getDefensa(),base.getPrecision(),base.getTipo());
        return result;
    }
    
    public Pokemon copiado(PokemonPlanta base){
        Pokemon result = new PokemonPlanta(base.getNombre(),base.getVida(),base.getDefensa(),base.getPrecision(),base.getTipo());
        return result;
    }
    
    public Pokemon copiado(PokemonElectrico base){
        Pokemon result = new PokemonElectrico(base.getNombre(),base.getVida(),base.getDefensa(),base.getPrecision(),base.getTipo());
        return result;
    }
    
    public Pokemon copiado(PokemonVolador base){
        Pokemon result = new PokemonVolador(base.getNombre(),base.getVida(),base.getDefensa(),base.getPrecision(),base.getTipo());
        return result;
    }
    
    public Pokemon copiado(Pokemon base){
        
        if( base.getTipo() == PokeTipo.Agua ){
            return copiado( (PokemonAgua) base );
            
        }else if( base.getTipo() == PokeTipo.Fuego ){
            return copiado( (PokemonFuego) base );
            
        }else if( base.getTipo() == PokeTipo.Planta ){
            return copiado( (PokemonPlanta) base );
            
        }else if( base.getTipo() == PokeTipo.Electrico ){
            return copiado( (PokemonElectrico) base );
            
        }else if( base.getTipo() == PokeTipo.Volador ){
            return copiado( (PokemonVolador) base );
        }
        return null;
    }
    
   public void notificacion(String mensaje){
        String marco = "";
        for (int i = 0; i < mensaje.length()+4; i++) {
            marco += "-";
        }
        System.out.println(marco);
        System.out.println("/ "+mensaje+" /");
        System.out.println(marco);
    }
   
   public void round(String mensaje){
        String marco = "";
        for (int i = 0; i < mensaje.length()+4; i++) {
            marco += "#";
        }
        System.out.println(marco);
        System.out.println("# "+mensaje+" #");
        System.out.println(marco);
    }
   
   public void apartador(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
   
   public void datosPantalla(Pokemon a, Pokemon b){
       System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
       System.out.println("Tu pokemon: "+a.getNombre());
       System.out.println("Su vida: "+a.getVida());
       System.out.println("Su defensa: "+a.getDefensa());
       System.out.println("Su tipo: "+a.getTipo());
       System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
       System.out.println("El pokemon contrario: "+b.getNombre());
       System.out.println("Vida del pokemon contrario: "+b.getVida());
       System.out.println("Defensa del pokemon contrario: "+b.getDefensa());
       System.out.println("Tipo del pokemon contrario: "+b.getTipo());
       System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
   }
}
