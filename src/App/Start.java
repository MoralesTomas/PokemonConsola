package App;

import Clases.PokeTipo;
import Clases.Pokemon;
import Clases.PokemonAgua;
import java.util.ArrayList;


public class Start {
    ArrayList<Pokemon> pokemones = new ArrayList<Pokemon>();
    
    public Start(){
        llenado();
    }
    
    public void llenado(){
        pokemones.add(new PokemonAgua("Squirtle", random(300,500), random(200,300) , 0, PokeTipo.Agua));
        pokemones.add(new PokemonAgua("Poliwhirl", random(300,500), random(200,300) , 0, PokeTipo.Agua));
        pokemones.add(new PokemonAgua("Blastoise", random(300,500), random(200,300) , 0, PokeTipo.Agua));
        
        pokemones.add(new PokemonAgua("Charmander", random(300,500), random(200,300) , 0, PokeTipo.Fuego));
        pokemones.add(new PokemonAgua("Charmeleon", random(300,500), random(200,300) , 0, PokeTipo.Fuego));
        pokemones.add(new PokemonAgua("Magmar", random(300,500), random(200,300) , 0, PokeTipo.Fuego));
        
        pokemones.add(new PokemonAgua("Bulbasaur", random(300,500), random(200,300) , 0, PokeTipo.Planta));
        pokemones.add(new PokemonAgua("Turtwig", random(300,500), random(200,300) , 0, PokeTipo.Planta));
        pokemones.add(new PokemonAgua("Venusaur", random(300,500), random(200,300) , 0, PokeTipo.Planta));
        
        pokemones.add(new PokemonAgua("Pikachu", random(300,500), random(200,300) , 0, PokeTipo.Electrico));
        pokemones.add(new PokemonAgua("Raichu", random(300,500), random(200,300) , 0, PokeTipo.Electrico));
        pokemones.add(new PokemonAgua("Voltorb", random(300,500), random(200,300) , 0, PokeTipo.Electrico));
        
        pokemones.add(new PokemonAgua("Pidgey", random(300,500), random(200,300) , 0, PokeTipo.Volador));
        pokemones.add(new PokemonAgua("Golbat", random(300,500), random(200,300) , 0, PokeTipo.Volador));
        pokemones.add(new PokemonAgua("Zubat", random(300,500), random(200,300) , 0, PokeTipo.Volador));
    }
    
    public double random(int int1, int int2){
        return Math.floor(Math.random()*(int2-int1+1)+int2);
    }
    
}


