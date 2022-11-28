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
        System.out.println(sangria+"2.Ver mis pokemons");
        
        System.out.print(sangria +">");
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
        Scanner lector = new Scanner(System.in);
        
        System.out.println(sangria+"Digita el numero del pokemon que deseas cambiar");
        Ver_simple(sangria);
        System.out.print(sangria+">");
        int posicion = lector.nextInt();
        
        System.out.println(sangria+"Digira el numero del nuevo pokemon");
        util.mostrarPokemons(pokemones);
        System.out.print(sangria+">");
        int posicionNueva = lector.nextInt();
        cambioPokemon(posicion, posicionNueva);
        
    }
    
    public void Ver(String sangria_){
        for (int i = 0; i < user.getListaPokemons().length; i++) {
            user.getListaPokemons()[i].presentarse(i+1);
        }
    }
    
    public void Ver_simple(String sangria_){
        for (int i = 0; i < user.getListaPokemons().length; i++) {
            System.out.println(sangria_ + (i+1)+"."+user.getListaPokemons()[i].getNombre());
        }
    }
    
    public boolean cambioPokemon(int posCambio, int posNuevoPokemon){
        utilidad util = new utilidad();
        
        if(posCambio > 0 && posCambio < 7){
            if(posNuevoPokemon > 0 && posNuevoPokemon < pokemones.size()+1){
                user.getListaPokemons()[posCambio -1] = util.copiado( pokemones.get(posNuevoPokemon - 1) );
                util.mensaje("Nuevo pokemon agregado recientemente.");
                return true;
            }else{
                util.mensaje("Error al seleccionar numero de la posicion del listado general");
                return false;
            }
        }else{
            util.mensaje("Error al seleccionar numero de la posicion a cambiar");
            return false;
        }
    }
}
