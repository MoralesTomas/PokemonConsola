/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Clases.Pokemon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author lenovo
 */
public class utilidad {
    
    public boolean AddPokemon(ArrayList<Pokemon> listado, Pokemon nuevo){
        listado.add(nuevo);
        mensaje("Pokemon agregado exitosamente");
        return true;
    }
    
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
            System.out.println(listado.get(i).toString());
        }
        mensaje("Fin de listado...");
    }
    
    public void ordenarPokemon(ArrayList<Pokemon> listado){
        Collections.sort(listado, (Pokemon p1, Pokemon p2) -> p1.getNombre().compareTo(p2.getNombre()));
    }
}
