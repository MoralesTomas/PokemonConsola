/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SubMenus;

import Clases.PokeTipo;
import Utilidades.utilidad;
import java.util.Scanner;

/**
 *
 * @author lenovo
 */
public class MenuPokemones {
    
    utilidad util = new utilidad();
    
    public void menuP(){
        String sangria = "\t\t";
        util.mensaje("Menu de pokemons");
        System.out.println(sangria+"Selecciona lo que desees hacer.");
        System.out.println(sangria+"1.Agregar pokemon");
        System.out.println(sangria+"2.Eliminar pokemon");
        System.out.println(sangria+"3.Editar pokemon");
        System.out.println(sangria+"4.Ver listado de pokemons");
        System.out.println(sangria+"5.Ordenar listado de pokemons");
        
        
    }
    
    public boolean desicion(int desicion,String sangria){
        switch(desicion){
            case 1:
                Add(sangria);
                break;
        }
        
        return false;
    }
    
    public void Add(String sangria){
        sangria += "\t";
        
        //datos para el pokemon
        //String nombre, double vida, double defensa, double precision, PokeTipo tipo
        String nombre;
        PokeTipo tipo;
        
        
        Scanner lector = new Scanner(System.in);
        System.out.println(sangria+"Ingrese el nombre del pokemon:");
        System.out.print(">");
        
    }
}
