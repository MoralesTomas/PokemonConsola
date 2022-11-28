
package Clases;

import static App.Start.pokemones;
import java.util.ArrayList;
import static App.Start.random;
import Enumeraciones.PokeTipo;
import Utilidades.utilidad;

public class Usuario {
    private String alias;
    private String clave;
    private Pokemon [] listaPokemons = new Pokemon [6];
    
    public Usuario(){
        preCarga();
    }
    
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Pokemon[] getListaPokemons() {
        return listaPokemons;
    }

    public void setListaPokemons(Pokemon[] listaPokemons) {
        this.listaPokemons = listaPokemons;
    }
    
    public void preCarga(){
        utilidad util = new utilidad();
        
        for (int i = 0; i < 6; i++) {
            while(true){
                try{
                    int j = (int) random(0,pokemones.size());
                    this.getListaPokemons()[i] = util.copiado( pokemones.get(j) );
                    break;
                }catch(Exception e){
                    
                }
            }
        }
    }
}
