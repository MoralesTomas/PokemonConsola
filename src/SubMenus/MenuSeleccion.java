/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SubMenus;

import static App.Start.pokemones;
import Clases.Usuario;
import Utilidades.utilidad;
import java.util.Scanner;

/**
 *
 * @author lenovo
 */
public class MenuSeleccion {
    
    utilidad util = new utilidad();
    Usuario user;
    
    public MenuSeleccion(Usuario user){
        this.user = user;
    }
    
    public void menuSel(){
        String sangria = "\t\t";
        Scanner lector = new Scanner(System.in);
        util.mensaje("Menu de seleccion");
        
        System.out.println(sangria+"Selecciona lo que desees hacer.");
        System.out.println(sangria+"1.Seleccionar pokemons");
        System.out.println("2.Ver mis pokemons");
        
        int sel = lector.nextInt();
        desicion(sel,sangria);
    }
    
    public boolean desicion(int desicion,String sangria){
        switch(desicion){
            case 1:
                Sel(sangria);
                break;
            case 2:
                Ver(sangria);
                break;
            default:
                util.mensaje("opcion incorrecta...");
                break;
        }
        return false;
    }
    
    public void Sel(String sangria_){
        String sangria = sangria_ + "\t";
        System.out.println(sangria+"Digita el numero del pokemon que deseas cambiar");
        
    }
    
    public void Ver(String sangria_){
        String sangria = sangria_ + "\t";
        for (int i = 0; i < 10; i++) {
            
        }
    }
}
