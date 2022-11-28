package App;

import Clases.Menu;
import Enumeraciones.PokeTipo;
import Clases.Pokemon;
import Clases.PokemonAgua;
import Clases.PokemonElectrico;
import Clases.PokemonFuego;
import Clases.PokemonPlanta;
import Clases.PokemonVolador;
import Clases.Usuario;
import Utilidades.utilidad;
import java.util.ArrayList;


public class Start {
    public static ArrayList<Pokemon> pokemones = new ArrayList<Pokemon>();
    public static Usuario tenko;
    
    public Start(){
        llenado();
        
        //creando al adversario de juego
        tenko = new Usuario();
        tenko.setAlias("Tenko");
        tenko.setClave("pass");
        
        utilidad util = new utilidad();
        util.mensaje("Comenzando la aplicacion!");
        Menu men = new Menu();
        men.menu();
        
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
    
    public static double random(int min, int max){
        double number = (Math.random() * ((max - min) + 1)) + min;
        return (double)Math.round(number * 100d) / 100d;
    }
    
}


