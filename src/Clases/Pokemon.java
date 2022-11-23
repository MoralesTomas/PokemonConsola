/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author lenovo
 */
public abstract class Pokemon {
    private String nombre;
    private double vida;
    private double defensa;
    private double precision;
    private PokeTipo tipo;
    private Ataque ataques [] = new Ataque[4];

    public Pokemon(String nombre, double vida, double defensa, double precision, PokeTipo tipo) {
        this.nombre = nombre;
        this.vida = vida;
        this.defensa = defensa;
        this.precision = precision;
        this.tipo = tipo;
    }
    
    public double atacar(double at){
        double ataque = 0;
        
        //calcular precision
        precision  = Math.floor(Math.random()*(90-30+1)+30);
        ataque = at + precision;
        return ataque;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public double getDefensa() {
        return defensa;
    }

    public void setDefensa(double defensa) {
        this.defensa = defensa;
    }

    public double getPrecision() {
        return precision;
    }

    public void setPrecision(double precision) {
        this.precision = precision;
    }

    public PokeTipo getTipo() {
        return tipo;
    }

    public void setTipo(PokeTipo tipo) {
        this.tipo = tipo;
    }

    public Ataque[] getAtaques() {
        return ataques;
    }

    public void setAtaques(Ataque[] ataques) {
        this.ataques = ataques;
    }
    
}