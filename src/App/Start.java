package App;

import Clases.PokeTipo;
import Clases.Pokemon;
import Clases.PokemonAgua;
import Clases.PokemonElectrico;
import Clases.PokemonFuego;
import Clases.PokemonPlanta;
import Clases.PokemonVolador;
import Utilidades.utilidad;
import java.util.ArrayList;


public class Start {
    ArrayList<Pokemon> pokemones = new ArrayList<Pokemon>();
    
    public Start(){
        llenado();
        utilidad util = new utilidad();
    }
    
    public void llenado(){
        pokemones.add(new PokemonAgua("Squirtle", random(300,500), random(200,300) , 0, PokeTipo.Agua));
        pokemones.add(new PokemonAgua("Poliwhirl", random(300,500), random(200,300) , 0, PokeTipo.Agua));
        pokemones.add(new PokemonAgua("Blastoise", random(300,500), random(200,300) , 0, PokeTipo.Agua));
        
        pokemones.add(new PokemonFuego("Charmander", random(300,500), random(200,300) , 0, PokeTipo.Fuego));
        pokemones.add(new PokemonFuego("Charmeleon", random(300,500), random(200,300) , 0, PokeTipo.Fuego));
        pokemones.add(new PokemonFuego("Magmar", random(300,500), random(200,300) , 0, PokeTipo.Fuego));
        
        pokemones.add(new PokemonPlanta("Bulbasaur", random(300,500), random(200,300) , 0, PokeTipo.Planta));
        pokemones.add(new PokemonPlanta("Turtwig", random(300,500), random(200,300) , 0, PokeTipo.Planta));
        pokemones.add(new PokemonPlanta("Venusaur", random(300,500), random(200,300) , 0, PokeTipo.Planta));
        
        pokemones.add(new PokemonElectrico("Pikachu", random(300,500), random(200,300) , 0, PokeTipo.Electrico));
        pokemones.add(new PokemonElectrico("Raichu", random(300,500), random(200,300) , 0, PokeTipo.Electrico));
        pokemones.add(new PokemonElectrico("Voltorb", random(300,500), random(200,300) , 0, PokeTipo.Electrico));
        
        pokemones.add(new PokemonVolador("Pidgey", random(300,500), random(200,300) , 0, PokeTipo.Volador));
        pokemones.add(new PokemonVolador("Golbat", random(300,500), random(200,300) , 0, PokeTipo.Volador));
        pokemones.add(new PokemonVolador("Zubat", random(300,500), random(200,300) , 0, PokeTipo.Volador));
    }
    
    public double random(int int1, int int2){
        return Math.floor(Math.random()*(int2-int1+1)+int2);
    }
    
}


