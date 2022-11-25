/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SubMenus;

import App.Start;
import static App.Start.pokemones;
import static App.Start.random;
import Clases.Menu;
import Clases.Pokemon;
import Clases.PokemonVolador;
import Enumeraciones.PokeTipo;
import Utilidades.utilidad;
import java.util.Scanner;

/**
 *
 * @author lenovo
 */
public class MenuPokemones {
    Menu menu = new Menu();
    utilidad util = new utilidad();
    
    public void menuP(){
        String sangria = "\t\t";
        Scanner lector = new Scanner(System.in);
        util.mensaje("Menu de pokemons");
        
        System.out.println(sangria+"Selecciona lo que desees hacer.");
        System.out.println(sangria+"1.Agregar pokemon");
        System.out.println(sangria+"2.Eliminar pokemon");
        System.out.println(sangria+"3.Editar pokemon");
        System.out.println(sangria+"4.Ver listado de pokemons");
        System.out.println(sangria+"5.Ordenar listado de pokemons");
        System.out.println(sangria+"6.Buscar pokemon");
        System.out.print(sangria+">");
        int sel = lector.nextInt();
        desicion(sel,sangria);
    }
    
    public boolean desicion(int desicion,String sangria){
        switch(desicion){
            case 1:
                Add(sangria);
                menu.inicioSesionExitoso();
                break;
            case 2:
                Delete(sangria);
                menu.inicioSesionExitoso();
                break;
            case 3:
                Edit(sangria);
                menu.inicioSesionExitoso();
                break;
            case 4:
                util.mostrarPokemons(pokemones);
                menu.inicioSesionExitoso();
                break;
            case 5:
                util.ordenarPokemon(pokemones);
                menu.inicioSesionExitoso();
                break;
            case 6:
                buscar(sangria);
                break;
            default:
                util.mensaje("opcion incorrecta...");
                break;
        }
        
        return false;
    }
    
    public void Add(String sangria_){
        String sangria = sangria_ + "\t";
        
        String nombre;
        PokeTipo tipo;
        
        
        //pokemones.add(new PokemonAgua("Squirtle", random(300,500), random(200,300) , 0, PokeTipo.Agua));
        
        Scanner lector = new Scanner(System.in);
        System.out.println(sangria+"Ingrese el nombre del pokemon:");
        
        System.out.print(sangria+">");
        nombre = lector.nextLine();
        
        System.out.println("");
        tipo = util.seleccionPokeTipo(sangria);
        
        //validar que no se repita el pokemon.
        if(!existePokemon(nombre)){
            util.mensaje(sangria+"Pokemon agregado correctamente");
            pokemones.add(new PokemonVolador(nombre, random(300,500), random(200,300) , 0, tipo));
        }else{
            util.mensaje(sangria+"No se pudo agregar al pokemon");
            util.mensaje(sangria+"Ya existe un pokemon con este nombre");
        }
        
        
    }
    
    public void Delete(String sangria_){
        String sangria = sangria_ + "\t";
        System.out.println(sangria+"Ingrese el nombre del pokemon que desee eliminar");
        System.out.print(sangria+">");
        
        Scanner lector = new Scanner(System.in);
        String nombre = lector.nextLine();
        
        if(!util.DeletePokemon(pokemones, nombre)){
            util.mensaje(sangria+"No se pudo ejecutar la peticion");
        }
    }
    
    public void Edit(String sangria_){
        String sangria = sangria_ + "\t";
        Scanner lector = new Scanner(System.in);
        
        System.out.println(sangria+"Ingresa el nombre del pokemon que deseas editar");
        System.out.print(sangria+">");
        
        String nombre = lector.nextLine();
        
        System.out.println("Ingresa el nuevo tipo del pokemon");
        System.out.print(sangria+">");
        
        PokeTipo tipo = util.seleccionPokeTipo(sangria);
        
        Pokemon tmp = new PokemonVolador(nombre, random(300,500), random(200,300) , 0, tipo);
        
        if(!util.EditPokemon(pokemones, nombre, tmp)){
            util.mensaje(sangria+"No se pudo ejecutar la peticion");
        }
    }
    
    public void buscar(String sangria_){
        String sangria = sangria_ + "\t";
        Scanner lector = new Scanner(System.in);
        
        System.out.println(sangria+"Ingresa el nombre del pokemon que deseas buscar");
        System.out.print(sangria+">");
        
        String nombre = lector.nextLine();
        util.buscarPokemonPorNombre(pokemones, nombre).presentarse();
    }
    
    public boolean existePokemon(String nombre){
        for (int i = 0; i < pokemones.size(); i++) {
            if(pokemones.get(i).getNombre().equals(nombre)){
                return true;
            }
        }
        return false;
    }
}
