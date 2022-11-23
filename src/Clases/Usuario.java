
package Clases;

import java.util.ArrayList;

public class Usuario {
    private String alias;
    private Pokemon [] listaPokemons = new Pokemon [6];

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
}
