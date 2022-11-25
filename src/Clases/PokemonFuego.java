/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Enumeraciones.Compatibilidad;
import Enumeraciones.PokeTipo;

/**
 *
 * @author lenovo
 */
public class PokemonFuego extends Pokemon {
    
    public PokemonFuego(String nombre, double vida, double defensa, double precision, PokeTipo tipo) {
        super(nombre, vida, defensa, precision, tipo);
        cargarAtaques();
    }
    
    private void cargarAtaques(){
        Ataque ataques [] = getAtaques();
        ataques[0] = new Ataque("Ataque fisico",40);
        ataques[1] = new Ataque("Ataque elemental",58);
        ataques[2] = new Ataque("Ataque especial",76);
        ataques[3] = new Ataque("Ataque base",25);
        
        setAtaques(ataques);
    }
    
    public void recibirAtaque(double danio, PokeTipo tipo){
        
        /*
        Neutro : 
                el danio va solo a la defensa del pokemon y si esta llega a 0 entonces se toma tambien
                los puntos de vida del pokemon.
        
        Superior:
                el danio va a ser el doble aplica lo mismo del neutro pero el danio es por dos.
        
        Inferior:
                el danio va a ser de la mitad y aplica lo mismo del neutro a la defensa.
                    
        */
        
        
        Compatibilidad comp = Compatibilidad.neutro;
        
        if(tipo == PokeTipo.Agua){
            //superior
            comp = Compatibilidad.superior;
            
        } else if( tipo == PokeTipo.Fuego){
            //neutro
            comp = Compatibilidad.neutro;
            
        }else if( tipo == PokeTipo.Planta){
            //inferior
            comp = Compatibilidad.inferior;
            
        }else if( tipo == PokeTipo.Electrico){
            //neutro
            comp = Compatibilidad.neutro;
            
        }else if( tipo == PokeTipo.Volador){
            //neutro
            comp = Compatibilidad.neutro;
            
        }
        
        //ahora a calcular el danio.
        
        if(comp == Compatibilidad.superior){
            danio = danio * 2;
        }else if( comp == Compatibilidad.inferior){
            danio = danio * 0.5;
        }
        
        //ahora si tomar el golpe
        double result = getDefensa() - danio;
        if(result < 0){
            //setear defensa a cero
            setDefensa(0);

            //restar el valor del danio 
            setVida(getVida() - result);
            if(getVida() < 0){
                setVida(0);
            }
        }else{
            setDefensa(result);
        }
        
    }
    
}
