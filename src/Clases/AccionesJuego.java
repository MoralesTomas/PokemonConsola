/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Utilidades.utilidad;

/**
 *
 * @author lenovo
 */
public class AccionesJuego {
    utilidad util = new utilidad(); 
    
    public void pelea(Pokemon atacante, Pokemon defensor,Usuario user){
        util.mensaje("Pelea!!!");
        System.out.println("Selecciona el ataque que desees utilizar:");
        for (int i = 0; i <atacante.getAtaques().length; i++) {
            System.out.println(">"+atacante.getAtaques()[i]);
        }
        
    }
}
